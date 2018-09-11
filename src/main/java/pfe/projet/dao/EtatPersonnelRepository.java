	package pfe.projet.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pfe.projet.entities.EtatPersonnel;


public interface EtatPersonnelRepository extends JpaRepository<EtatPersonnel, Integer> {
	@Query("select e from EtatPersonnel e where e.etatInactive like :x")
	public Page<EtatPersonnel>chercher(@Param("x") String mc,Pageable pageable);
	@Query("select e from EtatPersonnel e where e.personnel.idPers= :x and e.etat.idEtat=:y")
	public EtatPersonnel chercherEtatPersonnel(@Param("x")long mc,@Param("y")Integer idEtat);
}
