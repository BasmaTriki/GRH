package pfe.projet.web;
import java.util.Date;
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
import pfe.projet.dao.DiplomePersonnelRepository;
import pfe.projet.entities.DiplomePersonnel;
@RestController
@CrossOrigin("*")
public class DiplomePersonnelRestService {
	
		@Autowired
		private DiplomePersonnelRepository diplomePersonnelRepository;
		//Retourner la liste des diplomes
		@RequestMapping(value="/DiplomePersonnels", method=RequestMethod.GET)
		public List<DiplomePersonnel> getDiplomePersonnel(){
			return diplomePersonnelRepository.findAll();
		}
		@RequestMapping(value="/chercherDiplomePersonnel", method=RequestMethod.GET)
		public Page<DiplomePersonnel>chercher(
				@RequestParam(required = false) Date date,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return diplomePersonnelRepository.chercher(date,new PageRequest(page,size));
		}
		@RequestMapping(value="/chercherPersonnelDiplome", method=RequestMethod.GET)
		public List<DiplomePersonnel>chercherDiplome(
				@RequestParam(name="mc",defaultValue="0") long mat){
			return diplomePersonnelRepository.chercherDipPersonnel(mat);
		}
		//Retourner un seul diplome
		@RequestMapping(value="/DiplomePersonnel/{id_DipP}", method=RequestMethod.GET)
		public DiplomePersonnel getDiplomePersonnel(@PathVariable long id_DipP){
		return diplomePersonnelRepository.findOne(id_DipP);
		}
		//Ajouter un diplome
		@RequestMapping(value="/AjouterDiplomePersonnel", method=RequestMethod.POST)
		public DiplomePersonnel save(@RequestBody DiplomePersonnel d){
		return diplomePersonnelRepository.save(d);
		}
		//Supprimer un diplome
		@RequestMapping(value="/SupprimerDiplomePersonnel/{id_DipP}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long id_DipP){
			diplomePersonnelRepository.delete(id_DipP);
			return true;
		}
		//mettre à jour un diplome
		@RequestMapping(value="/ModifierDiplomePersonnel/{id_DipP}", method=RequestMethod.PUT)
		public DiplomePersonnel save(@PathVariable  long id_DipP,@RequestBody DiplomePersonnel d){
		    d.setId_DipP(id_DipP);
			return diplomePersonnelRepository.save(d);
		}
		

	}
