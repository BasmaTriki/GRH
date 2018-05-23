package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {
	@Query("select sem from Semestre sem where sem.description = :x")
	public Page<Semestre>chercher(@Param("x") String description,Pageable pageable);

}
