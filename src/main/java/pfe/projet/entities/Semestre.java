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
	@GeneratedValue
   private int idSem;
   public AnneeUniversitaire getAnneeuniversitaire() {
		return anneeuniversitaire;
	}

	public void setAnneeuniversitaire(AnneeUniversitaire anneeuniversitaire) {
		this.anneeuniversitaire = anneeuniversitaire;
	}


private String description;
   @OneToMany
   public Collection<ChargeSem> chargeSem;
   @ManyToOne
   @JoinColumn(name="id_annee",referencedColumnName="id")
   private AnneeUniversitaire anneeuniversitaire;
public int getIdSem() {
	return idSem;
}

public void setIdSem(int idSem) {
	this.idSem = idSem;
}


public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public void setChargeSem(Collection<ChargeSem> chargeSem) {
	this.chargeSem = chargeSem;
}

public Collection<ChargeSem> getChargeSem() {
	return chargeSem;
}

}