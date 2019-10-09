package model.article;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.Article;
import model.lot.GreenLot;

@Entity
@Table(name = "green")
public class Green extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "green", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<GreenLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GreenLot> getLots() {
		return lots;
	}

	public void setLots(List<GreenLot> lots) {
		this.lots = lots;
	}

	public Green() {
		super();
	}

}
