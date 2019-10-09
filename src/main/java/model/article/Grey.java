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
import model.lot.GreyLot;

@Entity
@Table(name = "grey")
public class Grey extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "grey", nullable = false)
	private String grey;

	@OneToMany(mappedBy = "grey", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<GreyLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrey() {
		return grey;
	}

	public void setGrey(String grey) {
		this.grey = grey;
	}

	public List<GreyLot> getLots() {
		return lots;
	}

	public void setLots(List<GreyLot> lots) {
		this.lots = lots;
	}

	public Grey() {
		super();
	}

}
