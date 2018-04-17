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
      if (semestre == null)
         semestre = new java.util.HashSet<Semestre>();
      return semestre;
   }
   public Iterator getIteratorSemestre() {
      if (semestre == null)
         semestre = new java.util.HashSet<Semestre>();
      return semestre.iterator();
   }
   public void setSemestre(java.util.Collection<Semestre> newSemestre) {
      removeAllSemestre();
      for (Iterator iter = newSemestre.iterator(); iter.hasNext();)
         addSemestre((Semestre)iter.next());
   }
   public void addSemestre(Semestre newSemestre) {
      if (newSemestre == null)
         return;
      if (this.semestre == null)
         this.semestre = new java.util.HashSet<Semestre>();
      if (!this.semestre.contains(newSemestre))
         this.semestre.add(newSemestre);
   }
   public void removeSemestre(Semestre oldSemestre) {
      if (oldSemestre == null)
         return;
      if (this.semestre != null)
         if (this.semestre.contains(oldSemestre))
            this.semestre.remove(oldSemestre);
   }
   public void removeAllSemestre() {
      if (semestre != null)
         semestre.clear();
   }

}