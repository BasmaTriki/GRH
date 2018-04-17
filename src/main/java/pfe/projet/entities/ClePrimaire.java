package pfe.projet.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ClePrimaire implements Serializable {
	private String login;
	private String motpasse;
	public String getLogin() {
		return login;
	}
	public ClePrimaire(String login, String motpasse) {
		super();
		this.login = login;
		this.motpasse = motpasse;
	}
	public ClePrimaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotpasse() {
		return motpasse;
	}
	public void setMotpasse(String motpasse) {
		this.motpasse = motpasse;
	}
	
	public int hashCode() {
		return(login+motpasse).hashCode();
	}
	public boolean equals (Object obj) {
		boolean result = false;
		if (obj == this) {
			result = true;
		}
		else {
			if(!(obj instanceof ClePrimaire)) {
				result = false;
			}
			else {
				ClePrimaire autre =(ClePrimaire) obj;
				if(!login.equals(autre.login)) {
					result = false;
				}
				else {
					if (motpasse != autre.motpasse) {
						result = false;
					}
					else {
						result = true;
					}
				}
			}
		}
		return result;
	}
}

