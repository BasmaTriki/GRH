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
import pfe.projet.dao.EnseignantPermanentRepository;
import pfe.projet.entities.Enseignant;
import pfe.projet.entities.EnseignantPermanent;
@RestController
@CrossOrigin("*")
public class EnseignantPermanentRestService {
	
		@Autowired
		private EnseignantPermanentRepository enseignantRepository;
		//Retourner la list des Personnes
		@RequestMapping(value="/EnseignantsPermanents", method=RequestMethod.GET)
		public List<EnseignantPermanent> getEnseignants(){
			return enseignantRepository.findAll();
		}
		@RequestMapping(value="/chercherEnseignantPermanent", method=RequestMethod.GET)
		public Page<EnseignantPermanent>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return enseignantRepository.chercher(""+mc+"%",new PageRequest(page,size));
		}
		@RequestMapping(value="/chercherEnseignantPrenom", method=RequestMethod.GET)
		public Page<EnseignantPermanent>chercherPrenom(
				@RequestParam(name="mp",defaultValue="")String mp,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return enseignantRepository.chercherPrenom("%"+mp+"%",new PageRequest(page,size));
		}
		@RequestMapping(value="/chercherEnseignantDepartement", method=RequestMethod.GET)
		public Page<EnseignantPermanent>chercherDepartement(
				@RequestParam(name="mc",defaultValue="0")long mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return enseignantRepository.chercherEnsgDepartement(mc,new PageRequest(page,size));
		}
		//Retourner une seul personne
		@RequestMapping(value="/EnseignantPermanent/{matricule}", method=RequestMethod.GET)
		public EnseignantPermanent getEnseignant(@PathVariable long matricule){
		return enseignantRepository.findOne(matricule);
		}
		//Ajouter une personnel
		@RequestMapping(value="/AjouterEnseignantPermanent", method=RequestMethod.POST)
		public EnseignantPermanent save(@RequestBody EnseignantPermanent e){
		return enseignantRepository.save(e);
		}
		//Supprimer une Personnel
		@RequestMapping(value="/SupprimerEnseignantPermanent/{matricule}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long matricule){
			enseignantRepository.delete(matricule);
			return true;
		}
		//mettre à jour une Personnel
		@RequestMapping(value="/ModifierEnseignantPermanent/{matricule}", method=RequestMethod.PUT)
		public EnseignantPermanent save(@PathVariable  long matricule,@RequestBody EnseignantPermanent e){
		    e.setMatricule(matricule);
			return enseignantRepository.save(e);
		}
		

	}
