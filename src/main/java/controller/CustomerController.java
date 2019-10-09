package controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import model.Customer;
import model.request.CustomerRequest;
import repository.CustomerRepo;
import util.Tokens;
import util.Utils;

@RestController
@RequestMapping("/public/customer")
public class CustomerController {

	@Autowired
	CustomerRepo customer;

	@Value("${contact.email}")
	private String mail;

	@Value("${contact.mdp}")
	private String mdp;

	@GetMapping(value = "/check", produces = "application/json")
	public ResponseEntity<Object> customerCheck(@RequestParam String email) throws IOException {
		Customer custo = this.customer.findByEmail(email);
		return ResponseEntity
				.ok(custo != null ? Utils.stringToJson("response", "User found") : null);
	}

	@GetMapping(value = "/forgot", produces = "application/json")
	public ResponseEntity<Object> customerForgot(@RequestParam String email)
			throws IOException, MessagingException, GeneralSecurityException {
		Customer customer = this.customer.findByEmail(email);
		if (customer != null) {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.office365.com");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mail, mdp);
				}
			});
			try {
				int number = (int) (Math.random() * ((999999 - 100000) + 1)) + 100000;
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(mail));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject("Réinitialisation de mot de passe");
				message.setText("Bonjour," + "\n\nVotre Code de réinitialisation est : "
						+ String.valueOf(number));
				Transport.send(message);
				this.customer.updateResetById(customer.getId(), String.valueOf(number));
				return ResponseEntity.ok(Utils.stringToJson("response", "Passgo"));
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
		return ResponseEntity.ok(null);
	}

	@GetMapping(value = "/forgot/check", produces = "application/json")
	public ResponseEntity<Object> customerForgotCheck(@RequestParam String email,
			@RequestParam String code)
			throws IOException, MessagingException, GeneralSecurityException {

		Customer customer = this.customer.findByEmail(email);
		if (customer != null && customer.getResetCode().equals(code)) {
			String jwt = Tokens.createJWT(customer.getId().toString(), customer.getName(),
					customer.getName() + "Reset", 10 * (60000));
			return ResponseEntity.ok(Utils.stringToJson("token", jwt));
		}
		return ResponseEntity.ok(null);
	}

	@GetMapping(value = "/forgot/reset", produces = "application/json")
	public ResponseEntity<Object> customerForgotReset(@RequestParam String email,
			@RequestParam String pass, @RequestParam String token)
			throws IOException, MessagingException, GeneralSecurityException {
		Claims claims = Tokens.parseJWT(token);
		if (claims.getIssuer() != null) {
			customer.updatePasswordByEmail(email, pass);
		}
		return ResponseEntity.ok(Utils.stringToJson("response", "Passgo"));
	}

	@GetMapping(value = "/upass", produces = "application/json")
	public ResponseEntity<Object> customerUpdatePassword(@RequestParam Long id,
			@RequestParam String pass)
			throws IOException, MessagingException, GeneralSecurityException {
		customer.updatePasswordById(id, pass);
		return ResponseEntity.ok(Utils.stringToJson("response", "Passgo"));
	}

	@PostMapping(produces = "application/json")
	public ResponseEntity<Customer> getUser(@RequestBody CustomerRequest request)
			throws IOException {
		Customer customer = this.customer.findByEmail(request.getEmail());
		if (customer != null && customer.getPassword().equals(request.getPassword())) {
			customer.setPassword(null);
			return ResponseEntity.ok(customer);
		}
		return ResponseEntity.ok(null);
	}

	@PostMapping(value = "/save", produces = "application/json")
	public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) throws IOException {
		this.customer.save(customer);
		customer.setPassword(null);
		return ResponseEntity.ok(customer);
	}

	@PutMapping(value = "/update", produces = "application/json")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer,
			@RequestParam Long id) throws IOException {
		Customer todelete = this.customer.findById(id).get();
		customer.setDiscount(todelete.getDiscount());
		customer.setPassword(todelete.getPassword());
		this.customer.deleteById(id);
		Customer updated = this.customer.save(customer);
		updated.setPassword(null);
		return ResponseEntity.ok(updated);
	}

}