package model;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

@MappedSuperclass
public class Article {

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

	@Column(name = "activated", nullable = false)
	private boolean activated;

	@Column(name = "news")
	private boolean news;

	@Column(name = "promo")
	private int promo;

	public Article() {
		super();
	}

	public Article(String ref, String desc, String prixAchat, String prixVente, String poids,
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

	public boolean getActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean isNews() {
		return news;
	}

	public void setNews(boolean news) {
		this.news = news;
	}

	public int getPromo() {
		return promo;
	}

	public void setPromo(int promo) {
		this.promo = promo;
	}

}
