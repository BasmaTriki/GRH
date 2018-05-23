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

import pfe.projet.dao.EnseignantFonctionnaireEtatRepository;
import pfe.projet.entities.EnseignantFonctionnaireEtat;

@RestController
@CrossOrigin("*")
public class EnseignantFonctionnaireEtatRestService {
	@Autowired
	private EnseignantFonctionnaireEtatRepository enseignantFonctionnaireEtatRepository;
	//Retourner la liste des enseignants FonctionnaireEtats
	@RequestMapping(value="/EnseignantsFonctionnaireEtat", method=RequestMethod.GET)
	public List<EnseignantFonctionnaireEtat> getEnseignants(){
		return enseignantFonctionnaireEtatRepository.findAll();
	}
	@RequestMapping(value="/chercherEnseignantFonctionnaireEtat", method=RequestMethod.GET)
	public Page<EnseignantFonctionnaireEtat>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return enseignantFonctionnaireEtatRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}

	//Retourner un seul enseignant FonctionnaireEtat
	@RequestMapping(value="/EnseignantFonctionnaireEtat/{id}", method=RequestMethod.GET)
	public EnseignantFonctionnaireEtat getEnseignant(@PathVariable long matricule){
	return enseignantFonctionnaireEtatRepository.findOne(matricule);
	}
	//Ajouter un enseignant FonctionnaireEtat
	@RequestMapping(value="/AjouterEnseignantFonctionnaireEtat", method=RequestMethod.POST)
	public EnseignantFonctionnaireEtat save(@RequestBody EnseignantFonctionnaireEtat p){
	return enseignantFonctionnaireEtatRepository.save(p);
	}
	//Supprimer un enseignant FonctionnaireEtat
	@RequestMapping(value="/EnseignantFonctionnaireEtat/{matricule}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long matricule){
		enseignantFonctionnaireEtatRepository.delete(matricule);
		return true;
	}
	//mettre à jour un Enseignant FonctionnaireEtat
	@RequestMapping(value="/EnseignantFonctionnaireEtat/{matricule}", method=RequestMethod.PUT)
	public EnseignantFonctionnaireEtat save(@PathVariable  long matricule,@RequestBody EnseignantFonctionnaireEtat e){
	    e.setMatricule(matricule);
		return enseignantFonctionnaireEtatRepository.save(e);
	}
}
