package pfe.projet.web;

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

import pfe.projet.dao.EnfantRepository;
import pfe.projet.entities.Enfant;

@RestController
@CrossOrigin("*")
public class EnfantRestService {
	@Autowired
	private EnfantRepository enfantRepository;
	//Retourner la liste des enfants
	@RequestMapping(value="/Enfants", method=RequestMethod.GET)
	public List<Enfant> getEnseignants(){
		return enfantRepository.findAll();
	}
	@RequestMapping(value="/chercherEnfant", method=RequestMethod.GET)
	public Page<Enfant>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return enfantRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}

	//Retourner un seul enfant
	@RequestMapping(value="/Enfant/{num}", method=RequestMethod.GET)
	public Enfant getEnfant(@PathVariable long num){
	return enfantRepository.findOne(num);
	}
	//Ajouter un enfant
	@RequestMapping(value="/AjouterEnfant", method=RequestMethod.POST)
	public Enfant save(@RequestBody Enfant e){
	return enfantRepository.save(e);
	}
	//Supprimer un enfant
	@RequestMapping(value="/SupprimerEnfant/{num}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long num){
		enfantRepository.delete(num);
		return true;
	}
	//mettre à jour un Enfant
	@RequestMapping(value="/ModifierEnfant/{num}", method=RequestMethod.PUT)
	public Enfant save(@PathVariable  long num,@RequestBody Enfant e){
	    e.setNum(num);
		return enfantRepository.save(e);
	}
	

}
