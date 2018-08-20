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
import pfe.projet.dao.OrganismeRepository;
import pfe.projet.entities.Organisme;

@RestController
@CrossOrigin("*")
public class OrganismeRestService {
	
		@Autowired
		private OrganismeRepository organismeRepository;
		//Retourner la liste des Organismes
		@RequestMapping(value="/Organismes", method=RequestMethod.GET)
		public List<Organisme> getOrganisme(){
			return organismeRepository.findAll();
		}
		@RequestMapping(value="/chercherOrganisme", method=RequestMethod.GET)
		public Page<Organisme>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return organismeRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		}
		//Retourner un seul Organisme
		@RequestMapping(value="/Organisme/{idOrg}", method=RequestMethod.GET)
		public Organisme getOrganisme(@PathVariable long idOrg){
		return organismeRepository.findOne(idOrg);
		}
		//Ajouter un Organisme
		@RequestMapping(value="/AjouterOrganisme", method=RequestMethod.POST)
		public Organisme save(@RequestBody Organisme o){
		return organismeRepository.save(o);
		}
		//Supprimer un Organisme
		@RequestMapping(value="/SupprimerOrganisme/{idOrg}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long idOrg){
			organismeRepository.delete(idOrg);
			return true;
		}
		//mettre à jour un Organisme
		@RequestMapping(value="/ModifierOrganisme/{idOrg}", method=RequestMethod.PUT)
		public Organisme save(@PathVariable  long idOrg,@RequestBody Organisme o){
		    o.setIdOrg(idOrg);
			return organismeRepository.save(o);
		}
		

	}
