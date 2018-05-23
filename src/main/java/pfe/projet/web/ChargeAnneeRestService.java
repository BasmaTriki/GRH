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
import pfe.projet.dao.ChargeAnneeRepository;
import pfe.projet.entities.ChargeAnnee;

@RestController
@CrossOrigin("*")
public class ChargeAnneeRestService {
	@Autowired
	private ChargeAnneeRepository chargeAnneeRepository;
	//Retourner la liste des ChargeAnnee
	@RequestMapping(value="/chargeAnnees", method=RequestMethod.GET)
	public List<ChargeAnnee> getChargeAnnee(){
		return chargeAnneeRepository.findAll();
	}
	/*@RequestMapping(value="/chercherChargeAnnee", method=RequestMethod.GET)
	public Page<ChargeAnnee>chercher(
			@RequestParam(required=false)Date date,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return chargeAnneeRepository.chercher(date,new PageRequest(page,size));
	}*/
	//Retourner une seule ChargeAnnee
	@RequestMapping(value="/chargeAnnee/{id}", method=RequestMethod.GET)
	public ChargeAnnee getOneChargeAnnee(@PathVariable long id){
	return chargeAnneeRepository.findOne(id);
	}
	//Ajouter une ChargeAnnee
	@RequestMapping(value="/AjouterChargeAnnee", method=RequestMethod.POST)
	public ChargeAnnee save(@RequestBody ChargeAnnee au){
	return chargeAnneeRepository.save(au);
	}
	//Supprimer une ChargeAnnee
	@RequestMapping(value="/SupprimerChargeAnnee/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long id){
		chargeAnneeRepository.delete(id);
		return true;
	}
	//mettre à jour une ChargeAnnee
	@RequestMapping(value="/ModifierChargeAnnee/{id}", method=RequestMethod.PUT)
	public ChargeAnnee save(@PathVariable  long id,@RequestBody ChargeAnnee au){
	    au.setId(id);
		return chargeAnneeRepository.save(au);
	}

}
