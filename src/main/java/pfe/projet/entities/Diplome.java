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
   public String titreDip;
   public String titreDipAr;
public long getIdDip() {
	return idDip;
}

public void setIdDip(long idDip) {
	this.idDip = idDip;
}

public Diplome() {
	super();
	// TODO Auto-generated constructor stub
}

public String getTitreDip() {
	return titreDip;
}

public void setTitreDip(String titreDip) {
	this.titreDip = titreDip;
}

public String getTitreDipAr() {
	return titreDipAr;
}

public void setTitreDipAr(String titreDipAr) {
	this.titreDipAr = titreDipAr;
}


}