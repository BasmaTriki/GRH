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
import pfe.projet.dao.ContratRepository;
import pfe.projet.entities.Contrat;
@RestController
@CrossOrigin("*")
public class ContratRestService {
	
		@Autowired
		private ContratRepository contratRepository;
		//Retourner la liste des Contrats
		@RequestMapping(value="/Contrats", method=RequestMethod.GET)
		public List<Contrat> getContrat(){
			return contratRepository.findAll();
		}
		@RequestMapping(value="/chercherContrat", method=RequestMethod.GET)
		public Page<Contrat>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return contratRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		}
		@RequestMapping(value="/chercherContratPersonnel", method=RequestMethod.GET)
		public List<Contrat>chercherContrat(
				@RequestParam(name="mc",defaultValue="0")long idPers){
			return contratRepository.chercherContrat(idPers);
		}
		//Retourner un seul Contrat
		@RequestMapping(value="/Contrat/{idContrat}", method=RequestMethod.GET)
		public Contrat getOneContrat(@PathVariable long idContrat){
		return contratRepository.findOne(idContrat);
		}
		//Ajouter un Contrat
		@RequestMapping(value="/AjouterContrat", method=RequestMethod.POST)
		public Contrat save(@RequestBody Contrat c){
		return contratRepository.save(c);
		}
		//Supprimer un Contrat
		@RequestMapping(value="/SupprimerContrat/{idContrat}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long idContrat){
			contratRepository.delete(idContrat);
			return true;
		}
		//mettre à jour un Contrat
		@RequestMapping(value="/ModifierContrat/{idContrat}", method=RequestMethod.PUT)
		public Contrat save(@PathVariable  long idContrat,@RequestBody Contrat c){
		    c.setIdContrat(idContrat);
			return contratRepository.save(c);
		}
		

	}
