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
	private String libelleServ;
	private String libelleServAr;
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
public String getLibelleServ() {
	return libelleServ;
}
public void setLibelleServ(String libelleServ) {
	this.libelleServ = libelleServ;
}
public String getLibelleServAr() {
	return libelleServAr;
}
public void setLibelleServAr(String libelleServAr) {
	this.libelleServAr = libelleServAr;
}


}