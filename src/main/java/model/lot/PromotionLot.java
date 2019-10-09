package model.lot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import model.Article;
import model.Lot;
import model.article.Promotion;

@Entity
@Table(name = "promotion_lot")
public class PromotionLot extends Lot {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "lot_id", nullable = false)
	private long id;

	@JoinColumn(name = "name")
	@ManyToOne(fetch = FetchType.EAGER)
	private Promotion promotion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	@JsonIgnore
	public Article getPromotion() {
		return promotion;
	}

	public PromotionLot() {
		super();
	}

	public PromotionLot(Promotion promo, Lot lot) {
		this.promotion = promo;
		this.setColor(lot.getColor());
		this.setQuantity(lot.getQuantity());
		this.setTaille(lot.getTaille());
	}

}
