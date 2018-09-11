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

import pfe.projet.dao.EnseignantLibreRepository;
import pfe.projet.entities.EnseignantLibre;

@RestController
@CrossOrigin("*")
public class EnsignantLibreRestService {
	@Autowired
	private EnseignantLibreRepository enseignantLibreRepository;
	//Retourner la liste des enseignants Libres
	@RequestMapping(value="/EnseignantsLibre", method=RequestMethod.GET)
	public List<EnseignantLibre> getEnseignants(){
		return enseignantLibreRepository.findAll();
	}
	@RequestMapping(value="/chercherEnseignantLibre", method=RequestMethod.GET)
	public Page<EnseignantLibre>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return enseignantLibreRepository.chercher(""+mc+"%",new PageRequest(page,size));
	}

	//Retourner un seul enseignant Libre
	@RequestMapping(value="/EnseignantLibre/{idPers}", method=RequestMethod.GET)
	public EnseignantLibre getEnseignant(@PathVariable long idPers){
	return enseignantLibreRepository.findOne(idPers);
	}
	//Ajouter un enseignant Libre
	@RequestMapping(value="/AjouterEnseignantLibre", method=RequestMethod.POST)
	public EnseignantLibre save(@RequestBody EnseignantLibre p){
	return enseignantLibreRepository.save(p);
	}
	//Supprimer un enseignant Libre
	@RequestMapping(value="/SupprimerEnseignantLibre/{idPers}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long idPers){
		enseignantLibreRepository.delete(idPers);
		return true;
	}
	//mettre à jour un Enseignant Libre
	@RequestMapping(value="/ModifierEnseignantLibre/{idPers}", method=RequestMethod.PUT)
	public EnseignantLibre save(@PathVariable  long idPers,@RequestBody EnseignantLibre e){
	    e.setIdPers(idPers);
		return enseignantLibreRepository.save(e);
	}
}
