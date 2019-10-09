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
import model.lot.YellowLot;

@Entity
@Table(name = "yellow")
public class Yellow extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "yellow", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<YellowLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<YellowLot> getLots() {
		return lots;
	}

	public void setLots(List<YellowLot> lots) {
		this.lots = lots;
	}

	public Yellow() {
		super();
	}

}
