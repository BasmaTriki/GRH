package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ChargeSem implements Serializable {
	@Id 
	@GeneratedValue
   private int id;
   private int nbHeure;
   @Temporal(TemporalType.DATE)
   private Date dateDebut;
   @Temporal(TemporalType.DATE)
   private Date dateFin; 
   @ManyToOne
   @JoinColumn(name="matricule",referencedColumnName="matricule")
   public EnseignantLibre enseignantLibreB;
   @ManyToOne
   @JoinColumn(name="semestre", referencedColumnName="idSem")
   private Semestre semestre;

public ChargeSem(int nbHeure, Date dateDebut, Date dateFin, EnseignantLibre enseignantLibreB, Semestre semestre) {
	super();
	this.nbHeure = nbHeure;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.enseignantLibreB = enseignantLibreB;
	this.semestre = semestre;
}

public ChargeSem() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Semestre getSemestre() {
	return semestre;
}

public void setSemestre(Semestre semestre) {
	this.semestre = semestre;
}

public int getNbHeure() {
	return nbHeure;
}

public void setNbHeure(int nbHeure) {
	this.nbHeure = nbHeure;
}

public Date getDateDebut() {
	return dateDebut;
}

public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}

public Date getDateFin() {
	return dateFin;
}

public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}

public EnseignantLibre getEnseignantLibreB() {
	return enseignantLibreB;
}

public void setEnseignantLibreB(EnseignantLibre enseignantLibreB) {
	this.enseignantLibreB = enseignantLibreB;
}

}