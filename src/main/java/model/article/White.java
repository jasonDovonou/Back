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
import model.lot.WhiteLot;

@Entity
@Table(name = "white")
public class White extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "white", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<WhiteLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WhiteLot> getLots() {
		return lots;
	}

	public void setLots(List<WhiteLot> lots) {
		this.lots = lots;
	}

	public White() {
		super();
	}

}
