package net.francais.mashi.dic.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MotMashi extends Mot {

	@Column(nullable = true)
	private String origine;
	@Column(nullable = true)
	private String imageUrl;
	@Column(nullable = true)
	private String singulier;
	@Column(nullable = true)
	private String pluriel;
	@OneToOne(mappedBy = "motMashi", fetch = FetchType.EAGER)
	@JoinColumn(nullable = true)
	private Example example;
	@ManyToOne
	@JoinColumn(name = "langue_origine", nullable = true)
	private LangueOrigine langueOrigine;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Nature nature;
	@OneToOne
	@JoinColumn(name = "mot_francais")
	private MotFrancais motFrancais;

	public MotFrancais getMotFrancais() {
		return motFrancais;
	}

	public void setMotFrancais(MotFrancais motFrancais) {
		this.motFrancais = motFrancais;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSingulier() {
		return singulier;
	}

	public void setSingulier(String singulier) {
		this.singulier = singulier;
	}

	public String getPluriel() {
		return pluriel;
	}

	public void setPluriel(String pluriel) {
		this.pluriel = pluriel;
	}

	public LangueOrigine getLangueOrigine() {
		return langueOrigine;
	}

	public void setLangueOrigine(LangueOrigine langueOrigine) {
		this.langueOrigine = langueOrigine;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public Example getExample() {
		return example;
	}

	public void setExample(Example example) {
		this.example = example;
	}

	@Override
	public String toString() {
		return "MotMashi [id=" + super.getMot() + ", mot=" + super.getMot()
				+ ", motFrancais=" + motFrancais + "]";
	}
}