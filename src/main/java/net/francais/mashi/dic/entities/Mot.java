package net.francais.mashi.dic.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "dic_mot")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Mot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String mot;
	@OneToOne
	@JoinColumn(nullable=false)
	private User addedBy;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date updated;

	public Long getId() {
		return id;
	}

	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
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
	
	@Override
	public String toString() {
		return "Mot [id=" + id + ", mot=" + mot + "]";
	}
		
}