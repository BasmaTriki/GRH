package pfe.projet.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ClefPrimaireD implements Serializable{
	@ManyToOne
	   @JoinColumn(name="matricule",referencedColumnName="matricule")
public Personnel personnel;
	@ManyToOne
	   @JoinColumn(name="idDip",referencedColumnName="idDip")
public Diplome diplome;
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
	public ClefPrimaireD() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diplome == null) ? 0 : diplome.hashCode());
		result = prime * result + ((personnel == null) ? 0 : personnel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClefPrimaireD other = (ClefPrimaireD) obj;
		if (diplome == null) {
			if (other.diplome != null)
				return false;
		} else if (!diplome.equals(other.diplome))
			return false;
		if (personnel == null) {
			if (other.personnel != null)
				return false;
		} else if (!personnel.equals(other.personnel))
			return false;
		return true;
	}
	
}

