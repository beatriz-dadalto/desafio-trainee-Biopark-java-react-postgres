package beatriz.biopark.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_building")
public class Building implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String street;
	private String number;
	private String city;
	private String neighborhood;
	private String floors;

	@JsonIgnore
	@OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
	private List<Apartment> apartments = new ArrayList<>();

	public Building() {
	}

	public Building(Long id, String name, String street, String number, String city, String neighborhood,
			String floors) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.number = number;
		this.city = city;
		this.neighborhood = neighborhood;
		this.floors = floors;
	}

	public Building(String name, String street, String number, String city, String neighborhood, String floors) {
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
