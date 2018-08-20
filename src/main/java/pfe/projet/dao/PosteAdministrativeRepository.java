package pfe.projet.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.PosteAdministrative;

public interface PosteAdministrativeRepository  extends JpaRepository<PosteAdministrative, Long> {
	@Query("select p from PosteAdministrative p where p.libellePos like :x")
	public Page<PosteAdministrative>chercher(@Param("x") String poste,Pageable pageable);
	@Query("select p from PosteAdministrative p where p.libellePosAr like :x")
	public Page<PosteAdministrative>chercherAr(@Param("x") String poste,Pageable pageable);
}

