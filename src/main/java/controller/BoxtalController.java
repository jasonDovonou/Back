package controller;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import model.boxtal.Carriers;
import model.boxtal.Cotation;
import model.boxtal.Offer;
import model.boxtal.Point;
import model.response.BoxtalResponse;


@RestController
@RequestMapping(value = "/public/boxy")
public class BoxtalController {

	@GetMapping(produces = "application/json")
	public ResponseEntity<BoxtalResponse> boxy(@RequestParam String country,
			@RequestParam String cp, @RequestParam String ville, @RequestParam String poids,
			@RequestParam String street) throws Exception {
		return ResponseEntity.ok(new BoxtalResponse(listpoints(country, cp, ville, "MONR")));
	}

	@GetMapping(value = "/international", produces = "application/json")
	public ResponseEntity<BoxtalResponse> boxyInternational(@RequestParam String country,
			@RequestParam String cp, @RequestParam String ville, @RequestParam String poids,
			@RequestParam String street) throws Exception {
		return ResponseEntity.ok(cotateAndListpoints(country, cp, ville, poids, street));
	}

	private BoxtalResponse cotateAndListpoints(String country, String cp, String ville,
			String poids, String street) throws Exception {
		final String url = "https://www.envoimoinscher.com/api/v1/cotation";
		String date = getTomorrowDate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				.queryParam("expediteur.pays", "FR").queryParam("expediteur.code_postal", "44000")
				.queryParam("expediteur.ville", "Nantes")
				.queryParam("expediteur.type", "entreprise").queryParam("expediteur.adresse", "rue")
				.queryParam("destinataire.pays", country).queryParam("destinataire.code_postal", cp)
				.queryParam("destinataire.ville", ville)
				.queryParam("destinataire.type", "particulier")
				.queryParam("destinataire.adresse", "rue").queryParam("colis_1.poids", poids)
				.queryParam("colis_1.longueur", "35").queryParam("colis_1.largeur", "25")
				.queryParam("colis_1.hauteur", "10").queryParam("code_contenu", "40000")
				.queryParam("collecte", date);

		ResponseEntity<String> result = getBoxtal(builder);

		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(Cotation.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Cotation cotation = (Cotation) jaxbUnmarshaller
				.unmarshal(new StringReader(result.getBody()));

		Offer home;
		Offer relais;

		if ("PICKUP_POINT".equals(
				cotation.getShipment().getOffer().get(0).getDelivery().getType().getCode())) {
			relais = cotation.getShipment().getOffer().get(0);
			home = findOtherOffer(cotation, relais);
		} else {
			home = cotation.getShipment().getOffer().get(0);
			relais = findOtherOffer(cotation, home);
		}

		BoxtalResponse response = new BoxtalResponse(home, relais);
		if (relais != null)
			response.setPoints(listpoints(country, cp, ville, relais.getOperator().getCode()));
		return response;
	}

	private List<Point> listpoints(String country, String cp, String ville, String operator)
			throws JAXBException {
		final String url = "https://test.envoimoinscher.com/api/v1/listpoints";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				.queryParam("pays", country).queryParam("cp", cp).queryParam("ville", ville)
				.queryParam("carriers", operator).queryParam("collecte", "dest");

		ResponseEntity<String> result = getBoxtal(builder);
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(Carriers.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Carriers carriers = (Carriers) jaxbUnmarshaller
				.unmarshal(new StringReader(result.getBody()));
		return carriers.getCarrier().getPoints().getPointList();

	}

	private ResponseEntity<String> getBoxtal(UriComponentsBuilder builder) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("access_key", "ftvvg32h");
		headers.set("Authorization", "Basic amVyaWNoby5naXBzeUBob3RtYWlsLmZyOkJsYWNrc3RlcjEh");
		headers.setAccept(Arrays.asList((MediaType.APPLICATION_XML)));
		HttpEntity<?> entity = new HttpEntity<>(headers);
		return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
	}

	private Offer findOtherOffer(Cotation cotation, Offer firstOffer) {
		Offer secondOffer = null;
		for (int i = 1; i < cotation.getShipment().getOffer().size(); i++) {
			if (!firstOffer.getDelivery().getType().getCode().equals(
					cotation.getShipment().getOffer().get(i).getDelivery().getType().getCode())) {

				secondOffer = cotation.getShipment().getOffer().get(i);
				break;
			}
		}
		return secondOffer;
	}

	private String getTomorrowDate() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(dt);
	}
}
