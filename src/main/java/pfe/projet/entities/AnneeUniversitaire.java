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
   private int id;
   private int anneeDebut;
   private int anneeFin;
   @OneToMany
   public Collection<Semestre> semestre;
   public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public Collection<Semestre> getSemestre() {
	return semestre;
}
public void setSemestre(Collection<Semestre> semestre) {
	this.semestre = semestre;
}

}