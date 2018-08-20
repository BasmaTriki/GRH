package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Mutation implements Serializable {
	@Id 
	@GeneratedValue
   private long idMut;
	   @ManyToOne
	   @JoinColumn(name="idPers",referencedColumnName="idPers")
	   private Personnel personnel;
	   @ManyToOne
	   @JoinColumn(name="id_type_mut",referencedColumnName="code")
	   private TypeMutation typemutation;
	   @ManyToOne
	   @JoinColumn(name="id_Org",referencedColumnName="idOrg")
	   private Organisme organismeAccueil;
	   @Temporal(TemporalType.DATE)
	   private Date date_mut;
   public Date getDate_mut() {
		return date_mut;
	}
	public void setDate_mut(Date date_mut) {
		this.date_mut = date_mut;
	}
public Mutation() {
	super();
	// TODO Auto-generated constructor stub
}
public Organisme getOrganismeAccueil() {
	return organismeAccueil;
}
public void setOrganismeAccueil(Organisme organismeAccueil) {
	this.organismeAccueil = organismeAccueil;
}
public TypeMutation getTypemutation() {
	return typemutation;
}
public void setTypemutation(TypeMutation typemutation) {
	this.typemutation = typemutation;
}
public long getIdMut() {
	return idMut;
}
public void setIdMut(long idMut) {
	this.idMut = idMut;
}
public Personnel getPersonnel() {
	return personnel;
}
public void setPersonnel(Personnel personnel) {
	this.personnel = personnel;
}

}