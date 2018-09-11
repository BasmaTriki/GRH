package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class EtatPersonnel implements Serializable {
	@Id 
	@GeneratedValue
    private int idEtatP;
	@ManyToOne
	@JoinColumn(name="id_etat",referencedColumnName="idEtat")
	private Etat etat;
	@ManyToOne
	@JoinColumn(name="id_pers",referencedColumnName="idPers")
	private Personnel personnel;
    private String etatInactive;
    private String lieuDetachement;
    private String etatInactiveAr;
    private String lieuDetachementAr;
   
public EtatPersonnel() {
	super();
	// TODO Auto-generated constructor stub
}

public int getIdEtatP() {
	return idEtatP;
}

public void setIdEtatP(int idEtatP) {
	this.idEtatP = idEtatP;
}

public Etat getEtat() {
	return etat;
}

public void setEtat(Etat etat) {
	this.etat = etat;
}

public Personnel getPersonnel() {
	return personnel;
}

public void setPersonnel(Personnel personnel) {
	this.personnel = personnel;
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