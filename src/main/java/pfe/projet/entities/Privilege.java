package pfe.projet.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Privilege implements Serializable {
	@Id 
	@GeneratedValue
   private int idP;
   private String designation;
   private int qtestock;
   
public int getQtestock() {
	return qtestock;
}
public void setQtestock(int qtestock) {
	this.qtestock = qtestock;
}
public int getIdP() {
	return idP;
}
public void setIdP(int idP) {
	this.idP = idP;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}

}