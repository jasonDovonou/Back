package model.article;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.Article;
import model.Lot;
import model.lot.PromotionLot;

@Entity
@Table(name = "promotion")
public class Promotion extends Article {

	@Id
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<PromotionLot> lots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PromotionLot> getLots() {
		return lots;
	}

	public void setLots(List<PromotionLot> lots) {
		this.lots = lots;
	}

	public Promotion() {
		super();
	}

	public Promotion(String name, Article article, List<Lot> lots) {
		this.name = name;
		this.setRef(article.getRef());
		this.setDesc(article.getDesc());
		this.setPrixAchat(article.getPrixAchat());
		this.setPrixVente(article.getPrixVente());
		this.setPoids(article.getPoids());
		this.setPhoto(article.getPhoto());
		this.setMainPhoto(article.getMainPhoto());
		this.setType(article.getType());
		this.setActivated(article.getActivated());
		this.setNews(article.isNews());
		this.setPromo(article.getPromo());
		this.lots = new ArrayList<>();
		for (Lot lot : lots) {
			this.lots.add(new PromotionLot(this, lot));
		}
	}

}
