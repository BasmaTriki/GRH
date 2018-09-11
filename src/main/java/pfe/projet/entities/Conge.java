package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.exolab.castor.types.DateTime;

@Entity
public class Conge implements Serializable {
	@Id 
	@GeneratedValue
   private long idCong;
	@Temporal(TemporalType.DATE)
   private Date dateDebut;
	@Temporal(TemporalType.DATE)
   private Date dateFin;
   private boolean reprise;
   private String valide;
   private String valideAr;
   private int nbJour;
   @ManyToOne
   @JoinColumn(name="idPers",referencedColumnName="idPers")
   private Personnel personnel;
   @ManyToOne
   @JoinColumn(name="id_typeCng",referencedColumnName="idCg")
   private TypeConge typeconge;
   private String certaficat;
   @Temporal(TemporalType.TIMESTAMP)
   private Calendar dateReprise;
   @Temporal(TemporalType.TIMESTAMP)
   private Calendar dateCreationConge;
   private String adresseConge;
   private String adresseCongeAr;
   private String telephoneConge;

public Calendar getDateCreationConge() {
	return dateCreationConge;
}
public void setDateCreationConge(Calendar dateCreationConge) {
	this.dateCreationConge = dateCreationConge;
}
public String getAdresseConge() {
	return adresseConge;
}
public void setAdresseConge(String adresseConge) {
	this.adresseConge = adresseConge;
}
public String getTelephoneConge() {
	return telephoneConge;
}
public void setTelephoneConge(String telephoneConge) {
	this.telephoneConge = telephoneConge;
}
public String getValide() {
	return valide;
}
public int getNbJour() {
	return nbJour;
}
public void setNbJour(int nbJour) {
	this.nbJour = nbJour;
}
public void setValide(String valide) {
	this.valide = valide;
}

public Calendar getDateReprise() {
	return dateReprise;
}
public void setDateReprise(Calendar dateReprise) {
	this.dateReprise = dateReprise;
}
public TypeConge getTypeconge() {
	return typeconge;
}
public void setTypeconge(TypeConge typeconge) {
	this.typeconge = typeconge;
}
public long getIdCong() {
	return idCong;
}
public void setIdCong(long idCong) {
	this.idCong = idCong;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public Date getDateFin() {
	return dateFin;
}
public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}
public boolean isReprise() {
	return reprise;
}
public void setReprise(boolean reprise) {
	this.reprise = reprise;
}
public Personnel getPersonnel() {
	return personnel;
}
public void setPersonnel(Personnel personnel) {
	this.personnel = personnel;
}
public String getCertaficat() {
	return certaficat;
}
public void setCertaficat(String certaficat) {
	this.certaficat = certaficat;
}
public String getValideAr() {
	return valideAr;
}
public void setValideAr(String valideAr) {
	this.valideAr = valideAr;
}
public String getAdresseCongeAr() {
	return adresseCongeAr;
}
public void setAdresseCongeAr(String adresseCongeAr) {
	this.adresseCongeAr = adresseCongeAr;
}

}