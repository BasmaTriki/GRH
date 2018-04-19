package pfe.projet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class User implements Serializable{
@EmbeddedId
private ClePrimaire ck;
@Temporal(TemporalType.DATE) 
private Date datecreation;
@ManyToOne
@JoinColumn(name="matricule",referencedColumnName="matricule")
public Personnel personnel;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public ClePrimaire getCk() {
	return ck;
}
public User(ClePrimaire ck, Date datecreation, Personnel personnel) {
	super();
	this.ck = ck;
	this.datecreation = datecreation;
	this.personnel = personnel;
}
public void setCk(ClePrimaire ck) {
	this.ck = ck;
}
public Personnel getPersonnel() {
	return personnel;
}
public void setPersonnel(Personnel personnel) {
	this.personnel = personnel;
}
public Date getDatecreation() {
	return datecreation;
}
public void setDatecreation(Date datecreation) {
	this.datecreation = datecreation;
}
}
