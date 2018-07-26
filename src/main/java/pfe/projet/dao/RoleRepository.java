package pfe.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query("select r from Role r where r.type like :x")
	public Page<Role>chercher(@Param("x") String type,Pageable pageable);
}
