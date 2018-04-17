package pfe.projet.dao;
import pfe.projet.entities.User;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
@Query("select u from User u where u.datecreation = :x")
	public Page<User>chercher(@Param("x") Date date,Pageable pageable);

}
