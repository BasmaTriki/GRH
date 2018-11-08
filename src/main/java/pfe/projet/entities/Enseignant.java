package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Enseignant extends Personnel implements Serializable {
	@ManyToOne
	@JoinColumn(name="idDep",referencedColumnName="idDep")
    public Departement departement;
	@ManyToOne
	@JoinColumn(name="id_Sp",referencedColumnName="idSp")
    public Specialite specialite;
	public String Diplomes;
public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public String getDiplomes() {
		return Diplomes;
	}
	public void setDiplomes(String diplomes) {
		Diplomes = diplomes;
	}

}