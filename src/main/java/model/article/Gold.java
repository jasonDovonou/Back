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
import model.lot.GoldLot;

@Entity
@Table(name = "gold")
public class Gold extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "gold", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<GoldLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GoldLot> getLots() {
		return lots;
	}

	public void setLots(List<GoldLot> lots) {
		this.lots = lots;
	}

	public Gold() {
		super();
	}

}
