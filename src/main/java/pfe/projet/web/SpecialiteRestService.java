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
import pfe.projet.dao.SpecialiteRepository;
import pfe.projet.entities.Specialite;

@RestController
@CrossOrigin("*")
public class SpecialiteRestService {
	
		@Autowired
		private SpecialiteRepository specialiteRepository;
		//Retourner la liste des Specialites
		@RequestMapping(value="/Specialites", method=RequestMethod.GET)
		public List<Specialite> getSpecialite(){
			return specialiteRepository.findAll();
		}
		@RequestMapping(value="/chercherSpecialite", method=RequestMethod.GET)
		public Page<Specialite>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return specialiteRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		}
		//Retourner un seul Specialite
		@RequestMapping(value="/Specialite/{idSp}", method=RequestMethod.GET)
		public Specialite getSpecialite(@PathVariable long idSp){
		return specialiteRepository.findOne(idSp);
		}
		//Ajouter un Specialite
		@RequestMapping(value="/AjouterSpecialite", method=RequestMethod.POST)
		public Specialite save(@RequestBody Specialite s){
		return specialiteRepository.save(s);
		}
		//Supprimer un Specialite
		@RequestMapping(value="/SupprimerSpecialite/{idSp}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long idSp){
			specialiteRepository.delete(idSp);
			return true;
		}
		//mettre à jour un Specialite
		@RequestMapping(value="/ModifierSpecialite/{idSp}", method=RequestMethod.PUT)
		public Specialite save(@PathVariable  long idSp,@RequestBody Specialite s){
		    s.setIdSp(idSp);
			return specialiteRepository.save(s);
		}
		

	}
