package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
	@Query("select s from Service s where s.libelleServ like :x or s.libelleServAr like :x")
	public Page<Service>chercher(@Param("x") String nom,Pageable pageable);
	@Query("select s from Service s where s.libelleServAr like :x")
	public Page<Service>chercherAr(@Param("x") String nom,Pageable pageable);
}
