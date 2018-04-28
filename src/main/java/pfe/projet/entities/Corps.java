package pfe.projet.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Corps implements Serializable{
	@Id 
	@GeneratedValue
    private long idcps;
	private String libelle;
	@OneToMany
	private Collection<Enseignant> enseignant;
    public Collection<Enseignant> getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Collection<Enseignant> enseignant) {
		this.enseignant = enseignant;
	}
	public Corps(long idcps, Collection<Enseignant> enseignant) {
		super();
		this.idcps = idcps;
		this.enseignant = enseignant;
	}

	public long getIdcps() {
		return idcps;
	}

	public void setIdcps(long idcps) {
		this.idcps = idcps;
	}

	public Corps() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
