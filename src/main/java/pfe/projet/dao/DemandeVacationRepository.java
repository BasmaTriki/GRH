package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.DemandeVacation;

public interface DemandeVacationRepository extends JpaRepository<DemandeVacation, Long> {
	@Query("select d from DemandeVacation d where d.nom like :x")
	public Page<DemandeVacation>chercher(@Param("x") String nom,Pageable pageable);
	@Query("select d from DemandeVacation d where d.etatdemande like :x")
	public Page<DemandeVacation>chercherEtat(@Param("x") String etat,Pageable pageable);
}
