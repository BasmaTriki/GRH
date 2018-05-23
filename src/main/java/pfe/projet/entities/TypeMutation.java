package pfe.projet.entities;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypeMutation implements Serializable {
	
	@Id
	@GeneratedValue
   private long code;
   private String designation;
    
   public long getCode() {
	return code;
}

public void setCode(long code) {
	this.code = code;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

}