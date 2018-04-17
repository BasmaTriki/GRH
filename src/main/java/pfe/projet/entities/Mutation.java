package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Mutation implements Serializable {
	@Id 
	@GeneratedValue
   private int idMut;
   private String orgAcceuil;
   @ManyToOne
   @JoinColumn(name="matricule",referencedColumnName="matricule")
   private Personnel personnel;
   @ManyToOne
   @JoinColumn(name="id_type_mut",referencedColumnName="code")
   private TypeMutation typemutation;
public Mutation() {
	super();
	// TODO Auto-generated constructor stub
}
public TypeMutation getTypemutation() {
	return typemutation;
}
public void setTypemutation(TypeMutation typemutation) {
	this.typemutation = typemutation;
}
public int getIdMut() {
	return idMut;
}
public void setIdMut(int idMut) {
	this.idMut = idMut;
}
public String getOrgAcceuil() {
	return orgAcceuil;
}
public void setOrgAcceuil(String orgAcceuil) {
	this.orgAcceuil = orgAcceuil;
}
public Personnel getPersonnel() {
	return personnel;
}
public void setPersonnel(Personnel personnel) {
	this.personnel = personnel;
}

}