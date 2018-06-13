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

import pfe.projet.dao.CongesRepository;
import pfe.projet.entities.Conge;

@RestController
@CrossOrigin("*")
public class CongesRestService {
	@Autowired
	private CongesRepository congeRepository;
	//Retourner la liste des congés
	@RequestMapping(value="/conges", method=RequestMethod.GET)
	public List<Conge> getConge(){
		return congeRepository.findAll();
	}
	@RequestMapping(value="/chercherConges", method=RequestMethod.GET)
	public Page<Conge>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return congeRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}
	@RequestMapping(value="/chercherCongesP", method=RequestMethod.GET)
	public Page<Conge>chercherPerso(
			@RequestParam(name="mc",defaultValue="0")long mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return congeRepository.chercherPerso(mc,new PageRequest(page,size));
	}
	@RequestMapping(value="/chercherNbJourParType", method=RequestMethod.GET)
	public Page<Conge>chercherNbJour(
			@RequestParam(name="mc",defaultValue="0")long mc,
			@RequestParam(name="mt",defaultValue="")String mt,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size)
	{
		return congeRepository.chercherNbJour(mc,"%"+mt+"%",new PageRequest(page,size));
	}
	//Retourner un seul congé
	@RequestMapping(value="/conge/{id}", method=RequestMethod.GET)
	public Conge getOneConge(@PathVariable long idCong){
	return congeRepository.findOne(idCong);
	}
	//Ajouter un congé
	@RequestMapping(value="/AjouterConge", method=RequestMethod.POST)
	public Conge save(@RequestBody Conge c){
	return congeRepository.save(c);
	}
	//Supprimer un congé
	@RequestMapping(value="/SupprimerConge/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long id){
		congeRepository.delete(id);
		return true;
	}
	//mettre à jour un congé
	@RequestMapping(value="/ModifierConge/{id}", method=RequestMethod.PUT)
	public Conge save(@PathVariable  long id,@RequestBody Conge c){
	    c.setIdCong(id);
		return congeRepository.save(c);
	}
}
