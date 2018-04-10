package pfe.projet.entities;

import java.util.*;

/** @pdOid 4a96c1db-7723-436f-bc09-ec18dfbcd650 */
public class Service {
   /** @pdOid 96fbcf3c-4146-4861-a355-bc3a99f185c0 */
   private int idServ;
   
   /** @pdRoleInfo migr=no name=Administratif assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Administratif> administratif;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Administratif> getAdministratif() {
      if (administratif == null)
         administratif = new java.util.HashSet<Administratif>();
      return administratif;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAdministratif() {
      if (administratif == null)
         administratif = new java.util.HashSet<Administratif>();
      return administratif.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAdministratif */
   public void setAdministratif(java.util.Collection<Administratif> newAdministratif) {
      removeAllAdministratif();
      for (java.util.Iterator iter = newAdministratif.iterator(); iter.hasNext();)
         addAdministratif((Administratif)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAdministratif */
   public void addAdministratif(Administratif newAdministratif) {
      if (newAdministratif == null)
         return;
      if (this.administratif == null)
         this.administratif = new java.util.HashSet<Administratif>();
      if (!this.administratif.contains(newAdministratif))
         this.administratif.add(newAdministratif);
   }
   
   /** @pdGenerated default remove
     * @param oldAdministratif */
   public void removeAdministratif(Administratif oldAdministratif) {
      if (oldAdministratif == null)
         return;
      if (this.administratif != null)
         if (this.administratif.contains(oldAdministratif))
            this.administratif.remove(oldAdministratif);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAdministratif() {
      if (administratif != null)
         administratif.clear();
   }

}