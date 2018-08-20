package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Semestre implements Serializable  {
	@Id 
   private int idSem;
   private String descriptionSem;
   private String descriptionSemAr;
   @OneToMany
   public Collection<ChargeSem> chargeSem;
   /*@ManyToOne
   @JoinColumn(name="id_annee",referencedColumnName="idAnnee")
   private AnneeUniversitaire anneeuniversitaire;*/
public int getIdSem() {
	return idSem;
}

public Semestre() {
	super();
	// TODO Auto-generated constructor stub
}

public Semestre(int idSem, String descriptionSem, String descriptionSemAr) {
	super();
	this.idSem = idSem;
	this.descriptionSem = descriptionSem;
	this.descriptionSemAr = descriptionSemAr;
}

public void setIdSem(int idSem) {
	this.idSem = idSem;
}


public void setChargeSem(Collection<ChargeSem> chargeSem) {
	this.chargeSem = chargeSem;
}

public Collection<ChargeSem> getChargeSem() {
	return chargeSem;
}

public String getDescriptionSem() {
	return descriptionSem;
}

public void setDescriptionSem(String descriptionSem) {
	this.descriptionSem = descriptionSem;
}

public String getDescriptionSemAr() {
	return descriptionSemAr;
}

public void setDescriptionSemAr(String descriptionSemAr) {
	this.descriptionSemAr = descriptionSemAr;
}

}