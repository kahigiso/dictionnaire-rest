package net.francais.mashi.dic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MotFrancais extends Mot{
	
	@Column(nullable=true)
	private String precizion;
	@ManyToOne
	@JoinColumn(nullable = true)
	private Domaine domaine;
	@OneToOne(mappedBy="motFrancais", fetch=FetchType.EAGER)
	@JoinColumn(nullable=true)
	private MotMashi motMashi;
	
	public String getPrecizion() {
		return precizion;
	}
	public void setPrecizion(String precizion) {
		this.precizion = precizion;
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
				+ precizion + ", motMashi=" + motMashi + "]";
	}
	
}
