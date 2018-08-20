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

import pfe.projet.dao.EtatRepository;
import pfe.projet.entities.Etat;

@RestController
@CrossOrigin("*")
public class EtatRestService {
	@Autowired
	private EtatRepository etatRepository;
	//Retourner la liste des etats
	@RequestMapping(value="/Etats", method=RequestMethod.GET)
	public List<Etat> getEnseignants(){
		return etatRepository.findAll();
	}
	@RequestMapping(value="/chercherEtat", method=RequestMethod.GET)
	public Page<Etat>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return etatRepository.chercher(""+mc+"%",new PageRequest(page,size));
	}
	//Retourner un seul etat
	@RequestMapping(value="/Etat/{idEtat}", method=RequestMethod.GET)
	public Etat getEtat(@PathVariable int idEtat){
	return etatRepository.findOne(idEtat);
	}
	//Ajouter un etat
	@RequestMapping(value="/AjouterEtat", method=RequestMethod.POST)
	public Etat save(@RequestBody Etat e){
	return etatRepository.save(e);
	}
	//Supprimer un etat
	@RequestMapping(value="/SupprimerEtat/{idEtat}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int idEtat){
		etatRepository.delete(idEtat);
		return true;
	}
	//mettre à jour un Etat
	@RequestMapping(value="/ModifierEtat/{idEtat}", method=RequestMethod.PUT)
	public Etat save(@PathVariable  int idEtat,@RequestBody Etat e){
	    e.setIdEtat(idEtat);
		return etatRepository.save(e);
	}
	

}
