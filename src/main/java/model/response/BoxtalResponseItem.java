package model.response;

public class BoxtalResponseItem {

	private float price;
	private String type;
	private String operator;
	private String service;
	private String currency;

	public BoxtalResponseItem() {
		super();
	}
	public BoxtalResponseItem(float price, String type, String operator, String service,
			String currency) {
		super();
		this.price = price;
		this.type = type;
		this.operator = operator;
		this.service = service;
		this.currency = currency;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
