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
   private int code;
   private String designation;
   @OneToMany
   private Collection<Mutation> mutation;
   
   public int getCode() {
	return code;
}

public void setCode(int code) {
	this.code = code;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public Collection<Mutation> getMutation() {
	return mutation;
}

public void setMutation(Collection<Mutation> mutation) {
	this.mutation = mutation;
}

}