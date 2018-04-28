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
	return anneeUniversitaire;
}

public void setAnneeUniversitaire(Collection<AnneeUniversitaire> anneeUniversitaire) {
	this.anneeUniversitaire = anneeUniversitaire;
}


}