package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
@Entity
public class EnseignantLibre extends EnseignantVacataire implements Serializable {
   public String pratique;
   public String declarationH;
public String getPratique() {
	return pratique;
}
public void setPratique(String pratique) {
	this.pratique = pratique;
}
public String getDeclarationH() {
	return declarationH;
}
public void setDeclarationH(String declarationH) {
	this.declarationH = declarationH;
}

}