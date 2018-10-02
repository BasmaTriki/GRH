package pfe.projet.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
	@Query("select c from Contrat c where c.enseignantPermanent.nom like :x or c.enseignantPermanent.nomAr like :x")
	public Page<Contrat>chercher(@Param("x") String nom,Pageable pageable);
	@Query("select  c from Contrat c where c.enseignantPermanent.idPers = :x")
	public List<Contrat>chercherContrat(@Param("x") long mat);
}
