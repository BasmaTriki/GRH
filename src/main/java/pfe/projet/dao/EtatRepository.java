	package pfe.projet.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Etat;
import pfe.projet.entities.Specialite;

public interface EtatRepository extends JpaRepository<Etat, Integer> {
	@Query("select e from Etat e where e.libelleEtat like :x")
	public Page<Etat>chercher(@Param("x") String mc,Pageable pageable);
	@Query("select e from Etat e where e.libelleEtatAr like :x")
	public Page<Etat>chercherAr(@Param("x") String mc,Pageable pageable);
	@Query("select e from Etat e where e.libelleEtatAr like :x")
	public Etat chercherOneAr(@Param("x") String mc);
}
