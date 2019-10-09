package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Admin;
import model.Article;
import model.Carticle;
import model.Lot;
import model.Orders;
import model.article.Black;
import model.article.Blue;
import model.article.Brown;
import model.article.Gold;
import model.article.Green;
import model.article.Grey;
import model.article.News;
import model.article.Orange;
import model.article.Promotion;
import model.article.Purple;
import model.article.Red;
import model.article.White;
import model.article.Yellow;
import repository.AdminRepository;
import repository.OrderRepo;
import repository.article.BlackRepo;
import repository.article.BlueRepo;
import repository.article.BrownRepo;
import repository.article.GoldRepo;
import repository.article.GreenRepo;
import repository.article.GreyRepo;
import repository.article.NewsRepo;
import repository.article.OrangeRepo;
import repository.article.PromotionRepo;
import repository.article.PurpleRepo;
import repository.article.RedRepo;
import repository.article.WhiteRepo;
import repository.article.YellowRepo;
import util.RandomString;
import util.Utils;

@RestController
@RequestMapping("/public")
public class PublicController {

	@Value("${path.photo}")
	private String path;

	@Autowired
	WhiteRepo white;

	@Autowired
	GreyRepo grey;

	@Autowired
	BlueRepo blue;

	@Autowired
	RedRepo red;

	@Autowired
	BlackRepo black;

	@Autowired
	OrderRepo order;

	@Autowired
	OrangeRepo orange;

	@Autowired
	BrownRepo brown;

	@Autowired
	YellowRepo yellow;

	@Autowired
	GreenRepo green;

	@Autowired
	PurpleRepo purple;

	@Autowired
	GoldRepo gold;

	@Autowired
	PromotionRepo promotion;

	@Autowired
	NewsRepo news;

	@Autowired
	private AdminRepository admin;

	@GetMapping(value = "/search/{search}", produces = "application/json")
	public ResponseEntity<List<Article>> search(@PathVariable("search") String search)
			throws IOException {

		List<Article> articles = new ArrayList<>();

		articles.addAll(white.searchByName(search));
		articles.addAll(grey.searchByName(search));
		articles.addAll(blue.searchByName(search));
		articles.addAll(red.searchByName(search));
		articles.addAll(black.searchByName(search));
		articles.addAll(green.searchByName(search));
		articles.addAll(yellow.searchByName(search));
		articles.addAll(brown.searchByName(search));
		articles.addAll(orange.searchByName(search));
		articles.addAll(purple.searchByName(search));
		articles.addAll(gold.searchByName(search));

		return ResponseEntity.ok(articles);
	}

	@GetMapping(value = "/red", produces = "application/json")
	public ResponseEntity<List<Red>> getRedsPublic() throws IOException {
		return ResponseEntity.ok(red.findAllActivated());
	}

	@GetMapping(value = "/red/{name}", produces = "application/json")
	public ResponseEntity<Red> getRedPublic(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(red.findByName(name));
	}

	@GetMapping(value = "/white", produces = "application/json")
	public ResponseEntity<List<White>> getWhitesPublic() throws IOException {
		return ResponseEntity.ok(white.findAllActivated());
	}

	@GetMapping(value = "/white/{name}", produces = "application/json")
	public ResponseEntity<White> getWhitePublic(@PathVariable("name") String name)
			throws IOException {
		return ResponseEntity.ok(white.findByName(name));
	}

	@GetMapping(value = "/purple", produces = "application/json")
	public ResponseEntity<List<Purple>> getPurplesPublic() throws IOException {
		return ResponseEntity.ok(purple.findAllActivated());
	}

	@GetMapping(value = "/purple/{name}", produces = "application/json")
	public ResponseEntity<Purple> getPurplePublic(@PathVariable("name") String name)
			throws IOException {
		return ResponseEntity.ok(purple.findByName(name));
	}

	@GetMapping(value = "/grey", produces = "application/json")
	public ResponseEntity<List<Grey>> getGreysPublic() throws IOException {
		return ResponseEntity.ok(grey.findAllActivated());
	}

	@GetMapping(value = "/grey/type/{type}", produces = "application/json")
	public ResponseEntity<List<Grey>> getGreysTypePublic(@PathVariable("type") String type)
			throws IOException {
		return ResponseEntity.ok(grey.findAllActivatedByType(type));
	}

