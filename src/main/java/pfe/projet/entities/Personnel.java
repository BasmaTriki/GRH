package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Personnel implements Serializable {
	@Id
   private long matricule;
   private long cin;
   private String nom;
   private String prenom;
   private String nompere;
   private String telephone;
   private String email;
   @Temporal(TemporalType.DATE)
   private Date datenaissance;
   private String lieuNaissance;
   private String adresse;
   private int codepostal;
   private String sexe;
   private String rib;
   private String etatCivil;
   private String nomConjoint;
   private String profConjoint;
   private boolean etat;
   @OneToMany
	private Collection<Enfant>enfants;
   @OneToMany
   private Collection<Conge> conges;
   @OneToMany
   public Collection<Mutation> mutation;
   @OneToMany
	private Collection<Periode> periodes;
public Collection<Periode> getPeriodes() {
	return periodes;
}
public void setPeriodes(Collection<Periode> periodes) {
	this.periodes = periodes;
}
public String getNomConjoint() {
	return nomConjoint;
}
public void setNomConjoint(String nomConjoint) {
	this.nomConjoint = nomConjoint;
}
public String getProfConjoint() {
	return profConjoint;
}
public void setProfConjoint(String profConjoint) {
	this.profConjoint = profConjoint;
}
public long getMatricule() {
	return matricule;
}

public void setMatricule(long matricule) {
	this.matricule = matricule;
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

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getDatenaissance() {
	return datenaissance;
}

public void setDatenaissance(Date datenaissance) {
	this.datenaissance = datenaissance;
}

public String getLieuNaissance() {
	return lieuNaissance;
}

public void setLieuNaissance(String lieuNaissance) {
	this.lieuNaissance = lieuNaissance;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public int getCodepostal() {
	return codepostal;
}

public void setCodepostal(int codepostal) {
	this.codepostal = codepostal;
}

public String getSexe() {
	return sexe;
}

public void setSexe(String sexe) {
	this.sexe = sexe;
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
public Collection<Conge> getConges() {
	return conges;
}
public void setConges(Collection<Conge> conges) {
	this.conges = conges;
}
public Collection<Mutation> getMutation() {
	return mutation;
}
public void setMutation(Collection<Mutation> mutation) {
	this.mutation = mutation;
}
public String getNompere() {
	return nompere;
}
public void setNompere(String nompere) {
	this.nompere = nompere;
}
public boolean isEtat() {
	return etat;
}
public void setEtat(boolean etat) {
	this.etat = etat;
}
public Collection<Enfant> getEnfants() {
	return enfants;
}
public void setEnfants(Collection<Enfant> enfants) {
	this.enfants = enfants;
}

}