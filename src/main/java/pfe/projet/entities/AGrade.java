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
	private int id_agrade;
	public int getId_agrade() {
		return id_agrade;
	}

	public void setId_agrade(int id_agrade) {
		this.id_agrade = id_agrade;
	}
	@Temporal(TemporalType.DATE)
   public Date dateEvaluation;
	
   public Date getDateEvaluation() {
	return dateEvaluation;
}

public void setDateEvaluation(Date dateEvaluation) {
	this.dateEvaluation = dateEvaluation;
}

public Grade getGradeB() {
	return gradeB;
}

public void setGradeB(Grade gradeB) {
	this.gradeB = gradeB;
}
@ManyToOne
@JoinColumn(name="id",referencedColumnName="id")
public Grade gradeB;
@ManyToOne
@JoinColumn(name="matricule",referencedColumnName="matricule")
private Personnel personnel;

public Personnel getPersonnel() {
	return personnel;
}

public void setPersonnel(Personnel personnel) {
	this.personnel = personnel;
}
}