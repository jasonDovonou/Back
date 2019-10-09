package model.boxtal;

public class Delivery {
	Type TypeObject;
	private String date;
	private String time;
	private String label;

	// Getter Methods

	public Type getType() {
		return TypeObject;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getLabel() {
		return label;
	}

	// Setter Methods

	public void setType(Type typeObject) {
		this.TypeObject = typeObject;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}