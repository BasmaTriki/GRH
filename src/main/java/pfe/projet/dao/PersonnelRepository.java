package pfe.projet.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Conge;
import pfe.projet.entities.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
	@Query("select p from Personnel p where p.etat= :x and (p.login like '' or p.login=null)")
	public List<Personnel>chercherPersonnel(@Param("x")boolean etat);
	@Query(value="select p.dtype from personnel p  where p.matricule = :x",nativeQuery = true)
	public String chercherType(@Param("x") long mat);
	@Query(value="select * from personnel p  where p.login like :x and p.motpasse like :y and p.etat=true",nativeQuery = true)
	public Personnel chercherPersonnelLogin(@Param("x")String log,@Param("y")String motpass);
	@Query("select p from Personnel p where p.login like :x and p.etat=true and p.motpasse!=''")
	public Page<Personnel>chercherPers(@Param("x")String login,Pageable pageable);

}