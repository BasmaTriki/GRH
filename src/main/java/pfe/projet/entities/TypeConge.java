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
   private String libelleType;
   private String libelleTypeAr;
   private int nbMaxJrs;
   private boolean autorisation;
   private boolean actifPers;

public TypeConge() {
	super();
	// TODO Auto-generated constructor stub
}
public TypeConge(String libelleType, String libelleTypeAr, int nbMaxJrs, boolean autorisation) {
	super();
	this.libelleType = libelleType;
	this.libelleTypeAr = libelleTypeAr;
	this.nbMaxJrs = nbMaxJrs;
	this.autorisation = autorisation;
}

public long getIdCg() {
	return idCg;
}

public void setIdCg(long idCg) {
	this.idCg = idCg;
}

public int getNbMaxJrs() {
	return nbMaxJrs;
}

public void setNbMaxJrs(int nbMaxJrs) {
	this.nbMaxJrs = nbMaxJrs;
}

public boolean isAutorisation() {
	return autorisation;
}

public void setAutorisation(boolean autorisation) {
	this.autorisation = autorisation;
}

public String getLibelleType() {
	return libelleType;
}

public void setLibelleType(String libelleType) {
	this.libelleType = libelleType;
}

public String getLibelleTypeAr() {
	return libelleTypeAr;
}

public void setLibelleTypeAr(String libelleTypeAr) {
	this.libelleTypeAr = libelleTypeAr;
}
public boolean isActifPers() {
	return actifPers;
}
public void setActifPers(boolean actifPers) {
	this.actifPers = actifPers;
}


}