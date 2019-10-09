package model.boxtal;

import java.util.ArrayList;

public class Option {
	private String code;
	private String name;
	ArrayList<Object> parameter = new ArrayList<Object>();

	// Getter Methods

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	// Setter Methods

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
}