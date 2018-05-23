package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class DiplomePersonnel implements Serializable {
	@Id 
	@GeneratedValue
	private long id_DipP;
	@Temporal(TemporalType.DATE)
    private Date date;
	@ManyToOne
	@JoinColumn(name="matricule",referencedColumnName="matricule")
    public Personnel personnel;
	@ManyToOne
	@JoinColumn(name="idDip",referencedColumnName="idDip")
     public Diplome diplome;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public long getId_DipP() {
	return id_DipP;
}
public void setId_DipP(long id_DipP) {
	this.id_DipP = id_DipP;
}
public Personnel getPersonnel() {
	return personnel;
}
public void setPersonnel(Personnel personnel) {
	this.personnel = personnel;
}
public Diplome getDiplome() {
	return diplome;
}
public void setDiplome(Diplome diplome) {
	this.diplome = diplome;
}
public DiplomePersonnel() {
	super();
	// TODO Auto-generated constructor stub
}

}