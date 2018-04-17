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
public class Conges implements Serializable {
	@Id 
	@GeneratedValue
   private int idCong;
	@Temporal(TemporalType.DATE)
   private Date dateDebut;
	@Temporal(TemporalType.DATE)
   private Date dateFin;
   private boolean reprise;
   @ManyToOne
   @JoinColumn(name="matricule",referencedColumnName="matricule")
   private Personnel personnel;
   @ManyToOne
   @JoinColumn(name="id_typeCng",referencedColumnName="idCg")
   private TypeConge typeconge;
public TypeConge getTypeconge() {
	return typeconge;
}
public void setTypeconge(TypeConge typeconge) {
	this.typeconge = typeconge;
}
public int getIdCong() {
	return idCong;
}
public void setIdCong(int idCong) {
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