package pfe.projet.dao;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pfe.projet.entities.DiplomePersonnel;

public interface DiplomePersonnelRepository extends JpaRepository<DiplomePersonnel, Long> {
	@Query("select d from DiplomePersonnel d where d.date = :x")
	public Page<DiplomePersonnel>chercher(@Param("x") Date date,Pageable pageable);
}
