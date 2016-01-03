package net.francais.mashi.dic.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name="dic_role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank
	@Column(unique= true)
	private String name;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date updated;
	@ManyToMany(mappedBy = "roles",fetch=FetchType.EAGER)
    private Set<User> users = new HashSet<User>();
	
	public Role() {}
	
	public Long getId() {
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
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Set<User> getUsers() {
	        return users;
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
		return "Role [id=" + id + ", name=" + name + "]";
	}

	public void addUser(User user) {
		users.add(user);
	}
}