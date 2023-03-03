package beatriz.biopark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import beatriz.biopark.entities.Advertise;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Long>{

}