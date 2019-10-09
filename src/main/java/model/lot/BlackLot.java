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

import model.Lot;
import model.article.Black;

@Entity
@Table(name = "black_lot")
public class BlackLot extends Lot {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "lot_id", nullable = false)
	private long id;

	@JoinColumn(name = "name")
	@ManyToOne(fetch = FetchType.EAGER)
	private Black black;

	@JsonIgnore
	public Black getBlack() {
		return black;
	}

	@JsonIgnore
	public void setBlack(Black black) {
		this.black = black;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BlackLot() {
		super();
	}

}
