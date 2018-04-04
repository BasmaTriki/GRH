package pfe.projet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class User implements Serializable{
@Id 
@GeneratedValue
private Long id;
private String login;
private String motpasse;
private String poste;
@Temporal(TemporalType.DATE)
private Date datecreation;
public void setId(Long id) {
	this.id = id;
}
private String email;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String login, String motpasse, String poste, Date datecreation, String email) {
	super();
	this.login = login;
	this.motpasse = motpasse;
	this.poste = poste;
	this.datecreation = datecreation;
	this.email = email;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
public String getPoste() {
	return poste;
}
public void setPoste(String poste) {
	this.poste = poste;
}
public Date getDatecreation() {
	return datecreation;
}
public void setDatecreation(Date datecreation) {
	this.datecreation = datecreation;
}
public Long getId() {
	return id;
}

}
