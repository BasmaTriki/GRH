package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TypeConge implements Serializable {
	@Id 
	@GeneratedValue
   private long idCg;
   private String libelle;
   private String description;
   private int nbMaxJrs;
   @OneToMany
   public Collection<Conge>conges;

public long getIdCg() {
	return idCg;
}

public void setIdCg(long idCg) {
	this.idCg = idCg;
}


public String getLibelle() {
	return libelle;
}

public void setLibelle(String libelle) {
	this.libelle = libelle;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getNbMaxJrs() {
	return nbMaxJrs;
}

public void setNbMaxJrs(int nbMaxJrs) {
	this.nbMaxJrs = nbMaxJrs;
}

public Collection<Conge> getConges() {
	return conges;
}

public void setConges(Collection<Conge> conges) {
	this.conges = conges;
}


}