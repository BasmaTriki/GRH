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
import pfe.projet.dao.AdministratifRepository;
import pfe.projet.entities.Administratif;
@RestController
@CrossOrigin("*")
public class AdministratifRestService {
	
		@Autowired
		private AdministratifRepository administratifRepository;
		//Retourner la list des Personnes
		@RequestMapping(value="/Administratifs", method=RequestMethod.GET)
		public List<Administratif> getEnseignants(){
			return administratifRepository.findAll();
		}
		@RequestMapping(value="/chercherAdministratif", method=RequestMethod.GET)
		public Page<Administratif>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return administratifRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		}
		/*@RequestMapping(value="/chercheUser", method=RequestMethod.GET)
		public Page<User>chercherUser(
				@RequestParam(name="mc",defaultValue="") String mc,
				@RequestParam(name="mp",defaultValue="") String mp){
			return userRepository.chercheUser("%"+mc+"%","%"+mp+"%");
		}*/
		//Retourner une seul personne
		@RequestMapping(value="/Administratif/{matricule}", method=RequestMethod.GET)
		public Administratif getEnseignant(@PathVariable long matricule){
		return administratifRepository.findOne(matricule);
		}
		//Ajouter une personnel
		@RequestMapping(value="/AjouterAdministratif", method=RequestMethod.POST)
		public Administratif save(@RequestBody Administratif a){
		return administratifRepository.save(a);
		}
		//Supprimer une Personnel
		@RequestMapping(value="/SupprimerAdministratif/{matricule}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long matricule){
			administratifRepository.delete(matricule);
			return true;
		}
		//mettre à jour une Personnel
		@RequestMapping(value="/ModifierAdministratif/{matricule}", method=RequestMethod.PUT)
		public Administratif save(@PathVariable  long matricule,@RequestBody Administratif a){
		    a.setMatricule(matricule);
			return administratifRepository.save(a);
		}
		

	}
