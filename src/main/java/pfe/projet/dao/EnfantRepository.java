package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Enfant;


public interface EnfantRepository  extends JpaRepository<Enfant, Long> {
		@Query("select e from Enfant e where e.nom = :x")
		public Page<Enfant>chercher(@Param("x") String nom,Pageable pageable);
}
