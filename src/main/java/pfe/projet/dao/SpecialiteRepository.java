	package pfe.projet.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {
	@Query("select s from Specialite s where s.libelleSp like :x")
	public Page<Specialite>chercher(@Param("x") String mc,Pageable pageable);
	@Query("select s from Specialite s where s.libelleSpAr like :x")
	public Page<Specialite>chercherAr(@Param("x") String mc,Pageable pageable);
}
