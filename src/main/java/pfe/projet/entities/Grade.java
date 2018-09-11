package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Grade implements Serializable{
	@Id 
	@GeneratedValue
    private long id;
    private String titre;
    private String titreAr;
    @OneToMany
   	private Collection<AGrade>agrades;
	@ManyToOne
	@JoinColumn(name="idcps",referencedColumnName="idcps")
    public Corps corps;
	
public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
public Grade(String titre, String titreAr) {
	super();
	this.titre = titre;
	this.titreAr = titreAr;
}

public Collection<AGrade> getAgrades() {
		return agrades;
	}
	public void setAgrades(Collection<AGrade> agrades) {
		this.agrades = agrades;
	}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Corps getCorps() {
	return corps;
}
public void setCorps(Corps corps) {
	this.corps = corps;
}
public  String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getTitreAr() {
	return titreAr;
}
public void setTitreAr(String titreAr) {
	this.titreAr = titreAr;
}

}