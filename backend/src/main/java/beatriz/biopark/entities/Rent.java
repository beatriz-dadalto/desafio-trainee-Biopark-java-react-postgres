package beatriz.biopark.entities;

import java.io.Serializable;
import java.time.Instant;

public class Rent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Tenant tenant;
	private Apartment apartment;
	private Instant createdAt;
	private String durationRent;
	private boolean isActive;
	
	public Rent() {}

	public Rent(Long id, Tenant tenant, Apartment apartment, Instant dateRent, String durationRent, boolean isActive) {
		super();
		this.id = id;
		this.tenant = tenant;
		this.apartment = apartment;
		this.createdAt = dateRent;
		this.durationRent = durationRent;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public Instant getDateRent() {
		return createdAt;
	}

	public void setDateRent(Instant dateRent) {
		this.createdAt = dateRent;
	}

	public String getDurationRent() {
		return durationRent;
	}

	public void setDurationRent(String durationRent) {
		this.durationRent = durationRent;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
