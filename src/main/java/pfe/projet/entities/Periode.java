package pfe.projet.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Periode {
	@Id 
	@GeneratedValue
	private long id_periode;
	@Temporal(TemporalType.DATE)
	   public Date dateDebut;
	@Temporal(TemporalType.DATE)
	   public Date dateFin;
	  @ManyToOne
	  @JoinColumn(name="id_poste",referencedColumnName="id")
	  private PosteAdministrative posteAdmin;
	  @ManyToOne
	  @JoinColumn(name="matricule",referencedColumnName="matricule")
	  private Personnel personnel;
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public PosteAdministrative getPosteAdmin() {
		return posteAdmin;
	}
	public void setPosteAdmin(PosteAdministrative posteAdmin) {
		this.posteAdmin = posteAdmin;
	}
	public long getId_periode() {
		return id_periode;
	}
	public void setId_periode(long id_periode) {
		this.id_periode = id_periode;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
