package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
@Entity
public class EnseignantLibre extends EnseignantVacataire implements Serializable {
   public String declarationH;
public String getDeclarationH() {
	return declarationH;
}
public void setDeclarationH(String declarationH) {
	this.declarationH = declarationH;
}

}