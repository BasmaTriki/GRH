package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class AnneeUniversitaire implements Serializable {
	@Id 
	@GeneratedValue
   private long idAnnee;
   private int anneeDebut;
   private int anneeFin;
public long getIdAnnee() {
	return idAnnee;
}

public void setIdAnnee(long idAnnee) {
	this.idAnnee = idAnnee;
}

public int getAnneeDebut() {
	return anneeDebut;
}

public void setAnneeDebut(int anneeDebut) {
	this.anneeDebut = anneeDebut;
}

public int getAnneeFin() {
	return anneeFin;
}

public void setAnneeFin(int anneeFin) {
	this.anneeFin = anneeFin;
}


}