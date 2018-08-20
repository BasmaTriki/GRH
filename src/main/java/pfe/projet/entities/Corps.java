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
	private String libelleCps;
	private String libelleCpsAr;
	
	public Corps(String libelleCps, String libelleCpsAr) {
		super();
		this.libelleCps = libelleCps;
		this.libelleCpsAr = libelleCpsAr;
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

	public String getLibelleCps() {
		return libelleCps;
	}

	public void setLibelleCps(String libelleCps) {
		this.libelleCps = libelleCps;
	}

	public String getLibelleCpsAr() {
		return libelleCpsAr;
	}

	public void setLibelleCpsAr(String libelleCpsAr) {
		this.libelleCpsAr = libelleCpsAr;
	}

}
