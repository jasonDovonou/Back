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
import model.lot.BrownLot;

@Entity
@Table(name = "brown")
public class Brown extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "brown", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<BrownLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BrownLot> getLots() {
		return lots;
	}

	public void setLots(List<BrownLot> lots) {
		this.lots = lots;
	}

	public Brown() {
		super();
	}

}
