package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;

@Entity
public class Ouvrier extends Administratif  implements Serializable {

   private String categorie;

public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
	this.categorie = categorie;
}

}