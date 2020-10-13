package it.beije.oort.bassanelli.library_application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.bassanelli.library_application.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmailAndPassword(String email, String password);
	
}
