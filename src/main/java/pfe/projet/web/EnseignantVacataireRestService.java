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

import pfe.projet.dao.EnseignantVacataireRepository;
import pfe.projet.entities.EnseignantVacataire;

@RestController
@CrossOrigin("*")
public class EnseignantVacataireRestService {
	@Autowired
	private EnseignantVacataireRepository enseignantvacataireRepository;
	//Retourner la liste des enseignants Vacataires
	@RequestMapping(value="/EnseignantsVacataire", method=RequestMethod.GET)
	public List<EnseignantVacataire> getEnseignants(){
		return enseignantvacataireRepository.findAll();
	}
	@RequestMapping(value="/chercherEnseignantVacataire", method=RequestMethod.GET)
	public Page<EnseignantVacataire>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return enseignantvacataireRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}

	//Retourner un seul enseignant Vacataire
	@RequestMapping(value="/EnseignantVacataire/{id}", method=RequestMethod.GET)
	public EnseignantVacataire getEnseignant(@PathVariable long matricule){
	return enseignantvacataireRepository.findOne(matricule);
	}
	//Ajouter un enseignant Vacataire
	@RequestMapping(value="/AjouterEnseignantVacataire", method=RequestMethod.POST)
	public EnseignantVacataire save(@RequestBody EnseignantVacataire p){
	return enseignantvacataireRepository.save(p);
	}
	//Supprimer un enseignant Vacataire
	@RequestMapping(value="/EnseignantVacataire/{matricule}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long matricule){
		enseignantvacataireRepository.delete(matricule);
		return true;
	}
	//mettre à jour un Enseignant Vacataire
	@RequestMapping(value="/EnseignantVacataire/{matricule}", method=RequestMethod.PUT)
	public EnseignantVacataire save(@PathVariable  long matricule,@RequestBody EnseignantVacataire e){
	    e.setMatricule(matricule);
		return enseignantvacataireRepository.save(e);
	}
	

}
