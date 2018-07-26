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

import pfe.projet.dao.AnneeUniversitaireRepository;
import pfe.projet.entities.AnneeUniversitaire;

@RestController
@CrossOrigin("*")
public class AnneeUniversitaireRestService {
	@Autowired
	private AnneeUniversitaireRepository anneeUniversitaireRepository;
	//Retourner la liste des AnneeUniversitaire
	@RequestMapping(value="/anneeUniversitaires", method=RequestMethod.GET)
	public List<AnneeUniversitaire> getconges(){
		return anneeUniversitaireRepository.findAll();
	}
	@RequestMapping(value="/chercherAnneeUniversitaire", method=RequestMethod.GET)
	public Page<AnneeUniversitaire>chercher(
			@RequestParam(name="mc",defaultValue="0")int mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return anneeUniversitaireRepository.chercher(mc,new PageRequest(page,size));
	}
	//Retourner une seule AnneeUniversitaire
	@RequestMapping(value="/anneeUniversitaire/{idAnnee}", method=RequestMethod.GET)
	public AnneeUniversitaire getOneAnneeUniversitaire(@PathVariable long idAnnee){
	return anneeUniversitaireRepository.findOne(idAnnee);
	}
	//Ajouter une AnneeUniversitaire
	@RequestMapping(value="/AjouterAnneeUniversitaire", method=RequestMethod.POST)
	public AnneeUniversitaire save(@RequestBody AnneeUniversitaire au){
	return anneeUniversitaireRepository.save(au);
	}
	//Supprimer une AnneeUniversitaire
	@RequestMapping(value="/SupprimerAnneeUniversitaire/{idAnnee}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long idAnnee){
		anneeUniversitaireRepository.delete(idAnnee);
		return true;
	}
	//mettre à jour une AnneeUniversitaire
	@RequestMapping(value="/ModifierAnneeUniversitaire/{idAnnee}", method=RequestMethod.PUT)
	public AnneeUniversitaire save(@PathVariable  long idAnnee,@RequestBody AnneeUniversitaire au){
	    au.setIdAnnee(idAnnee);
		return anneeUniversitaireRepository.save(au);
	}

}
