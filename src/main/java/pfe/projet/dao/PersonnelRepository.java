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
	@Query("select p from Personnel p where p.etat.idEtat= :x and (p.login like '' or p.login=null)")
	public List<Personnel>chercherPersonnel(@Param("x")int etat);
	@Query(value="select p.dtype from personnel p  where p.id_pers = :x",nativeQuery = true)
	public String chercherType(@Param("x") long mat);
	@Query(value="select * from personnel p  where p.login like :x and p.motpasse like :y and p.id_etat=1",nativeQuery = true)
	public Personnel chercherPersonnelLogin(@Param("x")String log,@Param("y")String motpass);
	@Query("select p from Personnel p where p.login like :x and p.etat.idEtat=1 and p.motpasse!=''")
	public Page<Personnel>chercherPersCompte(@Param("x")String login,Pageable pageable);

}