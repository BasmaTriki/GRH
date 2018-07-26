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
   private long idChargeS;
   private int nbHeure;
   @Temporal(TemporalType.DATE)
   private Date dateDebut;
   @Temporal(TemporalType.DATE)
   private Date dateFin; 
   @ManyToOne
   @JoinColumn(name="matricule",referencedColumnName="matricule")
   public EnseignantLibre enseignantLibreB;

public int getNbHeure() {
	return nbHeure;
}

public void setNbHeure(int nbHeure) {
	this.nbHeure = nbHeure;
}

public Date getDateDebut() {
	return dateDebut;
}
public long getIdChargeS() {
	return idChargeS;
}

public void setIdChargeS(long idChargeS) {
	this.idChargeS = idChargeS;
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