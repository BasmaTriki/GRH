package pfe.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class DemandeVacation implements Serializable {
@Id 
@GeneratedValue
private long idDemande;
private long cin;
private String nom;
private String prenom;
private String email;
private String telephone;
private String adresse;
private String ville;
private int codePostal;
private String profilRech;
private String diplomes; 
private String etatdemande;
private String typeDemande;
@ManyToOne
@JoinColumn(name="id_Sp",referencedColumnName="idSp")
public Specialite specialite;
public Specialite getSpecialite() {
	return specialite;
}

public String getTypeDemande() {
	return typeDemande;
}

public void setTypeDemande(String typeDemande) {
	this.typeDemande = typeDemande;
}

public void setSpecialite(Specialite specialite) {
	this.specialite = specialite;
}

public long getIdDemande() {
	return idDemande;
}
public void setIdDemande(long idDemande) {
	this.idDemande = idDemande;
}
public String getDiplomes() {
	return diplomes;
}
public void setDiplomes(String diplomes) {
	this.diplomes = diplomes;
}
public long getCin() {
	return cin;
}
public void setCin(long cin) {
	this.cin = cin;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public int getCodePostal() {
	return codePostal;
}
public void setCodePostal(int codePostal) {
	this.codePostal = codePostal;
}
public String getProfilRech() {
	return profilRech;
}
public void setProfilRech(String profilRech) {
	this.profilRech = profilRech;
}

public String getEtatdemande() {
	return etatdemande;
}

public void setEtatdemande(String etatdemande) {
	this.etatdemande = etatdemande;
}

}
