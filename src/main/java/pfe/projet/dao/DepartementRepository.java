package pfe.projet.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
	@Query("select d from Departement d where d.nomDep like :x or d.nomDepAr like :x")
	public Page<Departement>chercher(@Param("x") String mc,Pageable pageable);
	@Query("select d from Departement d where d.nomDepAr like :x")
	public Page<Departement>chercherAr(@Param("x") String mc,Pageable pageable);
	@Query("select d from Departement d where d.nomDepAr like :x")
	public Departement chercherOneAr(@Param("x") String mc);
}
