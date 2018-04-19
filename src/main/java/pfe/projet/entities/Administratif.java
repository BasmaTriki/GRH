package pfe.projet.entities;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Administratif extends Personnel implements Serializable {
	   private String etat;
	   private String taille;
	   private int nbEnfants;
	   private String specialite;
	   private int pointure;
	   @ManyToOne
	   @JoinColumn(name="idServ",referencedColumnName="idServ")
	   private Service service;
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public String getEtat() {
		   
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public int getNbEnfants() {
		return nbEnfants;
	}
	public void setNbEnfants(int nbEnfants) {
		this.nbEnfants = nbEnfants;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public int getPointure() {
		return pointure;
	}
	public void setPointure(int pointure) {
		this.pointure = pointure;
	}
	   
}