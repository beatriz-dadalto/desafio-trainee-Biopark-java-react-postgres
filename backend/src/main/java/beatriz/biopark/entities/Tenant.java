package beatriz.biopark.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tenant extends UserAbstract implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Rent> rents = new ArrayList<>();

	public Tenant() {
		super();
	}

	public Tenant(Long id, String name, String email, String phone, String password, Role role) {
		super(id, name, email, phone, password, role);
	}

	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

}
