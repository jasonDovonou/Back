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
import model.lot.PurpleLot;

@Entity
@Table(name = "purple")
public class Purple extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "purple", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<PurpleLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PurpleLot> getLots() {
		return lots;
	}

	public void setLots(List<PurpleLot> lots) {
		this.lots = lots;
	}

	public Purple() {
		super();
	}

}
