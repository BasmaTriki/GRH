package pfe.projet.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class User implements Serializable{
	@Id
	private String login;
	private String motpasse;
	
@Temporal(TemporalType.DATE) 
private Date datecreation;
@ManyToOne
@JoinColumn(name="matricule",referencedColumnName="matricule")
public Personnel personnel;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getMotpasse() {
	return motpasse;
}
public void setMotpasse(String motpasse) {
	this.motpasse = motpasse;
}
public User(String login, String motpasse, Date datecreation, Personnel personnel) {
	super();
	this.login = login;
	this.motpasse = motpasse;
	this.datecreation = datecreation;
	this.personnel = personnel;
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