	@GetMapping(value = "/blue", produces = "application/json")
	public ResponseEntity<List<Blue>> getBluesPublic() throws IOException {
		return ResponseEntity.ok(blue.findAllActivated());
	}

	@GetMapping(value = "/blue/{name}", produces = "application/json")
	public ResponseEntity<Blue> getBluePublic(@PathVariable("name") String name)
			throws IOException {
		return ResponseEntity.ok(blue.findByName(name));
	}

	@GetMapping(value = "/black", produces = "application/json")
	public ResponseEntity<List<Black>> getBlacksPublic() throws IOException {
		return ResponseEntity.ok(black.findAllActivated());
	}

	@GetMapping(value = "/black/{name}", produces = "application/json")
	public ResponseEntity<Black> getBlackPublic(@PathVariable("name") String name)
			throws IOException {
		return ResponseEntity.ok(black.findByName(name));
	}

	@GetMapping(value = "/brown", produces = "application/json")
	public ResponseEntity<List<Brown>> getBrownsPublic() throws IOException {
		return ResponseEntity.ok(brown.findAllActivated());
	}

	@GetMapping(value = "/brown/{name}", produces = "application/json")
	public ResponseEntity<Brown> getBrownPublic(@PathVariable("name") String name)
			throws IOException {
		return ResponseEntity.ok(brown.findByName(name));
	}

	@GetMapping(value = "/orange", produces = "application/json")
	public ResponseEntity<List<Orange>> getOrangesPublic() throws IOException {
		return ResponseEntity.ok(orange.findAllActivated());
	}

	@GetMapping(value = "/orange/{name}", produces = "application/json")
	public ResponseEntity<Orange> getOrangePublic(@PathVariable("name") String name)
			throws IOException {
		return ResponseEntity.ok(orange.findByName(name));
	}

	@GetMapping(value = "/green", produces = "application/json")
	public ResponseEntity<List<Green>> getGreensPublic() throws IOException {
		return ResponseEntity.ok(green.findAllActivated());
	}

	@GetMapping(value = "/green/{name}", produces = "application/json")
	public ResponseEntity<Green> getGreenPublic(@PathVariable("name") String name)
			throws IOException {
		return ResponseEntity.ok(green.findByName(name));
	}

	@GetMapping(value = "/yellow", produces = "application/json")
	public ResponseEntity<List<Yellow>> getYellowsPublic() throws IOException {
		return ResponseEntity.ok(yellow.findAllActivated());
	}

	@GetMapping(value = "/yellow/{name}", produces = "application/json")
	public ResponseEntity<Yellow> getYellowPublic(@PathVariable("name") String name)
			throws IOException {
		return ResponseEntity.ok(yellow.findByName(name));
	}

	@GetMapping(value = "/gold", produces = "application/json")
	public ResponseEntity<List<Gold>> getGoldsPublic() throws IOException {
		return ResponseEntity.ok(gold.findAllActivated());
	}

	@GetMapping(value = "/gold/{name}", produces = "application/json")
	public ResponseEntity<Gold> getGoldPublic(@PathVariable("name") String name)
			throws IOException {
		return ResponseEntity.ok(gold.findByName(name));
	}

	@PostMapping(value = "/order/check", produces = "application/json")
	public ResponseEntity<Object> checkOrder(@RequestBody List<Carticle> carticles)
			throws IOException {
		List<String> response = new ArrayList<>();
		stockhandler(carticles, response, true);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "promotion", produces = "application/json")
	public ResponseEntity<List<Promotion>> getPromotions() throws IOException {
		return ResponseEntity.ok(promotion.findAllActivated());
	}

	@GetMapping(value = "news", produces = "application/json")
	public ResponseEntity<List<News>> getNewss() throws IOException {
		return ResponseEntity.ok(news.findAllActivated());
	}

