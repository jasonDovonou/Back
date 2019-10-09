package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "purchase_id", nullable = false)
	private long id;

	@Column(name = "value", nullable = false)
	private int value;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "taille", nullable = false)
	private String taille;

	@Column(name = "color", nullable = false)
	private String color;

	@OneToOne(mappedBy = "purchase")
	private Carticle carticle;

	public Purchase() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public Carticle getCarticle() {
		return carticle;
	}

	@JsonIgnore
	public void setCarticle(Carticle carticle) {
		this.carticle = carticle;
	}

}
