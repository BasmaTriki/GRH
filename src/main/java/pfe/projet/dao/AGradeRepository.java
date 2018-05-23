package pfe.projet.dao;


import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.AGrade;


public interface AGradeRepository extends JpaRepository<AGrade, Long> {
	@Query("select g from AGrade g where g.dateEvaluation like :x")
	public Page<AGrade>chercher(@Param("x") Date date,Pageable pageable);
}
