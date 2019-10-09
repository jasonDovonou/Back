package model.boxtal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cotation")
public class Cotation {
	Shipment ShipmentObject;

	public Shipment getShipment() {
		return ShipmentObject;
	}

	public void setShipment(Shipment shipmentObject) {
		this.ShipmentObject = shipmentObject;
	}
}