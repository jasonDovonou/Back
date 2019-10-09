package model.boxtal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "carriers")
public class Carriers {
	Carrier carrier;

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
}