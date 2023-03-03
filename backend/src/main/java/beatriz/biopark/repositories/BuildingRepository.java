package beatriz.biopark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import beatriz.biopark.entities.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long>{

}
