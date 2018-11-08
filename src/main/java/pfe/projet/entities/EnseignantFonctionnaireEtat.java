package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class EnseignantFonctionnaireEtat extends EnseignantVacataire implements Serializable {
   public String autorisation;
   public int nbreMaxHeures;
  
public void setAutorisation(String autorisation) {
	this.autorisation = autorisation;
}
public String getAutorisation() {
	return autorisation;
}
public int getNbreMaxHeures() {
	return nbreMaxHeures;
}

public void setNbreMaxHeures(int nbreMaxHeures) {
	this.nbreMaxHeures = nbreMaxHeures;
}
}