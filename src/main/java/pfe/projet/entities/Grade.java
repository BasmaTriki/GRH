package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Grade implements Serializable{
	@Id 
	@GeneratedValue
    public long id;
    public String titre;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public  String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
   

}