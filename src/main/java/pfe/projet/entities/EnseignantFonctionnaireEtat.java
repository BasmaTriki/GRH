package pfe.projet.entities;

import java.util.*;

/** @pdOid 570d9afe-096f-42d2-95bc-0611f04abb26 */
public class EnseignantFonctionnaireEtat extends EnseignantVacataire {
   /** @pdOid 7552da90-483f-4003-a185-5a9e4f6d555c */
   public String autorisation;
   /** @pdOid 5541e354-b237-49b9-872c-d4dbdfe387bf */
   public int nbreMaxHeures;
   
   /** @pdRoleInfo migr=no name=AnneeUniversitaire assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<AnneeUniversitaire> anneeUniversitaire;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<AnneeUniversitaire> getAnneeUniversitaire() {
      if (anneeUniversitaire == null)
         anneeUniversitaire = new java.util.HashSet<AnneeUniversitaire>();
      return anneeUniversitaire;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAnneeUniversitaire() {
      if (anneeUniversitaire == null)
         anneeUniversitaire = new java.util.HashSet<AnneeUniversitaire>();
      return anneeUniversitaire.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAnneeUniversitaire */
   public void setAnneeUniversitaire(java.util.Collection<AnneeUniversitaire> newAnneeUniversitaire) {
      removeAllAnneeUniversitaire();
      for (java.util.Iterator iter = newAnneeUniversitaire.iterator(); iter.hasNext();)
         addAnneeUniversitaire((AnneeUniversitaire)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAnneeUniversitaire */
   public void addAnneeUniversitaire(AnneeUniversitaire newAnneeUniversitaire) {
      if (newAnneeUniversitaire == null)
         return;
      if (this.anneeUniversitaire == null)
         this.anneeUniversitaire = new java.util.HashSet<AnneeUniversitaire>();
      if (!this.anneeUniversitaire.contains(newAnneeUniversitaire))
         this.anneeUniversitaire.add(newAnneeUniversitaire);
   }
   
   /** @pdGenerated default remove
     * @param oldAnneeUniversitaire */
   public void removeAnneeUniversitaire(AnneeUniversitaire oldAnneeUniversitaire) {
      if (oldAnneeUniversitaire == null)
         return;
      if (this.anneeUniversitaire != null)
         if (this.anneeUniversitaire.contains(oldAnneeUniversitaire))
            this.anneeUniversitaire.remove(oldAnneeUniversitaire);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAnneeUniversitaire() {
      if (anneeUniversitaire != null)
         anneeUniversitaire.clear();
   }

}