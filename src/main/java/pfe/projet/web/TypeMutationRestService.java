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

import pfe.projet.dao.TypeMutationRepository;
import pfe.projet.entities.TypeMutation;

@RestController
@CrossOrigin("*")
public class TypeMutationRestService {

	@Autowired
	private TypeMutationRepository typeMutationRepository;
	//Retourner la liste des TypeMutations
	@RequestMapping(value="/TypeMutations", method=RequestMethod.GET)
	public List<TypeMutation> getTypeMutations(){
		return typeMutationRepository.findAll();
	}
	@RequestMapping(value="/chercherTypeMutation", method=RequestMethod.GET)
	public Page<TypeMutation>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return typeMutationRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}
	
	//Retourner un seul TypeMutation
	@RequestMapping(value="/TypeMutation/{code}", method=RequestMethod.GET)
	public TypeMutation getTypeMutation(@PathVariable long code){
	return typeMutationRepository.findOne(code);
	}
	//Ajouter TypeMutation
	@RequestMapping(value="/AjouterTypeMutation", method=RequestMethod.POST)
	public TypeMutation save(@RequestBody TypeMutation tm){
	return typeMutationRepository.save(tm);
	}
	//Supprimer une TypeMutation
	@RequestMapping(value="/SupprimerTypeMutation/{code}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long code){
		typeMutationRepository.delete(code);
		return true;
	}
	//mettre à jour une TypeMutation
	@RequestMapping(value="/ModifierTypeMutation/{code}", method=RequestMethod.PUT)
	public TypeMutation save(@PathVariable  long code,@RequestBody TypeMutation tm){
	    tm.setCode(code);
		return typeMutationRepository.save(tm);
	}

}
