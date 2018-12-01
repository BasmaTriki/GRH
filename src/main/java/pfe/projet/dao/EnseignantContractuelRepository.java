package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.EnseignantContractuel;

public interface EnseignantContractuelRepository extends JpaRepository<EnseignantContractuel, Long> {
	@Query("select e from EnseignantContractuel e where e.nom like :x")
	public Page<EnseignantContractuel>chercher(@Param("x") String nom,Pageable pageable);
}

