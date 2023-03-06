package beatriz.biopark.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_advertise")
public class Advertise implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private User user;
	
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	private boolean isActive;
	
	private Apartment apartment;
	
	public Advertise() {}

	public Advertise(Long id, User user, String title, String description, Instant createdAt, boolean isActive,
			Apartment apartment) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.isActive = isActive;
		this.apartment = apartment;
	}
	
	public Advertise(User user, String title, String description, Instant createdAt, boolean isActive,
			Apartment apartment) {
		this.user = user;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.isActive = isActive;
		this.apartment = apartment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

}
