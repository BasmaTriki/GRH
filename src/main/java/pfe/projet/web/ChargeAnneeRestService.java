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
	@RequestMapping(value="/chercherChargeAnnee", method=RequestMethod.GET)
	public Page<ChargeAnnee>chercher(
			@RequestParam(name="mc",defaultValue="0")int anneD,
			@RequestParam(name="mp",defaultValue="0")int anneF,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return chargeAnneeRepository.chercher(anneD,anneF,new PageRequest(page,size));
	}
	//Retourner une seule ChargeAnnee
	@RequestMapping(value="/chargeAnnee/{idChargeAnn}", method=RequestMethod.GET)
	public ChargeAnnee getOneChargeAnnee(@PathVariable long idChargeAnn){
	return chargeAnneeRepository.findOne(idChargeAnn);
	}
	//Ajouter une ChargeAnnee
	@RequestMapping(value="/AjouterChargeAnnee", method=RequestMethod.POST)
	public ChargeAnnee save(@RequestBody ChargeAnnee au){
	return chargeAnneeRepository.save(au);
	}
	//Supprimer une ChargeAnnee
	@RequestMapping(value="/SupprimerChargeAnnee/{idChargeAnn}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long idChargeAnn){
		chargeAnneeRepository.delete(idChargeAnn);
		return true;
	}
	//mettre à jour une ChargeAnnee
	@RequestMapping(value="/ModifierChargeAnnee/{idChargeAnn}", method=RequestMethod.PUT)
	public ChargeAnnee save(@PathVariable  long idChargeAnn,@RequestBody ChargeAnnee au){
	    au.setIdChargeAnn(idChargeAnn);
		return chargeAnneeRepository.save(au);
	}

}
