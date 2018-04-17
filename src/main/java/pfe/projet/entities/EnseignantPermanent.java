package pfe.projet.entities;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class EnseignantPermanent extends Enseignant implements Serializable {
	@Temporal(TemporalType.DATE)
	   public Date dateRecrutement;
		@Temporal(TemporalType.DATE)
	   public Date dateDemarcation;
	   public int nbEnfants;
	   @OneToMany
	   public Collection<AnneeUniversitaire> anneeUniversitaire;
   public Date getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}

	public Date getDateDemarcation() {
		return dateDemarcation;
	}

	public void setDateDemarcation(Date dateDemarcation) {
		this.dateDemarcation = dateDemarcation;
	}

	public int getNbEnfants() {
		return nbEnfants;
	}

	public void setNbEnfants(int nbEnfants) {
		this.nbEnfants = nbEnfants;
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