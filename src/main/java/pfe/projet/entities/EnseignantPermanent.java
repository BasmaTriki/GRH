package pfe.projet.entities;
import java.util.*;

/** @pdOid 7b39da15-5d88-46f6-85ca-813d45607968 */
public class EnseignantPermanent extends Enseignant {
   /** @pdOid 524ef343-7137-4bd2-9581-1178fa160152 */
   public Date dateRecrutement;
   /** @pdOid ce04d490-dc14-48ab-91f3-f6d6cfced97f */
   public Date dateDemarcation;
   /** @pdOid 9fd7d458-5e4f-491a-8f14-5081c4375d6f */
   public int nbEnfants;
   
   /** @pdRoleInfo migr=no name=AnneeUniversitaire assc=association13 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
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