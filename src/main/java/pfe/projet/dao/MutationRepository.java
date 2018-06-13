package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Mutation;

public interface MutationRepository extends JpaRepository<Mutation, Long> {
	@Query("select m from Mutation m where m.organismeAccueil.libelleOrg like :x")
	public Page<Mutation>chercher(@Param("x") String org_accueil,Pageable pageable); 

}
