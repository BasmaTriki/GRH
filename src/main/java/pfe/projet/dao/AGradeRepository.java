package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pfe.projet.entities.AGrade;
import pfe.projet.entities.Grade;

public interface AGradeRepository extends JpaRepository<AGrade, Long> {
	@Query("select g from AGrade g where g.grade.titre like :x")
	public Page<AGrade>chercher(@Param("x") String mc,Pageable pageable);
}
