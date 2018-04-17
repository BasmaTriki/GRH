package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Service implements Serializable {
	@Id 
	@GeneratedValue
   private int idServ;
	@OneToMany
   public Collection<Administratif> administratif;
   public Collection<Administratif> getAdministratif() {
      if (administratif == null)
         administratif = new HashSet<Administratif>();
      return administratif;
   }
   public Iterator getIteratorAdministratif() {
      if (administratif == null)
         administratif = new HashSet<Administratif>();
      return administratif.iterator();
   }
   public void setAdministratif(Collection<Administratif> newAdministratif) {
      removeAllAdministratif();
      for (Iterator iter = newAdministratif.iterator(); iter.hasNext();)
         addAdministratif((Administratif)iter.next());
   }
   public void addAdministratif(Administratif newAdministratif) {
      if (newAdministratif == null)
         return;
      if (this.administratif == null)
         this.administratif = new HashSet<Administratif>();
      if (!this.administratif.contains(newAdministratif))
         this.administratif.add(newAdministratif);
   }
   public void removeAdministratif(Administratif oldAdministratif) {
      if (oldAdministratif == null)
         return;
      if (this.administratif != null)
         if (this.administratif.contains(oldAdministratif))
            this.administratif.remove(oldAdministratif);
   }
   public void removeAllAdministratif() {
      if (administratif != null)
         administratif.clear();
   }

public int getIdServ() {
	return idServ;
}

public void setIdServ(int idServ) {
	this.idServ = idServ;
}
   

}