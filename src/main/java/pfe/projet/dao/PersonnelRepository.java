package pfe.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pfe.projet.entities.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

}
