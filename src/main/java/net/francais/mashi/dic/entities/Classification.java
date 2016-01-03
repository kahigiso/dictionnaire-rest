package net.francais.mashi.dic.entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="dic_classification")
public class Classification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date updated;
	//private String abbreviation;
	//private List<MotMashi> motsMashi = new ArrayList<MotMashi>();;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
//	public String getAbbreviation() {
//		return abbreviation;
//	}
//	public void setAbbreviation(String abbreviation) {
//		this.abbreviation = abbreviation;
//	}
//	public List<MotMashi> getMotsMashi() {
//		return motsMashi;
//	}
//	public void setMotsMashi(List<MotMashi> motsMashi) {
//		this.motsMashi = motsMashi;
//	}
	
//	@Override
//	public String toString() {
//		return "Classification [id=" + id + ", name=" + name
//				+ ", abbreviation=" + abbreviation + "]";
//	}
	
}