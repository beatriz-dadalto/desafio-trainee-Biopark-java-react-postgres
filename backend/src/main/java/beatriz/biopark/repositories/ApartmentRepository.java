package beatriz.biopark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import beatriz.biopark.entities.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long>{

}
