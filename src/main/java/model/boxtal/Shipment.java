package model.boxtal;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class Shipment {
	Package pack;
	private String content;
	private String collection_date;
	private String delay;
	Shipper shipper;
	Recipient recipient;
	ArrayList<Offer> offer = new ArrayList<Offer>();

	@XmlElement(name = "package")
	public Package getPack() {
		return pack;
	}

	public void setPack(Package pack) {
		this.pack = pack;
	}

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCollection_date() {
		return collection_date;
	}

	public void setCollection_date(String collection_date) {
		this.collection_date = collection_date;
	}

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public ArrayList<Offer> getOffer() {
		return offer;
	}

	public void setOffer(ArrayList<Offer> offer) {
		this.offer = offer;
	}

}
