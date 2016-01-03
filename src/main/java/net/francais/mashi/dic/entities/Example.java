package net.francais.mashi.dic.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "dic_example")
public class Example {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "txt_francais", nullable = false)
	private String txtFrancais;
	@Column(name = "txt_mashi", nullable = false)
	private String txtMashi;
	@OneToOne
	@JoinColumn(nullable=false)
	private User addedBy;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date updated;
	@OneToOne
	@JoinColumn(name = "mot_mashi")
	private MotMashi motMashi;

	public Long getId() {
		return id;
	}

	public String getTxtFrancais() {
		return txtFrancais;
	}

	public void setTxtFrancais(String txtFrancais) {
		this.txtFrancais = txtFrancais;
	}

	public String getTxtMashi() {
		return txtMashi;
	}

	public void setTxtMashi(String txtMashi) {
		this.txtMashi = txtMashi;
	}

	public MotMashi getMotMashi() {
		return motMashi;
	}

	public void setMotMashi(MotMashi motMashi) {
		this.motMashi = motMashi;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	private void setUpdated(Date date) {
		this.updated = date;
	}

	private void setCreated(Date date) {
		this.created = date;
	}

	@PrePersist
	public void prePersist() {
		Date now = new Date();
		this.setCreated(now);
		this.setUpdated(now);
	}

	@PreUpdate
	public void preUpdate() {
		this.setUpdated(new Date());
	}

	@Override
	public String toString() {
		return "Example [id=" + id + ", motMashi=" + motMashi.getMot() + "]";
	}

}
