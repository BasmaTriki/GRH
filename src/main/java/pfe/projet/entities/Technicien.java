package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class Technicien extends Administratif implements Serializable {
	@OneToMany
   public Collection<Privilege> privilege;
   public Collection<Privilege> getPrivilege() {
      if (privilege == null)
         privilege = new HashSet<Privilege>();
      return privilege;
   }
   public Iterator getIteratorPrivilege() {
      if (privilege == null)
         privilege = new HashSet<Privilege>();
      return privilege.iterator();
   }
 
   public void setPrivilege(Collection<Privilege> newPrivilege) {
      removeAllPrivilege();
      for (Iterator iter = newPrivilege.iterator(); iter.hasNext();)
         addPrivilege((Privilege)iter.next());
   }
   public void addPrivilege(Privilege newPrivilege) {
      if (newPrivilege == null)
         return;
      if (this.privilege == null)
         this.privilege = new java.util.HashSet<Privilege>();
      if (!this.privilege.contains(newPrivilege))
         this.privilege.add(newPrivilege);
   }

   public void removePrivilege(Privilege oldPrivilege) {
      if (oldPrivilege == null)
         return;
      if (this.privilege != null)
         if (this.privilege.contains(oldPrivilege))
            this.privilege.remove(oldPrivilege);
   }
   public void removeAllPrivilege() {
      if (privilege != null)
         privilege.clear();
   }

}