package pfe.projet.entities;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Departement  implements Serializable {
	@Id 
	@GeneratedValue
   private long idDep;
   private String nomDep;
   private String nomDepAr;
   @OneToMany
   public Collection<Enseignant> enseignant;
   public Collection<Enseignant> getEnseignant() {
	return enseignant;
}
public void setEnseignant(Collection<Enseignant> enseignant) {
	this.enseignant = enseignant;
}
public long getIdDep() {
	return idDep;
}
public void setIdDep(long idDep) {
	this.idDep = idDep;
}
public String getNomDep() {
	return nomDep;
}
public void setNomDep(String nomDep) {
	this.nomDep = nomDep;
}
public String getNomDepAr() {
	return nomDepAr;
}
public void setNomDepAr(String nomDepAr) {
	this.nomDepAr = nomDepAr;
}

}