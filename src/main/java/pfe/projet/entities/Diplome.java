package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Diplome implements Serializable {
	@Id 
	@GeneratedValue
   public long idDip;
   public String titre;

public long getIdDip() {
	return idDip;
}

public void setIdDip(long idDip) {
	this.idDip = idDip;
}

public String getTitre() {
	return titre;
}

public Diplome() {
	super();
	// TODO Auto-generated constructor stub
}

public void setTitre(String titre) {
	this.titre = titre;
}

}