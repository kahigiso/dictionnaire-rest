package net.francais.mashi.dic.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "dic_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	@Size(min = 3)
	private String password;
	private String about;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date updated;
	private boolean contributor = false;
	private boolean active = false;
	private boolean confirmed = false;
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name = "dic_user_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<Role>();

	public User() {
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public boolean isContributor() {
		return contributor;
	}

	public void setContributor(boolean contributor) {
		this.contributor = contributor;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean active) {
		this.active = active;
	}

	@Transient
	public void addRole(Role role) {
		roles.add(role);
		role.addUser(this);
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
		return "User [id=" + id + ", name=" + name + "]";
	}
}