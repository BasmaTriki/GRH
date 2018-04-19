package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class EnseignantFonctionnaireEtat extends EnseignantVacataire implements Serializable {
   public String autorisation;
   public int nbreMaxHeures;
   @OneToMany
   public Collection<AnneeUniversitaire> anneeUniversitaire;
   public String getAutorisation() {
	return autorisation;
}

public void setAutorisation(String autorisation) {
	this.autorisation = autorisation;
}

public int getNbreMaxHeures() {
	return nbreMaxHeures;
}

public void setNbreMaxHeures(int nbreMaxHeures) {
	this.nbreMaxHeures = nbreMaxHeures;
}


   public Collection<AnneeUniversitaire> getAnneeUniversitaire() {
      if (anneeUniversitaire == null)
         anneeUniversitaire = new java.util.HashSet<AnneeUniversitaire>();
      return anneeUniversitaire;
   }
   
  
   public Iterator getIteratorAnneeUniversitaire() {
      if (anneeUniversitaire == null)
         anneeUniversitaire = new java.util.HashSet<AnneeUniversitaire>();
      return anneeUniversitaire.iterator();
   }
   
  
   public void setAnneeUniversitaire(java.util.Collection<AnneeUniversitaire> newAnneeUniversitaire) {
      removeAllAnneeUniversitaire();
      for (Iterator iter = newAnneeUniversitaire.iterator(); iter.hasNext();)
         addAnneeUniversitaire((AnneeUniversitaire)iter.next());
   }
   
  
   public void addAnneeUniversitaire(AnneeUniversitaire newAnneeUniversitaire) {
      if (newAnneeUniversitaire == null)
         return;
      if (this.anneeUniversitaire == null)
         this.anneeUniversitaire = new java.util.HashSet<AnneeUniversitaire>();
      if (!this.anneeUniversitaire.contains(newAnneeUniversitaire))
         this.anneeUniversitaire.add(newAnneeUniversitaire);
   }
   
 
   public void removeAnneeUniversitaire(AnneeUniversitaire oldAnneeUniversitaire) {
      if (oldAnneeUniversitaire == null)
         return;
      if (this.anneeUniversitaire != null)
         if (this.anneeUniversitaire.contains(oldAnneeUniversitaire))
            this.anneeUniversitaire.remove(oldAnneeUniversitaire);
   }
 
   public void removeAllAnneeUniversitaire() {
      if (anneeUniversitaire != null)
         anneeUniversitaire.clear();
   }

}