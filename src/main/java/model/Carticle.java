package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carticle")
public class Carticle {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "carticle_id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "ref", nullable = false)
	private String ref;

	@Column(name = "description", nullable = false)
	private String desc;

	@Column(name = "prixAchat", nullable = false)
	private String prixAchat;

	@Column(name = "prixVente", nullable = false)
	private String prixVente;

	@Column(name = "poids", nullable = false)
	private String poids;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(name = "photo", nullable = false)
	private String photo;

	@Column(name = "mainPhoto", nullable = false)
	private String mainPhoto;

	@Column(name = "type", nullable = false)
	private String type;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "purchase_id")
	private Purchase purchase;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "orders_id")
	private Orders orders;

	public Carticle() {
		super();
	}

	public Carticle(String ref, String desc, String prixAchat, String prixVente, String poids,
			String photo, String mainPhoto) {
		super();
		this.ref = ref;
		this.desc = desc;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.poids = poids;
		this.photo = photo;
		this.mainPhoto = mainPhoto;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(String prixAchat) {
		this.prixAchat = prixAchat;
	}

	public String getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(String prixVente) {
		this.prixVente = prixVente;
	}

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMainPhoto() {
		return mainPhoto;
	}

	public void setMainPhoto(String mainPhoto) {
		this.mainPhoto = mainPhoto;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Orders getOrders() {
		return orders;
	}

	@JsonIgnore
	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}
