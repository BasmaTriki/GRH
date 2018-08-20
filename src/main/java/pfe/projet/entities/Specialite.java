package pfe.projet.entities;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Specialite implements Serializable {
	@Id 
	@GeneratedValue
    private long idSp;
    private String libelleSp;
    private String libelleSpAr;
    @OneToMany
   public Collection<Enseignant> enseignant;
	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdSp() {
		return idSp;
	}
	public void setIdSp(long idSp) {
		this.idSp = idSp;
	}
	public String getLibelleSp() {
		return libelleSp;
	}
	public void setLibelleSp(String libelleSp) {
		this.libelleSp = libelleSp;
	}
	public Collection<Enseignant> getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Collection<Enseignant> enseignant) {
		this.enseignant = enseignant;
	}
	public String getLibelleSpAr() {
		return libelleSpAr;
	}
	public void setLibelleSpAr(String libelleSpAr) {
		this.libelleSpAr = libelleSpAr;
	}
	
}