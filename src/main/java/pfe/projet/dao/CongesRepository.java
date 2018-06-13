package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pfe.projet.entities.Conge;

public interface CongesRepository extends JpaRepository<Conge, Long> {
	@Query("select c from Conge c where c.valide like :x")
	public Page<Conge>chercher(@Param("x") String valide,Pageable pageable);
	@Query("select c from Conge c where c.personnel.matricule = :x")
	public Page<Conge>chercherPerso(@Param("x") long mat,Pageable pageable);
	@Query("select c from Conge c where c.personnel.matricule = :x and c.typeconge.libelle like :y")
	public Page<Conge> chercherNbJour(@Param("x") long mat,@Param("y")String libelle,Pageable pageable);
}
