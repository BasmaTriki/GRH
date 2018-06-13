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
	@OneToMany(mappedBy="enseignant", cascade=CascadeType.ALL)
	public Collection<Enfant> enfants;
	@ManyToOne
	@JoinColumn(name="idcps",referencedColumnName="idcps")
    public Corps corps;
	@ManyToOne
	@JoinColumn(name="id_Sp",referencedColumnName="idSp")
    public Specialite specialite;
    public Collection<Enfant> getEnfants() {
		return enfants;
	}
	public void setEnfants(Collection<Enfant> enfants) {
		this.enfants = enfants;
	}
	public Corps getCorps() {
		return corps;
	}
	public void setCorps(Corps corps) {
		this.corps = corps;
	}
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

}