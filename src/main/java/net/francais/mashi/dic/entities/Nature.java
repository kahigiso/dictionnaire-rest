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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "dic_nature")
public class Nature {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	@Column(unique = true)
	private String name;
	@Column(unique = true)
	private String abbreviation;
	@OneToOne
	@JoinColumn(nullable=false)
	private User addedBy;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date updated;

	@OneToMany(mappedBy = "nature", fetch = FetchType.EAGER)
	private Set<MotMashi> motsMashi = new HashSet<MotMashi>();

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

	public Set<MotMashi> getMotsMashi() {
		return motsMashi;
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

	public void addMotMashi(MotMashi motMashi) {
		motsMashi.add(motMashi);
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
		return "Nature [id=" + id + ", name=" + name + ", abbreviation="
				+ abbreviation + "]";
	}
}