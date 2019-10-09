package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pic")
public class Pic {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "pic_id", nullable = false)
	private Long id;

	@JoinColumn(name = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Admin adm;

	@NotBlank
	@Column(name = "pic")
	private String pic;

	@Column(name = "position")
	private int position;

	public Pic() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Admin getAdmin() {
		return adm;
	}

	@JsonIgnore
	public void setAdmin(Admin admin) {
		this.adm = admin;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
