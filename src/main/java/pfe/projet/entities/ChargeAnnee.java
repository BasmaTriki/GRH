package pfe.projet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ChargeAnnee implements Serializable{
	@Id 
	@GeneratedValue
   private long id;
   private int nbHeure;
   @ManyToOne
   @JoinColumn(name="matricule",referencedColumnName="matricule")
   public EnseignantFonctionnaireEtat enseignantFoncEtat;
   @ManyToOne
   @JoinColumn(name="id_annee",referencedColumnName="id")
   private AnneeUniversitaire anneeuniversitaire;
public ChargeAnnee() {
	super();
	// TODO Auto-generated constructor stub
}
public ChargeAnnee(int nbHeure, EnseignantFonctionnaireEtat enseignantFoncEtat, AnneeUniversitaire anneeuniversitaire) {
	super();
	this.nbHeure = nbHeure;
	this.enseignantFoncEtat = enseignantFoncEtat;
	this.anneeuniversitaire = anneeuniversitaire;
}
public long getId() {
	return id;
}
public void setId(long id2) {
	this.id = id2;
}
public int getNbHeure() {
	return nbHeure;
}
public void setNbHeure(int nbHeure) {
	this.nbHeure = nbHeure;
}
public EnseignantFonctionnaireEtat getEnseignantFoncEtat() {
	return enseignantFoncEtat;
}
public void setEnseignantFoncEtat(EnseignantFonctionnaireEtat enseignantFoncEtat) {
	this.enseignantFoncEtat = enseignantFoncEtat;
}
public AnneeUniversitaire getAnneeuniversitaire() {
	return anneeuniversitaire;
}
public void setAnneeuniversitaire(AnneeUniversitaire anneeuniversitaire) {
	this.anneeuniversitaire = anneeuniversitaire;
}

}
