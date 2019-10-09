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
import model.lot.BlueLot;

@Entity
@Table(name = "blue")
public class Blue extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "blue", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<BlueLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BlueLot> getLots() {
		return lots;
	}

	public void setLots(List<BlueLot> lots) {
		this.lots = lots;
	}

	public Blue() {
		super();
	}

}
