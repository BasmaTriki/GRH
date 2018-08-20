package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ChargeSem implements Serializable {
	@Id 
	@GeneratedValue
   private long idChargeS;
    public int nbrHeuresTD;
   public int nbrHeuresTP;
   public int nbrHeuresCR;
   @ManyToOne
   @JoinColumn(name="idPers",referencedColumnName="idPers")
   public EnseignantVacataire enseignantvacataire;
   @ManyToOne
   @JoinColumn(name="id_annee",referencedColumnName="idAnnee")
   private AnneeUniversitaire anneeuniversitaire;
   @ManyToOne
   @JoinColumn(name="id_sem",referencedColumnName="idSem")
   private Semestre semestre;
public long getIdChargeS() {
	return idChargeS;
}

public void setIdChargeS(long idChargeS) {
	this.idChargeS = idChargeS;
}
public AnneeUniversitaire getAnneeuniversitaire() {
	return anneeuniversitaire;
}

public void setAnneeuniversitaire(AnneeUniversitaire anneeuniversitaire) {
	this.anneeuniversitaire = anneeuniversitaire;
}

public Semestre getSemestre() {
	return semestre;
}

public void setSemestre(Semestre semestre) {
	this.semestre = semestre;
}

public EnseignantVacataire getEnseignantvacataire() {
	return enseignantvacataire;
}

public void setEnseignantvacataire(EnseignantVacataire enseignantvacataire) {
	this.enseignantvacataire = enseignantvacataire;
}

public int getNbrHeuresTD() {
	return nbrHeuresTD;
}

public void setNbrHeuresTD(int nbrHeuresTD) {
	this.nbrHeuresTD = nbrHeuresTD;
}

public int getNbrHeuresTP() {
	return nbrHeuresTP;
}

public void setNbrHeuresTP(int nbrHeuresTP) {
	this.nbrHeuresTP = nbrHeuresTP;
}

public int getNbrHeuresCR() {
	return nbrHeuresCR;
}

public void setNbrHeuresCR(int nbrHeuresCR) {
	this.nbrHeuresCR = nbrHeuresCR;
}

}