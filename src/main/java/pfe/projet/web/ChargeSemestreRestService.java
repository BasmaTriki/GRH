package pfe.projet.web;

import java.util.Date;
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

import pfe.projet.dao.ChargeSemestreRepository;
import pfe.projet.entities.ChargeSem;

@RestController
@CrossOrigin("*")
public class ChargeSemestreRestService {
	@Autowired
	private ChargeSemestreRepository chargeSemestreRepository;
	//Retourner la liste des chargesSemestre
	@RequestMapping(value="/ChargeSemestres", method=RequestMethod.GET)
	public List<ChargeSem> getconges(){
		return chargeSemestreRepository.findAll();
	}
	@RequestMapping(value="/chercherChargeSemestre", method=RequestMethod.GET)
	public Page<ChargeSem>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return chargeSemestreRepository.chercher(""+mc,new PageRequest(page,size));
	}
	@RequestMapping(value="/chercherChargeEnseignant", method=RequestMethod.GET)
	public List<ChargeSem> chercherCharge(
			@RequestParam(name="eng",defaultValue="")long idPers){
		return chargeSemestreRepository.chercherSemesPers(idPers);
	}
	//Retourner un seul chargSemestre
	@RequestMapping(value="/ChargeSemestre/{idChargeS}", method=RequestMethod.GET)
	public ChargeSem getOneChargeSemestre(@PathVariable long idChargeS){
	return chargeSemestreRepository.findOne(idChargeS);
	}
	//Ajouter un chargeSemestre
	@RequestMapping(value="/AjouterChargeSemestre", method=RequestMethod.POST)
	public ChargeSem save(@RequestBody ChargeSem cs){
	return chargeSemestreRepository.save(cs);
	}
	//Supprimer un chargeSemestre
	@RequestMapping(value="/SupprimerChargeSemestre/{idChargeS}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long idChargeS){
		chargeSemestreRepository.delete(idChargeS);
		return true;
	}
	//mettre à jour un chargeSemestre
	@RequestMapping(value="/ModifierChargeSemestre/{idChargeS}", method=RequestMethod.PUT)
	public ChargeSem save(@PathVariable  long idChargeS,@RequestBody ChargeSem cs){
	    cs.setIdChargeS(idChargeS);
		return chargeSemestreRepository.save(cs);
	}

}
