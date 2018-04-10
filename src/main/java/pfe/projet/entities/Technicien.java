package pfe.projet.entities;

import java.util.*;

/** @pdOid 9cf0cc45-0b79-48db-9428-33f61c462879 */
public class Technicien extends Administratif {
   /** @pdRoleInfo migr=no name=Privilege assc=association6 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Privilege> privilege;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Privilege> getPrivilege() {
      if (privilege == null)
         privilege = new java.util.HashSet<Privilege>();
      return privilege;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPrivilege() {
      if (privilege == null)
         privilege = new java.util.HashSet<Privilege>();
      return privilege.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPrivilege */
   public void setPrivilege(java.util.Collection<Privilege> newPrivilege) {
      removeAllPrivilege();
      for (java.util.Iterator iter = newPrivilege.iterator(); iter.hasNext();)
         addPrivilege((Privilege)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPrivilege */
   public void addPrivilege(Privilege newPrivilege) {
      if (newPrivilege == null)
         return;
      if (this.privilege == null)
         this.privilege = new java.util.HashSet<Privilege>();
      if (!this.privilege.contains(newPrivilege))
         this.privilege.add(newPrivilege);
   }
   
   /** @pdGenerated default remove
     * @param oldPrivilege */
   public void removePrivilege(Privilege oldPrivilege) {
      if (oldPrivilege == null)
         return;
      if (this.privilege != null)
         if (this.privilege.contains(oldPrivilege))
            this.privilege.remove(oldPrivilege);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPrivilege() {
      if (privilege != null)
         privilege.clear();
   }

}