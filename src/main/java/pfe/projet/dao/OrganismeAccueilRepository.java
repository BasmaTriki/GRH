package pfe.projet.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.OrganismeAccueil;

public interface OrganismeAccueilRepository extends JpaRepository<OrganismeAccueil, Long> {
	@Query("select o from OrganismeAccueil o where o.libelleOrg like :x")
	public Page<OrganismeAccueil>chercher(@Param("x") String mc,Pageable pageable);
}
