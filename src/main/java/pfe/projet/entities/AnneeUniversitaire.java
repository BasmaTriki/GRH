package pfe.projet.entities;

import java.util.*;

/** @pdOid 4c60e48b-f5b0-4387-9646-13c1b08944ea */
public class AnneeUniversitaire {
   /** @pdOid 351d6c87-cdb9-4f2b-ab41-089f1a0b3f8f */
   private int id;
   /** @pdOid 9dcaf075-ca8a-4b17-b62d-b4b415312006 */
   private int anneeDebut;
   /** @pdOid 9b36f440-0b5d-47b0-a91b-e8bcd1ddac7c */
   private int anneeFin;
   
   /** @pdRoleInfo migr=no name=Semestre assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Semestre> semestre;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Semestre> getSemestre() {
      if (semestre == null)
         semestre = new java.util.HashSet<Semestre>();
      return semestre;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSemestre() {
      if (semestre == null)
         semestre = new java.util.HashSet<Semestre>();
      return semestre.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSemestre */
   public void setSemestre(java.util.Collection<Semestre> newSemestre) {
      removeAllSemestre();
      for (java.util.Iterator iter = newSemestre.iterator(); iter.hasNext();)
         addSemestre((Semestre)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSemestre */
   public void addSemestre(Semestre newSemestre) {
      if (newSemestre == null)
         return;
      if (this.semestre == null)
         this.semestre = new java.util.HashSet<Semestre>();
      if (!this.semestre.contains(newSemestre))
         this.semestre.add(newSemestre);
   }
   
   /** @pdGenerated default remove
     * @param oldSemestre */
   public void removeSemestre(Semestre oldSemestre) {
      if (oldSemestre == null)
         return;
      if (this.semestre != null)
         if (this.semestre.contains(oldSemestre))
            this.semestre.remove(oldSemestre);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSemestre() {
      if (semestre != null)
         semestre.clear();
   }

}