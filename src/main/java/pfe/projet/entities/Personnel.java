package pfe.projet.entities;

import java.util.*;

/** @pdOid 1396f219-f51b-41c4-820d-416b680e9550 */
public class Personnel {
   /** @pdOid 9131bc00-3f5c-4d2a-a1e0-20018c4408a3 */
   public long matricule;
   /** @pdOid 6691b048-052a-455f-8cf1-46a6b8c92be6 */
   public long cin;
   /** @pdOid b833614c-fa24-417b-baf4-ce2918e93d68 */
   public String nom;
   /** @pdOid eb17b7a9-0c53-4c44-8a44-d5c87158c363 */
   public String prenom;
   /** @pdOid 10cb207d-c506-4716-aa2d-faab96cf31e8 */
   public String telephone;
   /** @pdOid 31cbea0e-9cfe-4cba-939b-4ece18e8f829 */
   public String email;
   /** @pdOid e90ea9a7-aa7f-4f57-8bc8-7c005890e4c7 */
   public Date datenaissance;
   /** @pdOid 6a59e4de-558b-456b-9eab-149af77f246c */
   public String lieuNaissance;
   /** @pdOid 85d84570-97fc-4c1e-8335-e1c34e47f043 */
   public String adresse;
   /** @pdOid 73180877-2049-4a84-8875-f05c00ef91da */
   public int codepostal;
   /** @pdOid 76647318-5321-4cbe-a546-f7ce1b1e46dd */
   public String sexe;
   /** @pdOid bf12c54e-608a-4d9b-b845-283099fa184d */
   public String rib;
   /** @pdOid adc2f612-45a0-455f-920c-65aabfe34cc8 */
   public String etatCivil;
   
   public DiplomePersonnel[] avoir;
   /** @pdRoleInfo migr=no name=Conges assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Conges> conges;
   public java.util.Collection association9;
   /** @pdRoleInfo migr=no name=Mutation assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Mutation> mutation;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Conges> getConges() {
      if (conges == null)
         conges = new java.util.HashSet<Conges>();
      return conges;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorConges() {
      if (conges == null)
         conges = new java.util.HashSet<Conges>();
      return conges.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newConges */
   public void setConges(java.util.Collection<Conges> newConges) {
      removeAllConges();
      for (java.util.Iterator iter = newConges.iterator(); iter.hasNext();)
         addConges((Conges)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newConges */
   public void addConges(Conges newConges) {
      if (newConges == null)
         return;
      if (this.conges == null)
         this.conges = new java.util.HashSet<Conges>();
      if (!this.conges.contains(newConges))
         this.conges.add(newConges);
   }
   
   /** @pdGenerated default remove
     * @param oldConges */
   public void removeConges(Conges oldConges) {
      if (oldConges == null)
         return;
      if (this.conges != null)
         if (this.conges.contains(oldConges))
            this.conges.remove(oldConges);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllConges() {
      if (conges != null)
         conges.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Mutation> getMutation() {
      if (mutation == null)
         mutation = new java.util.HashSet<Mutation>();
      return mutation;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMutation() {
      if (mutation == null)
         mutation = new java.util.HashSet<Mutation>();
      return mutation.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMutation */
   public void setMutation(java.util.Collection<Mutation> newMutation) {
      removeAllMutation();
      for (java.util.Iterator iter = newMutation.iterator(); iter.hasNext();)
         addMutation((Mutation)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMutation */
   public void addMutation(Mutation newMutation) {
      if (newMutation == null)
         return;
      if (this.mutation == null)
         this.mutation = new java.util.HashSet<Mutation>();
      if (!this.mutation.contains(newMutation))
         this.mutation.add(newMutation);
   }
   
   /** @pdGenerated default remove
     * @param oldMutation */
   public void removeMutation(Mutation oldMutation) {
      if (oldMutation == null)
         return;
      if (this.mutation != null)
         if (this.mutation.contains(oldMutation))
            this.mutation.remove(oldMutation);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMutation() {
      if (mutation != null)
         mutation.clear();
   }

}