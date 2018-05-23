package pfe.projet.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PosteAdministrative {
	@Id 
	@GeneratedValue
	private long id;
	private String libelle;
	@OneToMany
	private Collection<Periode> periodes;
	public Collection<Periode> getPeriodes() {
		return periodes;
	}
	public void setPeriodes(Collection<Periode> periodes) {
		this.periodes = periodes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
