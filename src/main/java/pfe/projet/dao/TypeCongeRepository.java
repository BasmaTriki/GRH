package pfe.projet.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.TypeConge;

public interface TypeCongeRepository extends JpaRepository<TypeConge, Long> {
	@Query("select tc from TypeConge tc where tc.libelleType like :x or tc.libelleTypeAr like :x")
	public Page<TypeConge>chercher(@Param("x") String nomCng,Pageable pageable);
	@Query("select tc from TypeConge tc where tc.libelleTypeAr like :x")
	public Page<TypeConge>chercherAr(@Param("x") String nomCng,Pageable pageable);
	@Query("select tc from TypeConge tc where tc.typePers like :x")
	public List<TypeConge>chercherParType(@Param("x") String typeCng);
}
