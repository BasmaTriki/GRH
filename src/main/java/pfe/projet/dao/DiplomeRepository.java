package pfe.projet.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Diplome;

public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
	@Query("select d from Diplome d where d.titre = :x")
	public Page<Diplome>chercher(@Param("x") String nom,Pageable pageable);
}
