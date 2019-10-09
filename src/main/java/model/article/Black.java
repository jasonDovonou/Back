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
import model.lot.BlackLot;

@Entity
@Table(name = "black")
public class Black extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "black", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<BlackLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BlackLot> getLots() {
		return lots;
	}

	public void setLots(List<BlackLot> lots) {
		this.lots = lots;
	}

	public Black() {
		super();
	}

}
