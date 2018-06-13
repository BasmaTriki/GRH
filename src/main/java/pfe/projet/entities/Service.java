package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Service implements Serializable {
	@Id 
	@GeneratedValue
    private long idServ;
	private String libelle;
	@OneToMany
   public Collection<Administratif> administratif;

public Service() {
	super();
	// TODO Auto-generated constructor stub
}
public long getIdServ() {
	return idServ;
}
public void setIdServ(long idServ) {
	this.idServ = idServ;
}
public Collection<Administratif> getAdministratif() {
	return administratif;
}
public void setAdministratif(Collection<Administratif> administratif) {
	this.administratif = administratif;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}

}