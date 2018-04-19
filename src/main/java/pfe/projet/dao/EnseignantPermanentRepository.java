package pfe.projet.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.EnseignantPermanent;
import pfe.projet.entities.User;

public interface EnseignantPermanentRepository extends JpaRepository<EnseignantPermanent, Long> {
	@Query("select e from EnseignantPermanent e where e.nom = :x")
	public Page<EnseignantPermanent>chercher(@Param("x") String nom,Pageable pageable);
}
