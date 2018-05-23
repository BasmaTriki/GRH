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
import pfe.projet.dao.PeriodeRepository;
import pfe.projet.entities.Periode;

@RestController
@CrossOrigin("*")
public class PeriodeRestService {
	@Autowired
	private PeriodeRepository periodeRepository;
	//Retourner la liste des Periodes
	@RequestMapping(value="/Periodes", method=RequestMethod.GET)
	public List<Periode> getPeriode(){
		return periodeRepository.findAll();
	}
	@RequestMapping(value="/chercherPeriode", method=RequestMethod.GET)
	public Page<Periode>chercher(
			@RequestParam(required = false)Date mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return periodeRepository.chercher(mc,new PageRequest(page,size));
	}
	//Retourner une seule Periode
	@RequestMapping(value="/Periode/{id_Periode}", method=RequestMethod.GET)
	public Periode getPeriode(@PathVariable long id_Periode){
	return periodeRepository.findOne(id_Periode);
	}
	//Ajouter une Periode
	@RequestMapping(value="/AjouterPeriode", method=RequestMethod.POST)
	public Periode save(@RequestBody Periode p){
	return periodeRepository.save(p);
	}
	//Supprimer une Periode
	@RequestMapping(value="/SupprimerPeriode/{id_periode}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long id_periode){
		periodeRepository.delete(id_periode);
		return true;
	}
	//mettre à jour une Periode
	@RequestMapping(value="/ModifierPeriode/{id_periode}", method=RequestMethod.PUT)
	public Periode save(@PathVariable  long id_periode,@RequestBody Periode p){
	    p.setId_periode(id_periode);
		return periodeRepository.save(p);
	}
	


}
