package net.francais.mashi.dic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MotFrancais extends Mot{
	
	@Column(unique=true)
	private String precision;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Domaine domaine;
	@OneToOne(mappedBy="motFrancais",fetch=FetchType.EAGER)
	@JoinColumn(nullable=true)
	private MotMashi motMashi;
	
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	public Domaine getDomaine() {
		return domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	public MotMashi getMotMashi() {
		return motMashi;
	}
	public void setMotMashi(MotMashi motMashi) {
		this.motMashi = motMashi;
	}

	
	@Override
	public String toString() {
		return "MotFrancais [id=" + super.getMot() + ", mot=" + super.getMot() + ", precision="
				+ precision + ", motMashi=" + motMashi + "]";
	}
	
}
