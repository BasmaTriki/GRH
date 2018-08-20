package pfe.projet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Enfant implements Serializable {
	@Id
	@GeneratedValue
private long num;
private String nom;
private String nomAr;
private Date dateNais;

@ManyToOne
@JoinColumn(name="idPers",referencedColumnName="idPers")
private Personnel personnel;
public Enfant() {
	super();
	// TODO Auto-generated constructor stub
}
public long getNum() {
	return num;
}
public void setNum(long num) {
	this.num = num;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Date getDateNais() {
	return dateNais;
}
public void setDateNais(Date dateNais) {
	this.dateNais = dateNais;
}
public Personnel getPersonnel() {
	return personnel;
}
public void setPersonnel(Personnel personnel) {
	this.personnel = personnel;
}
public String getNomAr() {
	return nomAr;
}
public void setNomAr(String nomAr) {
	this.nomAr = nomAr;
}

}
