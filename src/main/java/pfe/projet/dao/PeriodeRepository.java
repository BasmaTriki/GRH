package pfe.projet.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Periode;

public interface PeriodeRepository extends JpaRepository<Periode, Long> {
	@Query("select p from Periode p where p.dateDebut like :x")
	public Page<Periode>chercher(@Param("x") Date date,Pageable pageable);

}
