package model.boxtal;

import java.util.List;

public class Country {

	private String name;
	private String code;
	private String is_ue;
	private List<State> states;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIs_ue() {
		return is_ue;
	}
	public void setIs_ue(String is_ue) {
		this.is_ue = is_ue;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}
	public Country(String name, String code, String is_ue, List<State> states) {
		super();
		this.name = name;
		this.code = code;
		this.is_ue = is_ue;
		this.states = states;
	}

	public Country() {
		super();
	}

}
