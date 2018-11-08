package pfe.projet.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DemandeVacation implements Serializable {
@Id 
@GeneratedValue
private long idDemande;
private String cin;
private String nom;
private String prenom;
private String nomAr;
private String prenomAr;
private String email;
private String telephone;
private String adresse;
private String adresseAr;
private String ville;
private int codePostal;
@Temporal(TemporalType.DATE)
private Date datenaissance;
private String nompere;
private String nompereAr;
private String lieuNaissance;
private String lieuNaissanceAr;
private String rib;
private String etatCivil;
private String diplomes; 
private String etatdemande;
private String typeDemande;
@Temporal(TemporalType.TIMESTAMP)
private Calendar dateCreationDem;
@Lob
private byte[]photo; 
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
public String getCin() {
	return cin;
}
public void setCin(String cin) {
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
public String getEtatdemande() {
	return etatdemande;
}

public void setEtatdemande(String etatdemande) {
	this.etatdemande = etatdemande;
}

public String getNomAr() {
	return nomAr;
}

public void setNomAr(String nomAr) {
	this.nomAr = nomAr;
}

public String getPrenomAr() {
	return prenomAr;
}

public void setPrenomAr(String prenomAr) {
	this.prenomAr = prenomAr;
}

public String getAdresseAr() {
	return adresseAr;
}

public void setAdresseAr(String adresseAr) {
	this.adresseAr = adresseAr;
}

public Calendar getDateCreationDem() {
	return dateCreationDem;
}

public void setDateCreationDem(Calendar dateCreationDem) {
	this.dateCreationDem = dateCreationDem;
}

public Date getDatenaissance() {
	return datenaissance;
}

public void setDatenaissance(Date datenaissance) {
	this.datenaissance = datenaissance;
}

public String getNompere() {
	return nompere;
}

public void setNompere(String nompere) {
	this.nompere = nompere;
}

public String getNompereAr() {
	return nompereAr;
}

public void setNompereAr(String nompereAr) {
	this.nompereAr = nompereAr;
}

public String getLieuNaissance() {
	return lieuNaissance;
}

public void setLieuNaissance(String lieuNaissance) {
	this.lieuNaissance = lieuNaissance;
}

public String getLieuNaissanceAr() {
	return lieuNaissanceAr;
}

public void setLieuNaissanceAr(String lieuNaissanceAr) {
	this.lieuNaissanceAr = lieuNaissanceAr;
}

public String getRib() {
	return rib;
}

public void setRib(String rib) {
	this.rib = rib;
}

public String getEtatCivil() {
	return etatCivil;
}

public void setEtatCivil(String etatCivil) {
	this.etatCivil = etatCivil;
}

public byte[] getPhoto() {
	return photo;
}

public void setPhoto(byte[] photo) {
	this.photo = photo;
}

}
