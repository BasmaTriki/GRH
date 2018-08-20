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

import pfe.projet.entities.PosteAdministrative;
import pfe.projet.dao.PosteAdministrativeRepository;

@RestController
@CrossOrigin("*")
public class PosteAdministrativeRestService {
	@Autowired
	private PosteAdministrativeRepository posteAdministrativeRepository;
	//Retourner la liste des PosteAdministratives
	@RequestMapping(value="/PosteAdministratives", method=RequestMethod.GET)
	public List<PosteAdministrative> getPosteAdministrative(){
		return posteAdministrativeRepository.findAll();
	}
	@RequestMapping(value="/chercherPosteAdministrative", method=RequestMethod.GET)
	public Page<PosteAdministrative>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return posteAdministrativeRepository.chercher(mc+"%",new PageRequest(page,size));
	}
	//Retourner une seule PosteAdministrative
	@RequestMapping(value="/PosteAdministrative/{id_PosteAdministrative}", method=RequestMethod.GET)
	public PosteAdministrative getPosteAdministrative(@PathVariable long id_PosteAdministrative){
	return posteAdministrativeRepository.findOne(id_PosteAdministrative);
	}
	//Ajouter une PosteAdministrative
	@RequestMapping(value="/AjouterPosteAdministrative", method=RequestMethod.POST)
	public PosteAdministrative save(@RequestBody PosteAdministrative p){
	return posteAdministrativeRepository.save(p);
	}
	//Supprimer une PosteAdministrative
	@RequestMapping(value="/SupprimerPosteAdministrative/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long id){
		posteAdministrativeRepository.delete(id);
		return true;
	}
	//mettre à jour une PosteAdministrative
	@RequestMapping(value="/ModifierPosteAdministrative/{id}", method=RequestMethod.PUT)
	public PosteAdministrative save(@PathVariable  long id,@RequestBody PosteAdministrative p){
	    p.setId(id);
		return posteAdministrativeRepository.save(p);
	}
	
}
