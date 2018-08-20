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
import pfe.projet.dao.DiplomeRepository;
import pfe.projet.entities.Diplome;
@RestController
@CrossOrigin("*")
public class DiplomeRestService {
	
		@Autowired
		private DiplomeRepository diplomeRepository;
		//Retourner la liste des diplomes
		@RequestMapping(value="/Diplomes", method=RequestMethod.GET)
		public List<Diplome> getDiplome(){
			return diplomeRepository.findAll();
		}
		@RequestMapping(value="/chercherDiplome", method=RequestMethod.GET)
		public Page<Diplome>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return diplomeRepository.chercher(""+mc+"%",new PageRequest(page,size));
		}
		//Retourner un seul diplome
		@RequestMapping(value="/Diplome/{idDip}", method=RequestMethod.GET)
		public Diplome getDiplome(@PathVariable long idDip){
		return diplomeRepository.findOne(idDip);
		}
		//Ajouter un diplome
		@RequestMapping(value="/AjouterDiplome", method=RequestMethod.POST)
		public Diplome save(@RequestBody Diplome d){
		return diplomeRepository.save(d);
		}
		//Supprimer un diplome
		@RequestMapping(value="/SupprimerDiplome/{id}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long id){
			diplomeRepository.delete(id);
			return true;
		}
		//mettre à jour un diplome
		@RequestMapping(value="/ModifierDiplome/{id}", method=RequestMethod.PUT)
		public Diplome save(@PathVariable  long id,@RequestBody Diplome d){
		    d.setIdDip(id);
			return diplomeRepository.save(d);
		}
		

	}
