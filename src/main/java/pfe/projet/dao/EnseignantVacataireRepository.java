package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.EnseignantVacataire;

public interface EnseignantVacataireRepository extends JpaRepository<EnseignantVacataire, Long> {
	@Query("select e from EnseignantVacataire e where e.nom = :x")
	public Page<EnseignantVacataire>chercher(@Param("x") String nom,Pageable pageable);
}

