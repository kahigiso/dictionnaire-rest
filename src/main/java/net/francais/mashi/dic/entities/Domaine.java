package net.francais.mashi.dic.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name="dic_domaine")
public class Domaine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank
	@Column(unique=true)
	private String name;
	@Column(unique=true)
	private String abbreviation;
	@OneToOne
	@JoinColumn(nullable=false)
	private User addedBy;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date updated;
	@OneToMany(mappedBy="domaine")
	private Set<MotFrancais> motsFrancais = new HashSet<MotFrancais>();
		
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public User getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}
	public Set<MotFrancais> getMotsFrancais() {
		return motsFrancais;
	}
	public void setMotsFrancais(Set<MotFrancais> motsFrancais) {
		this.motsFrancais = motsFrancais;
	}
	
	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}
	
	private void setUpdated(Date date) {
		this.updated= date;
		
	}
	private void setCreated(Date date) {
		this.created= date;	
	}
	
		
	@PrePersist
    public void prePersist(){
        Date now  = new Date();
        this.setCreated(now);
        this.setUpdated(now); 
    }
    
	@PreUpdate
    public void preUpdate(){
        this.setUpdated(new Date()); 
    }
	
	@Transient
	public void addMotFrancais(MotFrancais motFrancais){
		motsFrancais.add(motFrancais);
	}
	
	@Override
	public String toString() {
		return "Domaine [id=" + id + ", name=" + name + ", abbreviation="+ abbreviation + "]";
	}
	
}
