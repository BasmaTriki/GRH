package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class EnseignantVacataire extends Enseignant implements Serializable {
	/*@Temporal(TemporalType.DATE)
	public Date dateDebut;
	@Temporal(TemporalType.DATE)
	public Date dateFin;*/
	@Id
	private long cin;
	@ManyToOne
	@JoinColumn(name="id_annee",referencedColumnName="idAnnee")
	public AnneeUniversitaire anneUnv;

	public AnneeUniversitaire getAnneUnv() {
		return anneUnv;
	}

	public void setAnneUnv(AnneeUniversitaire anneUnv) {
		this.anneUnv = anneUnv;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}


}