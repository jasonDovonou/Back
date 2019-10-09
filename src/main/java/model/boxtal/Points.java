package model.boxtal;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Points {

	List<Point> point;

	@XmlElement(name = "point")
	public List<Point> getPointList() {
		return point;
	}

	public void setPointList(List<Point> point) {
		this.point = point;
	}

}
