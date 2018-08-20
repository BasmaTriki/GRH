package pfe.projet.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.EnseignantPermanent;

public interface EnseignantPermanentRepository extends JpaRepository<EnseignantPermanent, Long> {
	@Query("select e from EnseignantPermanent e where e.nom like :x")
	public Page<EnseignantPermanent>chercher(@Param("x") String nom,Pageable pageable);
	@Query("select e from EnseignantPermanent e where e.prenom like :y and e.etat.idEtat=1")
	public Page<EnseignantPermanent>chercherPrenom(@Param("y") String prenom,Pageable pageable);
	@Query("select e from EnseignantPermanent e where e.departement.idDep = :x")
	public Page<EnseignantPermanent>chercherEnsgDepartement(@Param("x") long id,Pageable pageable);
}
