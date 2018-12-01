package pfe.projet.entities;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Contrat implements Serializable {
	@Id
	@GeneratedValue
   private long idContrat;
   @Temporal(TemporalType.DATE)
   public Date dateDebutCont;
   @Temporal(TemporalType.DATE)
   public Date dateFinCont;
   @ManyToOne
   @JoinColumn(name="id_pers",referencedColumnName="idPers")
   private EnseignantContractuel enseignantContractuel;
   
public Contrat() {
	super();
	// TODO Auto-generated constructor stub
}
public long getIdContrat() {
	return idContrat;
}
public void setIdContrat(long idContrat) {
	this.idContrat = idContrat;
}

public Date getDateDebutCont() {
	return dateDebutCont;
}
public void setDateDebutCont(Date dateDebutCont) {
	this.dateDebutCont = dateDebutCont;
}
public Date getDateFinCont() {
	return dateFinCont;
}
public void setDateFinCont(Date dateFinCont) {
	this.dateFinCont = dateFinCont;
}
public EnseignantContractuel getEnseignantContractuel() {
	return enseignantContractuel;
}
public void setEnseignantContractuel(EnseignantContractuel enseignantContractuel) {
	this.enseignantContractuel = enseignantContractuel;
}

}