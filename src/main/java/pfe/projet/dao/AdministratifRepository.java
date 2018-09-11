package pfe.projet.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pfe.projet.entities.Administratif;
import pfe.projet.entities.EnseignantPermanent;

public interface AdministratifRepository extends JpaRepository<Administratif, Long> {
	@Query("select a from Administratif a where a.nom like :x or a.nomAr like :x")
	public Page<Administratif>chercher(@Param("x") String nom,Pageable pageable);
	@Query("select a from Administratif a where a.prenom like :y and a.etat.idEtat=1")
	public Page<Administratif>chercherPrenom(@Param("y") String prenom,Pageable pageable);
	@Query("select a from Administratif a where a.etat.idEtat=1 and (a.login like '' or a.login=null)")
	public List<Administratif>chercherAdminSansCompte();
	
}
