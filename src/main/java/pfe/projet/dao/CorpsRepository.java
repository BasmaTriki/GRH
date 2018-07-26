package pfe.projet.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pfe.projet.entities.Corps;

public interface CorpsRepository extends JpaRepository<Corps, Long> {
	@Query("select c from Corps c where c.libelle like :x")
	public Page<Corps>chercher(@Param("x") String libelle,Pageable pageable);
}
