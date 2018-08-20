package pfe.projet.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.ChargeAnnee;

public interface ChargeAnneeRepository extends JpaRepository<ChargeAnnee, Long> {
	@Query("select au from ChargeAnnee au where au.anneeuniversitaire.anneeDebut = :x and au.anneeuniversitaire.anneeFin=:y")
	public Page<ChargeAnnee>chercher(@Param("x") int anneeD,@Param("y") int anneeF,Pageable pageable);

}
