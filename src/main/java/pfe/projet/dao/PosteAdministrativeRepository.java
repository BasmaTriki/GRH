package pfe.projet.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.PosteAdministrative;

public interface PosteAdministrativeRepository  extends JpaRepository<PosteAdministrative, Long> {
	@Query("select p from PosteAdministrative p where p.libelle like :x")
	public Page<PosteAdministrative>chercher(@Param("x") Date date,Pageable pageable);

}

