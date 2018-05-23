package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.EnseignantFonctionnaireEtat;

public interface EnseignantFonctionnaireEtatRepository extends JpaRepository<EnseignantFonctionnaireEtat, Long> {
	@Query("select e from EnseignantFonctionnaireEtat e where e.nom = :x")
	public Page<EnseignantFonctionnaireEtat>chercher(@Param("x") String nom,Pageable pageable); 

	}

