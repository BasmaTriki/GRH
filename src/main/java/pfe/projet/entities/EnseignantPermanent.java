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
	   public Date dateTitularisation;
		@OneToMany
		public Collection<AnneeUniversitaire> anneeUniversitaire;
   public Date getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}

	public Date getDateTitularisation() {
		return dateTitularisation;
	}

	public void setDateTitularisation(Date dateTitularisation) {
		this.dateTitularisation = dateTitularisation;
	}

	public Collection<AnneeUniversitaire> getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(Collection<AnneeUniversitaire> anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

}