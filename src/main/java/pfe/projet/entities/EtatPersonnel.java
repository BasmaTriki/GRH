package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    private String etatInactiveAr;
    @ManyToOne
    @JoinColumn(name="id_Org",referencedColumnName="idOrg")
    private Organisme lieuDetachement;
    @Temporal(TemporalType.DATE)
    private Date dateDebutDet;
    @Temporal(TemporalType.DATE)
    private Date dateFinDet;
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
public String getEtatInactiveAr() {
	return etatInactiveAr;
}

public void setEtatInactiveAr(String etatInactiveAr) {
	this.etatInactiveAr = etatInactiveAr;
}

public Organisme getLieuDetachement() {
	return lieuDetachement;
}

public void setLieuDetachement(Organisme lieuDetachement) {
	this.lieuDetachement = lieuDetachement;
}

public Date getDateDebutDet() {
	return dateDebutDet;
}

public void setDateDebutDet(Date dateDebutDet) {
	this.dateDebutDet = dateDebutDet;
}

public Date getDateFinDet() {
	return dateFinDet;
}

public void setDateFinDet(Date dateFinDet) {
	this.dateFinDet = dateFinDet;
}

}