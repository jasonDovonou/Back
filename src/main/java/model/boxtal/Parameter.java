package model.boxtal;

public class Parameter {

	private String code;
	private String label;
	private String type;

	// Getter Methods

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}

	// Setter Methods

	public void setCode(String code) {
		this.code = code;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
