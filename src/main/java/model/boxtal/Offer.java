package model.boxtal;

public class Offer {
	private String mode;
	private String url;
	Operator OperatorObject;
	Service ServiceObject;
	Price PriceObject;
	private String alert;
	Characteristics CharacteristicsObject;
	Mandatory_informations Mandatory_informationsObject;
	Options OptionsObject;
	Collection CollectionObject;
	Delivery DeliveryObject;

	public String getMode() {
		return mode;
	}

	public String getUrl() {
		return url;
	}

	public Operator getOperator() {
		return OperatorObject;
	}

	public Service getService() {
		return ServiceObject;
	}

	public Price getPrice() {
		return PriceObject;
	}

	public String getAlert() {
		return alert;
	}

	public Characteristics getCharacteristics() {
		return CharacteristicsObject;
	}

	public Mandatory_informations getMandatory_informations() {
		return Mandatory_informationsObject;
	}

	public Options getOptions() {
		return OptionsObject;
	}

	public Collection getCollection() {
		return CollectionObject;
	}

	public Delivery getDelivery() {
		return DeliveryObject;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setOperator(Operator operatorObject) {
		this.OperatorObject = operatorObject;
	}

	public void setService(Service serviceObject) {
		this.ServiceObject = serviceObject;
	}

	public void setPrice(Price priceObject) {
		this.PriceObject = priceObject;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public void setCharacteristics(Characteristics characteristicsObject) {
		this.CharacteristicsObject = characteristicsObject;
	}

	public void setMandatory_informations(Mandatory_informations mandatory_informationsObject) {
		this.Mandatory_informationsObject = mandatory_informationsObject;
	}

	public void setOptions(Options optionsObject) {
		this.OptionsObject = optionsObject;
	}

	public void setCollection(Collection collectionObject) {
		this.CollectionObject = collectionObject;
	}

	public void setDelivery(Delivery deliveryObject) {
		this.DeliveryObject = deliveryObject;
	}
}
