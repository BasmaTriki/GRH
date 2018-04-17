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
   private int idDep;
   private String nomDep;
   @OneToMany
   public Collection<Enseignant> enseignant;
public int getIdDep() {
	return idDep;
}
public void setIdDep(int idDep) {
	this.idDep = idDep;
}
public String getNomDep() {
	return nomDep;
}
public void setNomDep(String nomDep) {
	this.nomDep = nomDep;
}

}