package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.TypeConge;

public interface TypeCongeRepository extends JpaRepository<TypeConge, Long> {
	@Query("select tc from TypeConge tc where tc.libelle like :x")
	public Page<TypeConge>chercher(@Param("x") String nomCng,Pageable pageable);

}
