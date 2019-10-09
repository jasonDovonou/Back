package model.boxtal;

public class Point {
	private String code;
	private String name;
	private String address;
	private String city;
	private String zipcode;
	private String country;
	private String latitude;
	private String longitude;
	private String phone;
	private String description;
	Schedule schedule;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCountry() {
		return country;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getPhone() {
		return phone;
	}

	public String getDescription() {
		return description;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	// Setter Methods

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
}
