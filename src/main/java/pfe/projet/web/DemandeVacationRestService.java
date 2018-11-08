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

import pfe.projet.dao.DemandeVacationRepository;
import pfe.projet.entities.DemandeVacation;

@RestController
@CrossOrigin("*")
public class DemandeVacationRestService {

	@Autowired
	private DemandeVacationRepository demandeVacationRepository;
	@Autowired
	private EmailRestServices emailServices;
	//Retourner la liste des demandeVacations
	@RequestMapping(value="/demandeVacations", method=RequestMethod.GET)
	public List<DemandeVacation> getdemandeVacation(){
		return demandeVacationRepository.findAll();
	}
	@RequestMapping(value="/chercherdemandeVacation", method=RequestMethod.GET)
	public Page<DemandeVacation>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return demandeVacationRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}
	@RequestMapping(value="/chercherEtatdemande", method=RequestMethod.GET)
	public Page<DemandeVacation>chercherEtat(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return demandeVacationRepository.chercherEtat(""+mc+"%",new PageRequest(page,size));
	}
	//Retourner un seul demandeVacation
	@RequestMapping(value="/demandeVacation/{idDemande}", method=RequestMethod.GET)
	public DemandeVacation getOnedemandeVacation(@PathVariable long idDemande){
	return demandeVacationRepository.findOne(idDemande);
	}
	//Ajouter un demandeVacation
	@RequestMapping(value="/AjouterdemandeVacation", method=RequestMethod.POST)
	public DemandeVacation save(@RequestBody DemandeVacation d){
	return demandeVacationRepository.save(d);
	}
	//Supprimer un demandeVacation
	@RequestMapping(value="/SupprimerdemandeVacation/{idDemande}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long idDemande){
		demandeVacationRepository.delete(idDemande);
		return true;
	}
	//mettre à jour un demande
	@RequestMapping(value="/ModifierdemandeVacation/{idDemande}", method=RequestMethod.PUT)
	public DemandeVacation save(@PathVariable  long idDemande,@RequestBody DemandeVacation d){
	    d.setIdDemande(idDemande);
	    if(d.getEtatdemande().equals("accepter"))
	    {
	    	emailServices.SendEmailAccepter(d);
	    }
	    if(d.getEtatdemande().equals("refuser"))
	    {
	    	emailServices.SendEmailRefuser(d);
	    }
		return demandeVacationRepository.save(d);
	}
	


}
