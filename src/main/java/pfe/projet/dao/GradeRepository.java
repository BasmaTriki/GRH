package pfe.projet.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pfe.projet.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
	@Query("select g from Grade g where g.titre like :x")
	public Page<Grade>chercher(@Param("x") String nom,Pageable pageable);
	@Query("select g from Grade g where g.titreAr like :x")
	public Page<Grade>chercherAr(@Param("x") String nom,Pageable pageable);
}
