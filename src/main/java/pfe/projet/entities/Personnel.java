package pfe.projet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Personnel implements Serializable {
	@Id
   public long matricule;
   public long cin;
   public String nom;
   public String prenom;
   public String telephone;
   public String email;
   @Temporal(TemporalType.DATE)
   public Date datenaissance;
   public String lieuNaissance;
   public String adresse;
   public int codepostal;
   public String sexe;
   public String rib;
   public String etatCivil;
   @OneToMany(mappedBy ="personnel",cascade =CascadeType.ALL)
   public Collection<Conges> conges;
   @OneToMany(mappedBy ="personnel",cascade =CascadeType.ALL)
   public Collection<Mutation> mutation;
   public Collection<Conges> getConges() {
      if (conges == null)
         conges = new HashSet<Conges>();
      return conges;
   }
   public Iterator getIteratorConges() {
      if (conges == null)
         conges = new java.util.HashSet<Conges>();
      return conges.iterator();
   }
   public void setConges(java.util.Collection<Conges> newConges) {
      removeAllConges();
      for (Iterator iter = newConges.iterator(); iter.hasNext();)
         addConges((Conges)iter.next());
   }
   public void addConges(Conges newConges) {
      if (newConges == null)
         return;
      if (this.conges == null)
         this.conges = new java.util.HashSet<Conges>();
      if (!this.conges.contains(newConges))
         this.conges.add(newConges);
   }
   public void removeConges(Conges oldConges) {
      if (oldConges == null)
         return;
      if (this.conges != null)
         if (this.conges.contains(oldConges))
            this.conges.remove(oldConges);
   }
   public void removeAllConges() {
      if (conges != null)
         conges.clear();
   }
   public Collection<Mutation> getMutation() {
      if (mutation == null)
         mutation = new HashSet<Mutation>();
      return mutation;
   }
   public Iterator getIteratorMutation() {
      if (mutation == null)
         mutation = new HashSet<Mutation>();
      return mutation.iterator();
   }
   
   public long getMatricule() {
	return matricule;
}

public void setMatricule(long matricule) {
	this.matricule = matricule;
}

public long getCin() {
	return cin;
}

public void setCin(long cin) {
	this.cin = cin;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getDatenaissance() {
	return datenaissance;
}

public void setDatenaissance(Date datenaissance) {
	this.datenaissance = datenaissance;
}

public String getLieuNaissance() {
	return lieuNaissance;
}

public void setLieuNaissance(String lieuNaissance) {
	this.lieuNaissance = lieuNaissance;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public int getCodepostal() {
	return codepostal;
}

public void setCodepostal(int codepostal) {
	this.codepostal = codepostal;
}

public String getSexe() {
	return sexe;
}

public void setSexe(String sexe) {
	this.sexe = sexe;
}

public String getRib() {
	return rib;
}

public void setRib(String rib) {
	this.rib = rib;
}

public String getEtatCivil() {
	return etatCivil;
}

public void setEtatCivil(String etatCivil) {
	this.etatCivil = etatCivil;
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
         this.mutation = new java.util.HashSet<Mutation>();
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