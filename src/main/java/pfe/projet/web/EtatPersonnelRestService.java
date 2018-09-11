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

import pfe.projet.dao.EtatPersonnelRepository;
import pfe.projet.entities.EtatPersonnel;

@RestController
@CrossOrigin("*")
public class EtatPersonnelRestService {
	@Autowired
	private EtatPersonnelRepository etatPersonnelRepository;
	//Retourner la liste des etatPersonnels
	@RequestMapping(value="/EtatPersonnels", method=RequestMethod.GET)
	public List<EtatPersonnel> getEnseignants(){
		return etatPersonnelRepository.findAll();
	}
	@RequestMapping(value="/chercherEtatPersonnel", method=RequestMethod.GET)
	public Page<EtatPersonnel>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return etatPersonnelRepository.chercher(""+mc+"%",new PageRequest(page,size));
	}
	@RequestMapping(value="/chercherEtatInactive", method=RequestMethod.GET)
	public EtatPersonnel chercherEtat(
			@RequestParam(name="mc",defaultValue="0")long mc,
			@RequestParam(name="mp",defaultValue="0") int idEtat){
		return etatPersonnelRepository.chercherEtatPersonnel(mc, idEtat);
	}
	//Retourner un seul etatPersonnel
	@RequestMapping(value="/EtatPersonnel/{idEtatP}", method=RequestMethod.GET)
	public EtatPersonnel getEtatPersonnel(@PathVariable int idEtatP){
	return etatPersonnelRepository.findOne(idEtatP);
	}
	//Ajouter un etatPersonnel
	@RequestMapping(value="/AjouterEtatPersonnel", method=RequestMethod.POST)
	public EtatPersonnel save(@RequestBody EtatPersonnel e){
	return etatPersonnelRepository.save(e);
	}
	//Supprimer un etatPersonnel
	@RequestMapping(value="/SupprimerEtatPersonnel/{idEtatP}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int idEtatP){
		etatPersonnelRepository.delete(idEtatP);
		return true;
	}
	//mettre à jour un EtatPersonnel
	@RequestMapping(value="/ModifierEtatPersonnel/{idEtatP}", method=RequestMethod.PUT)
	public EtatPersonnel save(@PathVariable  int idEtatP,@RequestBody EtatPersonnel e){
	    e.setIdEtatP(idEtatP);
		return etatPersonnelRepository.save(e);
	}
	

}
