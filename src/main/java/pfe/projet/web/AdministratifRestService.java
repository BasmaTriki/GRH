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
		@RequestMapping(value="/chercherAdministratifPrenom", method=RequestMethod.GET)
		public Page<Administratif>chercherPrenom(
				@RequestParam(name="mp",defaultValue="")String mp,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return administratifRepository.chercherPrenom("%"+mp+"%",new PageRequest(page,size));
		}
		//Retourner une seul personne
		@RequestMapping(value="/Administratif/{idPers}", method=RequestMethod.GET)
		public Administratif getEnseignant(@PathVariable long idPers){
		return administratifRepository.findOne(idPers);
		}
		//Ajouter une personnel
		@RequestMapping(value="/AjouterAdministratif", method=RequestMethod.POST)
		public Administratif save(@RequestBody Administratif a){
		return administratifRepository.save(a);
		}
		//Supprimer une Personnel
		@RequestMapping(value="/SupprimerAdministratif/{idPers}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long idPers){
			administratifRepository.delete(idPers);
			return true;
		}
		//mettre à jour une Personnel
		@RequestMapping(value="/ModifierAdministratif/{idPers}", method=RequestMethod.PUT)
		public Administratif save(@PathVariable  long idPers,@RequestBody Administratif a){
		    a.setIdPers(idPers);   
		    return administratifRepository.save(a);
		}
		

	}
