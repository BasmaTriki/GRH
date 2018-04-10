package pfe.projet.entities;

import java.util.*;

/** @pdOid eb72770b-998f-4b51-8dc3-6fd36bcbbbfe */
public class TypeConge {
   /** @pdOid 3cc18a33-a7d8-4417-b46f-c8cac0096217 */
   public long idCg;
   /** @pdOid 2c539c55-faed-495d-93f2-a48114ffb469 */
   public String nomCng;
   /** @pdOid 5f581c10-b83c-44cb-ab2a-c8adbb0423f4 */
   public String description;
   /** @pdOid 769c3599-382f-46e0-9ee2-d9c77e35a62d */
   public int nbMaxJrs;
   
   /** @pdRoleInfo migr=no name=Conges assc=association5 mult=1..* */
   public Conges[] conges;

}