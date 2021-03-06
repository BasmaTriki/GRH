package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.TypeMutation;

public interface TypeMutationRepository extends JpaRepository<TypeMutation, Long> {
	@Query("select tm from TypeMutation tm where tm.designationMutation like :x or tm.designationMutationAr like :x")
	public Page<TypeMutation>chercher(@Param("x") String designation,Pageable pageable);
	@Query("select tm from TypeMutation tm where tm.designationMutationAr like :x")
	public Page<TypeMutation>chercherAr(@Param("x") String designation,Pageable pageable);
}
