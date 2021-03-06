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
public class AGrade implements Serializable {
	@Id 
	@GeneratedValue
	private long id_agrade;
	@Temporal(TemporalType.DATE)
	public Date dateEvaluation;
	@ManyToOne
	@JoinColumn(name="id_grade",referencedColumnName="id")
	public Grade grade;
	@ManyToOne
	@JoinColumn(name="id_pers",referencedColumnName="idPers")
	private Personnel personnel;
	private boolean gradeActuel=false;
	@Temporal(TemporalType.DATE)
	   public Date dateRecrutement;
		@Temporal(TemporalType.DATE)
	   public Date dateTitularisation;
	public long getId_agrade() {
		return id_agrade;
	}

	public void setId_agrade(long id_agrade) {
		this.id_agrade = id_agrade;
	}

	
   public Date getDateEvaluation() {
	return dateEvaluation;
}

public void setDateEvaluation(Date dateEvaluation) {
	this.dateEvaluation = dateEvaluation;
}

public Grade getGrade() {
	return grade;
}

public void setGrade(Grade grade) {
	this.grade = grade;
}


public Personnel getPersonnel() {
	return personnel;
}

public void setPersonnel(Personnel personnel) {
	this.personnel = personnel;
}

public boolean isGradeActuel() {
	return gradeActuel;
}

public void setGradeActuel(boolean gradeActuel) {
	this.gradeActuel = gradeActuel;
}

public Date getDateRecrutement() {
	return dateRecrutement;
}

public void setDateRecrutement(Date dateRecrutement) {
	this.dateRecrutement = dateRecrutement;
}

public Date getDateTitularisation() {
	return dateTitularisation;
}

public void setDateTitularisation(Date dateTitularisation) {
	this.dateTitularisation = dateTitularisation;
}

}