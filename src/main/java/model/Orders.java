package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import model.deserializer.CountryDeserializer;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "orders_id", nullable = false)
	private Long id;

	@Column(name = "number")
	private String number;

	@NotBlank
	@Column(name = "name")
	private String name;

	@NotBlank
	@Column(name = "firstname")
	private String firstname;

	@NotBlank
	@Column(name = "street")
	private String street;

	@Column(name = "complement")
	private String complement;

	@NotBlank
	@Column(name = "country")
	@JsonDeserialize(using = CountryDeserializer.class)
	private String country;

	@Column(name = "state")
	private String state;

	@NotBlank
	@Column(name = "city")
	private String city;

	@NotBlank
	@Column(name = "code")
	private String code;

	@Column(name = "phone")
	private String phone;

	@NotBlank
	@Column(name = "email")
	private String email;

	@Column(name = "total")
	private float total;

	@Column(name = "relaisName")
	private String relaisName;

	@Column(name = "relaisStreet")
	private String relaisStreet;

	@Column(name = "relaisCity")
	private String relaisCity;

	@Column(name = "relaisCode")
	private String relaisCode;

	@Column(name = "operator")
	private String operator;

	@Column(name = "service")
	private String service;

	@Column(name = "date")
	private Date date;

	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Carticle> carticles;

	public Orders() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getRelaisName() {
		return relaisName;
	}

	public void setRelaisName(String relaisName) {
		this.relaisName = relaisName;
	}

	public String getRelaisStreet() {
		return relaisStreet;
	}

	public void setRelaisStreet(String relaisStreet) {
		this.relaisStreet = relaisStreet;
	}

	public String getRelaisCity() {
		return relaisCity;
	}

	public void setRelaisCity(String relaisCity) {
		this.relaisCity = relaisCity;
	}

	public String getRelaisCode() {
		return relaisCode;
	}

	public void setRelaisCode(String relaisCode) {
		this.relaisCode = relaisCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public List<Carticle> getCarticles() {
		return carticles;
	}

	public void setCarticles(List<Carticle> carticles) {
		this.carticles = carticles;
	}

}
