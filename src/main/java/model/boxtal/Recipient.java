package model.boxtal;

public class Recipient {
	private String type;
	private String country;
	private String zipcode;
	private String city;

	// Getter Methods

	public String getType() {
		return type;
	}

	public String getCountry() {
		return country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCity() {
		return city;
	}

	// Setter Methods

	public void setType(String type) {
		this.type = type;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setCity(String city) {
		this.city = city;
	}
}