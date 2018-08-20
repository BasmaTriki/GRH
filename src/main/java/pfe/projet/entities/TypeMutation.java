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
   private String designationMutation;
   private String designationMutationAr;
   public long getCode() {
	return code;
}

public void setCode(long code) {
	this.code = code;
}

public String getDesignationMutation() {
	return designationMutation;
}

public void setDesignationMutation(String designationMutation) {
	this.designationMutation = designationMutation;
}

public String getDesignationMutationAr() {
	return designationMutationAr;
}

public void setDesignationMutationAr(String designationMutationAr) {
	this.designationMutationAr = designationMutationAr;
}


}