package model.boxtal;

import javax.xml.bind.annotation.XmlElement;

public class Price {
	private String currency;
	@XmlElement(name = "tax-exclusive")
	private String tax_exclusive;
	@XmlElement(name = "tax-inclusive")
	private String tax_inclusive;

	// Getter Methods

	public String getCurrency() {
		return currency;
	}

	public String getTaxexclusive() {
		return tax_exclusive;
	}

	public String getTaxinclusive() {
		return tax_inclusive;
	}

	// Setter Methods

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setTaxexclusive(String tax_exclusive) {
		this.tax_exclusive = tax_exclusive;
	}

	public void setTaxinclusive(String tax_inclusive) {
		this.tax_inclusive = tax_inclusive;
	}
}
