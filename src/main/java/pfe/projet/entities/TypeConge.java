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
   private String nomCng;
   private String description;
   private int nbMaxJrs;
   @OneToMany(mappedBy ="typeconge",cascade =CascadeType.ALL)
   public Collection<Conges> conges;

public long getIdCg() {
	return idCg;
}

public void setIdCg(long idCg) {
	this.idCg = idCg;
}

public String getNomCng() {
	return nomCng;
}

public void setNomCng(String nomCng) {
	this.nomCng = nomCng;
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

public Collection<Conges> getConges() {
	return conges;
}

public void setConges(Collection<Conges> conges) {
	this.conges = conges;
}


}