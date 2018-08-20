package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Etat implements Serializable {
	@Id 
   private int idEtat;
   private String libelleEtat; 
   private String libelleEtatAr; 
   private String etatInactive;
   private String lieuDetachement;
   private String etatInactiveAr;
   private String lieuDetachementAr;
   @OneToMany
	private Collection<Personnel>personnel;
   
public Etat() {
	super();
	// TODO Auto-generated constructor stub
}

public Etat(int idEtat, String libelleEtat) {
	super();
	this.idEtat = idEtat;
	this.libelleEtat = libelleEtat;
}

public int getIdEtat() {
	return idEtat;
}
public void setIdEtat(int idEtat) {
	this.idEtat = idEtat;
}
public String getLibelleEtat() {
	return libelleEtat;
}
public void setLibelleEtat(String libelleEtat) {
	this.libelleEtat = libelleEtat;
}
public Collection<Personnel> getPersonnel() {
	return personnel;
}
public void setPersonnel(Collection<Personnel> personnel) {
	this.personnel = personnel;
}

public String getLibelleEtatAr() {
	return libelleEtatAr;
}

public void setLibelleEtatAr(String libelleEtatAr) {
	this.libelleEtatAr = libelleEtatAr;
}

public String getEtatInactive() {
	return etatInactive;
}

public void setEtatInactive(String etatInactive) {
	this.etatInactive = etatInactive;
}

public String getLieuDetachement() {
	return lieuDetachement;
}

public void setLieuDetachement(String lieuDetachement) {
	this.lieuDetachement = lieuDetachement;
}

public String getEtatInactiveAr() {
	return etatInactiveAr;
}

public void setEtatInactiveAr(String etatInactiveAr) {
	this.etatInactiveAr = etatInactiveAr;
}

public String getLieuDetachementAr() {
	return lieuDetachementAr;
}

public void setLieuDetachementAr(String lieuDetachementAr) {
	this.lieuDetachementAr = lieuDetachementAr;
}

}