	private void stockhandler(List<Carticle> carticles, List<String> response, boolean check) {
		for (Carticle carticle : carticles) {
			switch (carticle.getType()) {
				case "red" :
					Red redCarticle = red.findByName(carticle.getName());
					if (redCarticle != null) {
						if (check) {
							for (Lot lot : redCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : redCarticle.getLots())
								stockReducer(response, carticle, lot);
							red.save(redCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				case "yellow" :
					Yellow yellowCarticle = yellow.findByName(carticle.getName());
					if (yellowCarticle != null) {
						if (check) {
							for (Lot lot : yellowCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : yellowCarticle.getLots())
								stockReducer(response, carticle, lot);
							yellow.save(yellowCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				case "gold" :
					Gold goldCarticle = gold.findByName(carticle.getName());
					if (goldCarticle != null) {
						if (check) {
							for (Lot lot : goldCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : goldCarticle.getLots())
								stockReducer(response, carticle, lot);
							gold.save(goldCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				case "grey" :
					Grey greyCarticle = grey.findByName(carticle.getName());
					if (greyCarticle != null) {
						if (check) {
							for (Lot lot : greyCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : greyCarticle.getLots())
								stockReducer(response, carticle, lot);
							grey.save(greyCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				case "blue" :
					Blue blueCarticle = blue.findByName(carticle.getName());
					if (blueCarticle != null) {
						if (check) {
							for (Lot lot : blueCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : blueCarticle.getLots())
								stockReducer(response, carticle, lot);
							blue.save(blueCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				case "green" :
					Green greenCarticle = green.findByName(carticle.getName());
					if (greenCarticle != null) {
						if (check) {
							for (Lot lot : greenCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : greenCarticle.getLots())
								stockReducer(response, carticle, lot);
							green.save(greenCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				case "brown" :
					Brown brownCarticle = brown.findByName(carticle.getName());
					if (brownCarticle != null) {
						if (check) {
							for (Lot lot : brownCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : brownCarticle.getLots())
								stockReducer(response, carticle, lot);
							brown.save(brownCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				case "black" :
					Black blackCarticle = black.findByName(carticle.getName());
					if (blackCarticle != null) {
						if (check) {
							for (Lot lot : blackCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : blackCarticle.getLots())
								stockReducer(response, carticle, lot);
							black.save(blackCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				case "orange" :
					Orange orangeCarticle = orange.findByName(carticle.getName());
					if (orangeCarticle != null) {
						if (check) {
							for (Lot lot : orangeCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : orangeCarticle.getLots())
								stockReducer(response, carticle, lot);
							orange.save(orangeCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				case "white" :
					White whiteCarticle = white.findByName(carticle.getName());
					if (whiteCarticle != null) {
						if (check) {
							for (Lot lot : whiteCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : whiteCarticle.getLots())
								stockReducer(response, carticle, lot);
							white.save(whiteCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				case "purple" :
					Purple purpleCarticle = purple.findByName(carticle.getName());
					if (purpleCarticle != null) {
						if (check) {
							for (Lot lot : purpleCarticle.getLots())
								stockCheckeur(response, carticle, lot);
						} else {
							for (Lot lot : purpleCarticle.getLots())
								stockReducer(response, carticle, lot);
							purple.save(purpleCarticle);
						}
					} else
						response.add(carticle.getName() + " plus disponible");
					break;
				default :
					break;
			}
		}
	}

	private void stockCheckeur(List<String> response, Carticle carticle, Lot lot) {
		if (lot.getTaille().equals(carticle.getPurchase().getTaille())) {
			if (lot.getQuantity() < carticle.getPurchase().getValue()) {
				if (lot.getQuantity() == 0) {
					response.add(carticle.getName() + " " + lot.getTaille() + " plus en stock");
				} else {
					response.add(" Il ne reste que " + lot.getQuantity() + " " + carticle.getName()
							+ " " + lot.getTaille());
				}
			}
		}
	}

	private void stockReducer(List<String> response, Carticle carticle, Lot lot) {
		if (lot.getTaille().equals(carticle.getPurchase().getTaille())) {
			if (lot.getQuantity() - carticle.getPurchase().getValue() > 0)
				lot.setQuantity(lot.getQuantity() - carticle.getPurchase().getValue());
			else
				lot.setQuantity(0);
		}
	}

	@PostMapping(value = "/order/save", produces = "application/json")
	public ResponseEntity<Object> saveOrder(@RequestBody Orders order) throws IOException {
		List<String> response = new ArrayList<>();
		stockhandler(order.getCarticles(), response, false);
		for (Carticle carticle : order.getCarticles()) {
			carticle.setOrders(order);
		}
		Orders saved = this.order.save(order);
		String number = RandomString.generate(7) + order.getId();
		this.order.updateNumberById(saved.getId(), number);
		return ResponseEntity.ok(Utils.stringToJson("response", "Order saved"));
	}

	@GetMapping(value = "/banner", produces = "application/json")
	public ResponseEntity<List<Admin>> getAdmins() throws IOException {
		return ResponseEntity.ok(admin.findAll());
	}

}