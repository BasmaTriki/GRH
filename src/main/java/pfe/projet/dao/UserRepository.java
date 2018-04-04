package pfe.projet.dao;
import pfe.projet.entities.User;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
@Query("select u from User u where u.login like :x")
	public Page<User>chercher(@Param("x") String mc,Pageable pageable);

}
