package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Personnel implements Serializable {
	@Id
	@GeneratedValue
   private long idPers;
   private long matricule;
   private long cin;
   private String nom;
   private String nomAr;
   private String prenom;
   private String prenomAr;
   private String nompere;
   private String nompereAr;
   private String telephone;
   private String email;
   @Temporal(TemporalType.DATE)
   private Date datenaissance;
   private String lieuNaissance;
   private String lieuNaissanceAr;
   private String adresse;
   private String adresseAr;
   private int codepostal;
   private String sexe;
   private String sexeAr;
   private String rib;
   private String etatCivil;
   private String nomConjoint;
   private String profConjoint;
   private String etatCivilAr;
   private String nomConjointAr;
   private String profConjointAr;
   @JoinColumn(name="id_Org",referencedColumnName="idOrg")
   private Organisme organismeOrigine;
   @Temporal(TemporalType.DATE)
   private Date dateEntree;
   @Column(unique=true)
   private String login;
   @Column(unique=true)
   private String motpasse;
   @OneToMany
	private Collection<Enfant>enfants;
   @OneToMany
   private Collection<Conge> conges;
   @OneToMany
   public Collection<Mutation> mutation;
   @OneToMany
	private Collection<Periode> periodes;
   @ManyToOne
   @JoinColumn(name="idRole",referencedColumnName="idRole")
   private Role role;
   @ManyToOne
   @JoinColumn(name="id_etat",referencedColumnName="idEtat")
   private Etat etat;
   @Lob
   private byte[]photo; 
  
public long getIdPers() {
	return idPers;
}
public void setIdPers(long idPers) {
	this.idPers = idPers;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
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

public Collection<Enfant> getEnfants() {
	return enfants;
}
public void setEnfants(Collection<Enfant> enfants) {
	this.enfants = enfants;
}
public void addMutation(Mutation mut)
{
	this.mutation.add(mut);
}
public byte[] getPhoto() {
	return photo;
}
public void setPhoto(byte[] photo) {
	this.photo = photo;
}
public Etat getEtat() {
	return etat;
}
public void setEtat(Etat etat) {
	this.etat = etat;
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
public String getNompereAr() {
	return nompereAr;
}
public void setNompereAr(String nompereAr) {
	this.nompereAr = nompereAr;
}
public String getLieuNaissanceAr() {
	return lieuNaissanceAr;
}
public void setLieuNaissanceAr(String lieuNaissanceAr) {
	this.lieuNaissanceAr = lieuNaissanceAr;
}
public String getAdresseAr() {
	return adresseAr;
}
public void setAdresseAr(String adresseAr) {
	this.adresseAr = adresseAr;
}
public String getEtatCivilAr() {
	return etatCivilAr;
}
public void setEtatCivilAr(String etatCivilAr) {
	this.etatCivilAr = etatCivilAr;
}
public String getNomConjointAr() {
	return nomConjointAr;
}
public void setNomConjointAr(String nomConjointAr) {
	this.nomConjointAr = nomConjointAr;
}
public String getProfConjointAr() {
	return profConjointAr;
}
public void setProfConjointAr(String profConjointAr) {
	this.profConjointAr = profConjointAr;
}
public Organisme getOrganismeOrigine() {
	return organismeOrigine;
}
public void setOrganismeOrigine(Organisme organismeOrigine) {
	this.organismeOrigine = organismeOrigine;
}
public String getSexeAr() {
	return sexeAr;
}
public void setSexeAr(String sexeAr) {
	this.sexeAr = sexeAr;
}
public Date getDateEntree() {
	return dateEntree;
}
public void setDateEntree(Date dateEntree) {
	this.dateEntree = dateEntree;
}

}
