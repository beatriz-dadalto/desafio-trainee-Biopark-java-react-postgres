package beatriz.biopark.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lessor extends UserAbstract implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Advertise> advertises = new ArrayList<>();

	public Lessor() {
		super();
	}

	public Lessor(Long id, String name, String email, String phone, String password, Role role) {
		super(id, name, email, phone, password, role);
	}

	public List<Advertise> getAdvertises() {
		return advertises;
	}

	public void setAdvertises(List<Advertise> advertises) {
		this.advertises = advertises;
	}
	
}
