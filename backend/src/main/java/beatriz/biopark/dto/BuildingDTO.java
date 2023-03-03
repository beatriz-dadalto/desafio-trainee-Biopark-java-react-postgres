package beatriz.biopark.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import beatriz.biopark.entities.Apartment;
import beatriz.biopark.entities.Building;

public class BuildingDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String street;
	private String number;
	private String city;
	private String neighborhood;
	private String floors;
	private List<Apartment> apartments = new ArrayList<>();
	
	public BuildingDTO() {}
	
	public BuildingDTO(Building building) {
		this.id = building.getId();
		this.name = building.getName();
		this.street = building.getStreet();
		this.number = building.getNumber();
		this.city = building.getCity();
		this.neighborhood = building.getNeighborhood();
		this.floors = building.getFloors();
	}
	
	public BuildingDTO(Long id, String name, String street, String number, String city, String neighborhood, String floors) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.number = number;
		this.city = city;
		this.neighborhood = neighborhood;
		this.floors = floors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getFloors() {
		return floors;
	}

	public void setFloors(String floors) {
		this.floors = floors;
	}

	public List<Apartment> getApartment() {
		return apartments;
	}

	public void setApartment(List<Apartment> apartment) {
		this.apartments = apartment;
	}

}
