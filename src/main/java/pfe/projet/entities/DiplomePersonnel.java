package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class DiplomePersonnel implements Serializable {
	@Temporal(TemporalType.DATE)
   private Date date;
    @EmbeddedId
   private ClefPrimaireD ck;
	
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public ClefPrimaireD getCk() {
	return ck;
}
public void setCk(ClefPrimaireD ck) {
	this.ck = ck;
}
public DiplomePersonnel() {
	super();
	// TODO Auto-generated constructor stub
}

}