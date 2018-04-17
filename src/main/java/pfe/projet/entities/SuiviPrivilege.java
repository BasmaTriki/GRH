package pfe.projet.entities;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SuiviPrivilege implements Serializable{
	@Id 
	@GeneratedValue
   private int id_suivi;
   private Date date;
   private int qte;
   @ManyToOne
   @JoinColumn(name="id_priv",referencedColumnName="idP")
   public Privilege privilege;
   @ManyToOne
   @JoinColumn(name="matricule",referencedColumnName="matricule")
   private Administratif administratif;
public SuiviPrivilege() {
	super();
	// TODO Auto-generated constructor stub
}
public Privilege getPrivilege() {
	return privilege;
}
public void setPrivilege(Privilege privilege) {
	this.privilege = privilege;
}
public Administratif getAdministratif() {
	return administratif;
}
public void setAdministratif(Administratif administratif) {
	this.administratif = administratif;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getQte() {
	return qte;
}
public void setQte(int qte) {
	this.qte = qte;
}
public int getId_suivi() {
	return id_suivi;
}
public void setId_suivi(int id_suivi) {
	this.id_suivi = id_suivi;
}

}