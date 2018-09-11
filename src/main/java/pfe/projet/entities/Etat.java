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
public String getLibelleEtatAr() {
	return libelleEtatAr;
}

public void setLibelleEtatAr(String libelleEtatAr) {
	this.libelleEtatAr = libelleEtatAr;
}
}