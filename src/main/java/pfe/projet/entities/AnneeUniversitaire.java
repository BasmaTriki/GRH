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
   private long id;
   private int anneeDebut;
   private int anneeFin;
   @OneToMany
   public Collection<Semestre> semestres;
   public long getId() {
	return id;
}
public void setId(long id) {
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
public Collection<Semestre> getSemestres() {
	return semestres;
}
public void setSemestres(Collection<Semestre> semestres) {
	this.semestres = semestres;
}

}