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

import pfe.projet.dao.EnseignantContractuelRepository;
import pfe.projet.entities.EnseignantContractuel;

@RestController
@CrossOrigin("*")
public class EnseignantContractuelRestService {
	@Autowired
	private EnseignantContractuelRepository enseignantContractuelRepository;
	//Retourner la liste des enseignants Contractuel
	@RequestMapping(value="/EnseignantContractuels", method=RequestMethod.GET)
	public List<EnseignantContractuel> getEnseignants(){
		return enseignantContractuelRepository.findAll();
	}
	@RequestMapping(value="/chercherEnseignantContractuel", method=RequestMethod.GET)
	public Page<EnseignantContractuel>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return enseignantContractuelRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}

	//Retourner un seul enseignant Contractuel
	@RequestMapping(value="/EnseignantContractuel/{idPers}", method=RequestMethod.GET)
	public EnseignantContractuel getEnseignant(@PathVariable long idPers){
	return enseignantContractuelRepository.findOne(idPers);
	}
	//Ajouter un enseignant Contractuel
	@RequestMapping(value="/AjouterEnseignantContractuel", method=RequestMethod.POST)
	public EnseignantContractuel save(@RequestBody EnseignantContractuel e){
	return enseignantContractuelRepository.save(e);
	}
	//Supprimer un enseignant Contractuel
	@RequestMapping(value="/SupprimerEnseignantContractuel/{idPers}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long idPers){
		enseignantContractuelRepository.delete(idPers);
		return true;
	}
	//mettre à jour un Enseignant Contractuel
	@RequestMapping(value="/ModifierEnseignantContractuel/{idPers}", method=RequestMethod.PUT)
	public EnseignantContractuel save(@PathVariable  long idPers,@RequestBody EnseignantContractuel e){
	    e.setIdPers(idPers);
		return enseignantContractuelRepository.save(e);
	}
	

}
