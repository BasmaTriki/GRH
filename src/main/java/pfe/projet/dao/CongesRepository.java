package pfe.projet.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pfe.projet.entities.Conge;

public interface CongesRepository extends JpaRepository<Conge, Long> {
	@Query("select c from Conge c where c.valide like :x and c.personnel.etat.idEtat=1 ORDER BY c.dateCreationConge DESC")
	public Page<Conge>chercher(@Param("x") String valide,Pageable pageable);
	@Query("select c from Conge c where c.personnel.idPers = :x and c.personnel.etat.idEtat=1")
	public Page<Conge>chercherPerso(@Param("x") long mat,Pageable pageable);
	@Query("select SUM(c.nbJour) from Conge c where c.personnel.idPers = :x and c.typeconge.idCg = :y and YEAR(c.dateDebut)=:z and (c.valide like 'accepte' or c.valide like 'validé')")
	public Integer chercherNbJour(@Param("x") long mat,@Param("y")long idCg,@Param("z")Integer year);
	@Query("select c from Conge c where c.typeconge.autorisation = :x and c.valide like :y and c.personnel.etat.idEtat=1")
	public Page<Conge>chercherCongeAutoriser(@Param("x")boolean auto,@Param("y")String valide,Pageable pageable);	
	@Query("select c from Conge c where c.personnel.idPers = :x and c.personnel.etat.idEtat=1")
	public List<Conge>chercherPersoConge(@Param("x") long mat);
}
