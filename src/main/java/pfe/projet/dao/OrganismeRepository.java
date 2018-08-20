package pfe.projet.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Organisme;

public interface OrganismeRepository extends JpaRepository<Organisme, Long> {
	@Query("select o from Organisme o where o.libelleOrg like :x")
	public Page<Organisme>chercher(@Param("x") String mc,Pageable pageable);
	@Query("select o from Organisme o where o.libelleOrgAr like :x")
	public Page<Organisme>chercherAr(@Param("x") String mc,Pageable pageable);
}
