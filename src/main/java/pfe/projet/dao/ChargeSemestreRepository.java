package pfe.projet.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.ChargeSem;;

public interface ChargeSemestreRepository extends JpaRepository<ChargeSem, Long> {
	@Query("select cs from ChargeSem cs where cs.dateDebut = :x")
	public Page<ChargeSem>chercher(@Param("x")Date dateDebut,Pageable pageable);


}
