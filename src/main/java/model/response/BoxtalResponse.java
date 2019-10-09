package model.response;

import java.util.List;

import model.boxtal.Offer;
import model.boxtal.Point;

public class BoxtalResponse {

	private BoxtalResponseItem home;
	private BoxtalResponseItem relais;
	private List<Point> points;

	public BoxtalResponse() {
		super();
	}

	public BoxtalResponse(List<Point> points) {
		super();
		this.points = points;
	}

	public BoxtalResponse(Offer home, Offer relais) {
		super();
		if (home != null)
			this.home = new BoxtalResponseItem(Float.parseFloat(home.getPrice().getTaxinclusive()),
					home.getDelivery().getType().getCode(), home.getOperator().getCode(),
					home.getService().getCode(), home.getPrice().getCurrency());

		if (relais != null)
			this.relais = new BoxtalResponseItem(
					Float.parseFloat(relais.getPrice().getTaxinclusive()),
					relais.getDelivery().getType().getCode(), relais.getOperator().getCode(),
					relais.getService().getCode(), relais.getPrice().getCurrency());
	}

	public BoxtalResponseItem getHome() {
		return home;
	}

	public void setHome(BoxtalResponseItem home) {
		this.home = home;
	}

	public BoxtalResponseItem getRelais() {
		return relais;
	}

	public void setRelais(BoxtalResponseItem relais) {
		this.relais = relais;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

}
