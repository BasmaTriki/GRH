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
import pfe.projet.dao.OrganismeAccueilRepository;
import pfe.projet.entities.OrganismeAccueil;

@RestController
@CrossOrigin("*")
public class OrganismeAccueilRestService {
	
		@Autowired
		private OrganismeAccueilRepository organismeAccueilRepository;
		//Retourner la liste des OrganismeAccueils
		@RequestMapping(value="/OrganismeAccueils", method=RequestMethod.GET)
		public List<OrganismeAccueil> getOrganismeAccueil(){
			return organismeAccueilRepository.findAll();
		}
		@RequestMapping(value="/chercherOrganismeAccueil", method=RequestMethod.GET)
		public Page<OrganismeAccueil>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return organismeAccueilRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		}
		//Retourner un seul OrganismeAccueil
		@RequestMapping(value="/OrganismeAccueil/{idOrg}", method=RequestMethod.GET)
		public OrganismeAccueil getOrganismeAccueil(@PathVariable long idOrg){
		return organismeAccueilRepository.findOne(idOrg);
		}
		//Ajouter un OrganismeAccueil
		@RequestMapping(value="/AjouterOrganismeAccueil", method=RequestMethod.POST)
		public OrganismeAccueil save(@RequestBody OrganismeAccueil o){
		return organismeAccueilRepository.save(o);
		}
		//Supprimer un OrganismeAccueil
		@RequestMapping(value="/SupprimerOrganismeAccueil/{idOrg}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long idOrg){
			organismeAccueilRepository.delete(idOrg);
			return true;
		}
		//mettre à jour un OrganismeAccueil
		@RequestMapping(value="/ModifierOrganismeAccueil/{idOrg}", method=RequestMethod.PUT)
		public OrganismeAccueil save(@PathVariable  long idOrg,@RequestBody OrganismeAccueil o){
		    o.setIdOrg(idOrg);
			return organismeAccueilRepository.save(o);
		}
		

	}
