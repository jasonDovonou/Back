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
import model.lot.RedLot;

@Entity
@Table(name = "red")
public class Red extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "red", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<RedLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RedLot> getLots() {
		return lots;
	}

	public void setLots(List<RedLot> lots) {
		this.lots = lots;
	}

	public Red() {
		super();
	}

}
