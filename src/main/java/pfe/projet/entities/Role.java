package pfe.projet.entities;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Role implements Serializable {
	@Id 
    private long idRole;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(long idRole, String type) {
		super();
		this.idRole = idRole;
		this.type = type;
	}
	private String type;
	public long getIdRole() {
		return idRole;
	}
	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	   
}