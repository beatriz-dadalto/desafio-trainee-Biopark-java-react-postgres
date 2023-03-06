package beatriz.biopark.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_apartment")
public class Apartment implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private User user;
	private String bedroom;
	private String bathroom;
	private String garage;
	private String floor;
	private String dimension;
	
	@ManyToOne
	@JoinColumn(name = "building_id")
	private Building building;
	
	private StatusApartment statusApartment;
	private Double rentAmount;
	private String imageUrl;
	
	public Apartment() {}

	public Apartment(Long id, User user, String bedroom, String bathroom, String garage, String floor, String dimension,
			Building building, StatusApartment statusApartment, Double rentAmount, String imageUrl) {
		this.id = id;
		this.user = user;
		this.bedroom = bedroom;
		this.bathroom = bathroom;
		this.garage = garage;
		this.floor = floor;
		this.dimension = dimension;
		this.building = building;
		this.statusApartment = statusApartment;
		this.rentAmount = rentAmount;
		this.imageUrl = imageUrl;
	}
	
	public Apartment(User user, String bedroom, String bathroom, String garage, String floor, String dimension,
			Building building, StatusApartment statusApartment, Double rentAmount, String imageUrl) {
		this.user = user;
		this.bedroom = bedroom;
		this.bathroom = bathroom;
		this.garage = garage;
		this.floor = floor;
		this.dimension = dimension;
		this.building = building;
		this.statusApartment = statusApartment;
		this.rentAmount = rentAmount;
		this.imageUrl = imageUrl;
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

	public String getBedroom() {
		return bedroom;
	}

	public void setBedroom(String bedroom) {
		this.bedroom = bedroom;
	}

	public String getBathroom() {
		return bathroom;
	}

	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}

	public String getGarage() {
		return garage;
	}

	public void setGarage(String garage) {
		this.garage = garage;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public StatusApartment getStatusApartment() {
		return statusApartment;
	}

	public void setStatusApartment(StatusApartment statusApartment) {
		this.statusApartment = statusApartment;
	}

	public Double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
