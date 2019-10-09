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
import model.article.News;

@Entity
@Table(name = "news_lot")
public class NewsLot extends Lot {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "lot_id", nullable = false)
	private long id;

	@JoinColumn(name = "name")
	@ManyToOne(fetch = FetchType.EAGER)
	private News news;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setNews(News news) {
		this.news = news;
	}

	@JsonIgnore
	public Article getNews() {
		return news;
	}

	public NewsLot() {
		super();
	}

	public NewsLot(News news, Lot lot) {
		this.news = news;
		this.setColor(lot.getColor());
		this.setQuantity(lot.getQuantity());
		this.setTaille(lot.getTaille());
	}

}
