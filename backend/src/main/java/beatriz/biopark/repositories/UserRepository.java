package beatriz.biopark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import beatriz.biopark.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
