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
import model.article.Yellow;

@Entity
@Table(name = "yellow_lot")
public class YellowLot extends Lot {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "lot_id", nullable = false)
	private long id;

	@JoinColumn(name = "name")
	@ManyToOne(fetch = FetchType.EAGER)
	private Yellow yellow;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public Article getYellow() {
		return yellow;
	}

	@JsonIgnore
	public void setYellow(Yellow yellow) {
		this.yellow = yellow;
	}

	public YellowLot() {
		super();
	}

}
