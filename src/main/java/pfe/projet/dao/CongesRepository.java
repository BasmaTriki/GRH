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
	@Query(value="select SUM(c.nb_jour) from Conge c where c.matricule = :x and c.id_type_cng = :y",nativeQuery = true)
	public Integer chercherNbJour(@Param("x") long mat,@Param("y")long idCg);
	@Query("select c from Conge c where c.typeconge.autorisation = :x and c.valide like :y")
	public Page<Conge>chercherCongeAutoriser(@Param("x")boolean auto,@Param("y")String valide,Pageable pageable);
}
