package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.EnseignantLibre;

public interface EnseignantLibreRepository  extends JpaRepository<EnseignantLibre, Long> {
	@Query("select e from EnseignantLibre e where e.nom = :x")
	public Page<EnseignantLibre>chercher(@Param("x") String nom,Pageable pageable);
}
