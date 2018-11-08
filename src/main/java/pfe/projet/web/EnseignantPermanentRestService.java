package pfe.projet.web;
import java.sql.Array;
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
import pfe.projet.entities.Departement;
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
		@RequestMapping(value="/chercherEnseignantSansCompte", method=RequestMethod.GET)
		public List<EnseignantPermanent>chercherCompte(){
			return enseignantRepository.chercherEnsgSansCompte();
		}
		@RequestMapping(value="/NomberDesEnseignant", method=RequestMethod.GET)
		public List<Long>NomberEnseignant(){
			return enseignantRepository.NombreEnseignant();
		}
		@RequestMapping(value="/ListeDepartement", method=RequestMethod.GET)
		public List<String>ListeDepartement(){
			return enseignantRepository.ListeDepartement();
		}
		@RequestMapping(value="/ListeDepartementFr", method=RequestMethod.GET)
		public List<String>ListeDepartementFr(){
			return enseignantRepository.ListeDepartementFr();
		}
		//Retourner une seul personne
		@RequestMapping(value="/EnseignantPermanent/{idPers}", method=RequestMethod.GET)
		public EnseignantPermanent getEnseignant(@PathVariable long idPers){
		return enseignantRepository.findOne(idPers);
		}
		//Ajouter une personnel
		@RequestMapping(value="/AjouterEnseignantPermanent", method=RequestMethod.POST)
		public EnseignantPermanent save(@RequestBody EnseignantPermanent e){
		return enseignantRepository.save(e);
		}
		//Supprimer une Personnel
		@RequestMapping(value="/SupprimerEnseignantPermanent/{idPers}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long idPers){
			enseignantRepository.delete(idPers);
			return true;
		}
		//mettre à jour une Personnel
		@RequestMapping(value="/ModifierEnseignantPermanent/{idPers}", method=RequestMethod.PUT)
		public EnseignantPermanent save(@PathVariable  long idPers,@RequestBody EnseignantPermanent e){
		    e.setIdPers(idPers);
			return enseignantRepository.save(e);
		}
		

	}
