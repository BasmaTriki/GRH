package pfe.projet.web;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pfe.projet.dao.PersonnelRepository;
import pfe.projet.entities.Personnel;
@RestController
@CrossOrigin("*")
public class PersonnelRestService {
	@Autowired
	private PersonnelRepository personnelRepository;
	//Retourner la list des Personnes
	@RequestMapping(value="/Personnels", method=RequestMethod.GET)
	public List<Personnel> getPersonnel(){
		return personnelRepository.findAll();
	}
	/*@RequestMapping(value="/chercherUsers", method=RequestMethod.GET)
	public Page<Personnel>chercher(
			@RequestParam(required = false) Date date,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return userRepository.chercher(date,new PageRequest(page,size));
	}*/
	/*@RequestMapping(value="/chercheUser", method=RequestMethod.GET)
	public Page<User>chercherUser(
			@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="mp",defaultValue="") String mp){
		return userRepository.chercheUser("%"+mc+"%","%"+mp+"%");
	}*/
	//Retourner une seul personne
	@RequestMapping(value="/Personnel/{matricule}", method=RequestMethod.GET)
	public Personnel getPersonnel(@PathVariable long matricule){
	return personnelRepository.findOne(matricule);
	}
	//Ajouter une personnel
	@RequestMapping(value="/AjouterPersonnel", method=RequestMethod.POST)
	public Personnel save(@RequestBody Personnel p){
	return personnelRepository.save(p);
	}
	//Supprimer une Personnel
	@RequestMapping(value="/SupprimerPersonnel/{matricule}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long matricule){
		personnelRepository.delete(matricule);
		return true;
	}
	//mettre à jour une Personnel
	@RequestMapping(value="/ModifierPersonnel/{matricule}", method=RequestMethod.PUT)
	public Personnel save(@PathVariable  long matricule,@RequestBody Personnel p){
	    p.setMatricule(matricule);
		return personnelRepository.save(p);
	}
	

}
