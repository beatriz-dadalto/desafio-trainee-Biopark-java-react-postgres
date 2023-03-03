package beatriz.biopark.dto;

import java.io.Serializable;
import java.time.Instant;

import beatriz.biopark.entities.Advertise;
import beatriz.biopark.entities.Apartment;
import beatriz.biopark.entities.User;



public class AdvertiseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private User user;
	private String title;
	private String description;
	private Instant createdAt;
	private boolean isActive;
	private Apartment apartment;
	
	public AdvertiseDTO() {}
	
	public AdvertiseDTO(Advertise advertise) {
		this.id = advertise.getId();
		this.user = advertise.getUser();
		this.title = advertise.getTitle();
		this.description = advertise.getDescription();
		this.createdAt = advertise.getCreatedAt();
		this.isActive = advertise.isActive();
		this.apartment = advertise.getApartment();
	}

	public AdvertiseDTO(Long id, User user, String title, String description, Instant createdAt, boolean isActive,
			Apartment apartment) {
		this.id = id;
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
