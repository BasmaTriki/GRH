package pfe.projet.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Enfant;


public interface EnfantRepository  extends JpaRepository<Enfant, Long> {
		@Query("select e from Enfant e where e.nom like :x")
		public Page<Enfant>chercher(@Param("x") String nom,Pageable pageable);
		@Query("select e from Enfant e where e.personnel.idPers = :x")
		public List<Enfant>chercherEnfantEnseig(@Param("x")long mat);
		@Query("select count(e) from Enfant e where e.personnel.idPers = :x")
		public Integer chercherNbEnfant(@Param("x")long mat);
}
