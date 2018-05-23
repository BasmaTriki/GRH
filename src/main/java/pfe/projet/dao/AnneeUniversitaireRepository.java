package pfe.projet.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.AnneeUniversitaire;

public interface AnneeUniversitaireRepository extends JpaRepository<AnneeUniversitaire, Long> {
	@Query("select au from AnneeUniversitaire au where au.anneeDebut = :x")
	public Page<AnneeUniversitaire>chercher(@Param("x") int anneeDebut,Pageable pageable);

}
