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
   private int idServ;
	@OneToMany
   public Collection<Administratif> administratif;
public int getIdServ() {
	return idServ;
}
public void setIdServ(int idServ) {
	this.idServ = idServ;
}
public Collection<Administratif> getAdministratif() {
	return administratif;
}
public void setAdministratif(Collection<Administratif> administratif) {
	this.administratif = administratif;
}


}