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
      if (mutation == null)
         mutation = new java.util.HashSet<Mutation>();
      return mutation;
   }
   
   public Iterator getIteratorMutation() {
      if (mutation == null)
         mutation = new java.util.HashSet<Mutation>();
      return mutation.iterator();
   }
   
 
   public void setMutation(Collection<Mutation> newMutation) {
      removeAllMutation();
      for (Iterator iter = newMutation.iterator(); iter.hasNext();)
         addMutation((Mutation)iter.next());
   }
   
   public void addMutation(Mutation newMutation) {
      if (newMutation == null)
         return;
      if (this.mutation == null)
         this.mutation = new HashSet<Mutation>();
      if (!this.mutation.contains(newMutation))
         this.mutation.add(newMutation);
   }
   
  
   public void removeMutation(Mutation oldMutation) {
      if (oldMutation == null)
         return;
      if (this.mutation != null)
         if (this.mutation.contains(oldMutation))
            this.mutation.remove(oldMutation);
   }
   
  
   public void removeAllMutation() {
      if (mutation != null)
         mutation.clear();
   }

}