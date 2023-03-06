package beatriz.biopark.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;

public class Rent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private User user;
	private Apartment apartment;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	private String durationMonths;
	private boolean isActive;
	
	public Rent() {}

	public Rent(Long id, User user, Apartment apartment, Instant createdAt, String durationMonths, boolean isActive) {
		this.id = id;
		this.user = user;
		this.apartment = apartment;
		this.createdAt = createdAt;
		this.durationMonths = durationMonths;
		this.isActive = isActive;
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

	public void setTenant(User user) {
		this.user = user;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public String getDurationMonths() {
		return durationMonths;
	}

	public void setDurationMonths(String durationRent) {
		this.durationMonths = durationRent;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
