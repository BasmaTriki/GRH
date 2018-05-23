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

import pfe.projet.dao.MutationRepository;
import pfe.projet.entities.Mutation;

@RestController
@CrossOrigin("*")
public class MutationRestService {
	@Autowired
	private MutationRepository mutationRepository;
	//Retourner la liste des Mutations
	@RequestMapping(value="/Mutations", method=RequestMethod.GET)
	public List<Mutation> getMutation(){
		return mutationRepository.findAll();
	}
	@RequestMapping(value="/chercherMutation", method=RequestMethod.GET)
	public Page<Mutation>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return mutationRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}
	//Retourner un seul Mutation
	@RequestMapping(value="/Mutation/{idMut}", method=RequestMethod.GET)
	public Mutation getMutation(@PathVariable long idMut){
	return mutationRepository.findOne(idMut);
	}
	//Ajouter un Mutation
	@RequestMapping(value="/AjouterMutation", method=RequestMethod.POST)
	public Mutation save(@RequestBody Mutation m){
	return mutationRepository.save(m);
	}
	//Supprimer un Mutation
	@RequestMapping(value="/SupprimerMutation/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long id){
		mutationRepository.delete(id);
		return true;
	}
	//mettre à jour un Mutation
	@RequestMapping(value="/ModifierMutation/{idMut}", method=RequestMethod.PUT)
	public Mutation save(@PathVariable  long idMut,@RequestBody Mutation m){
	    m.setIdMut(idMut);
		return mutationRepository.save(m);
	}

}
