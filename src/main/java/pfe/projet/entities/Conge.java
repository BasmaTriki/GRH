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
   private int nbJour;
   @ManyToOne
   @JoinColumn(name="matricule",referencedColumnName="matricule")
   private Personnel personnel;
   @ManyToOne
   @JoinColumn(name="id_typeCng",referencedColumnName="idCg")
   private TypeConge typeconge;
   
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
@Temporal(TemporalType.DATE)
   private Date dateReprise;
public Date getDateReprise() {
	return dateReprise;
}
public void setDateReprise(Date dateReprise) {
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
}