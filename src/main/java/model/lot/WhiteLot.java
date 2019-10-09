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
import model.article.White;

@Entity
@Table(name = "white_lot")
public class WhiteLot extends Lot {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "lot_id", nullable = false)
	private long id;

	@JoinColumn(name = "name")
	@ManyToOne(fetch = FetchType.EAGER)
	private White white;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setWhite(White white) {
		this.white = white;
	}

	@JsonIgnore
	public Article getWhite() {
		return white;
	}

	public WhiteLot() {
		super();
	}

}
