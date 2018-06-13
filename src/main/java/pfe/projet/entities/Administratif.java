package pfe.projet.entities;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Administratif extends Personnel implements Serializable {
	   private String taille;
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
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public int getPointure() {
		return pointure;
	}
	public void setPointure(int pointure) {
		this.pointure = pointure;
	}
	   
}