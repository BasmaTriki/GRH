package pfe.projet.dao;


import java.sql.Array;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Departement;
import pfe.projet.entities.EnseignantPermanent;

public interface EnseignantPermanentRepository extends JpaRepository<EnseignantPermanent, Long> {
	@Query("select e from EnseignantPermanent e where e.nom like :x or e.nomAr like :x")
	public Page<EnseignantPermanent>chercher(@Param("x") String nom,Pageable pageable);
	@Query("select e from EnseignantPermanent e where (e.prenom like :y or e.prenomAr like :y) and e.etat.idEtat=1")
	public Page<EnseignantPermanent>chercherPrenom(@Param("y") String prenom,Pageable pageable);
	@Query("select e from EnseignantPermanent e where e.etat.idEtat= 1 and (e.login like '' or e.login=null)")
	public List<EnseignantPermanent>chercherEnsgSansCompte();
	@Query("select COUNT(e.idPers) as Nbr from EnseignantPermanent e where e.etat.idEtat= 1 GROUP BY e.departement.idDep")
	public List<Long>NombreEnseignant();
	@Query("select e.departement.nomDepAr from EnseignantPermanent e where e.etat.idEtat= 1 GROUP BY e.departement.idDep")
	public List<String>ListeDepartement();
	@Query("select e.departement.nomDep from EnseignantPermanent e where e.etat.idEtat= 1 GROUP BY e.departement.idDep")
	public List<String>ListeDepartementFr();
}
