package model.boxtal;

public class Carrier {
	private String operator;
	private String service;
	private Points points;

	public String getOperator() {
		return operator;
	}

	public String getService() {
		return service;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Points getPoints() {
		return points;
	}

	public void setPoints(Points points) {
		this.points = points;
	}

}
