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
import pfe.projet.dao.DepartementRepository;
import pfe.projet.entities.Departement;

@RestController
@CrossOrigin("*")
public class DepartementRestService {
	
		@Autowired
		private DepartementRepository departementRepository;
		//Retourner la liste des Departements
		@RequestMapping(value="/Departements", method=RequestMethod.GET)
		public List<Departement> getDepartement(){
			return departementRepository.findAll();
		}
		@RequestMapping(value="/chercherDepartement", method=RequestMethod.GET)
		public Page<Departement>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return departementRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		}
		//Retourner un seul Departement
		@RequestMapping(value="/Departement/{idDep}", method=RequestMethod.GET)
		public Departement getDepartement(@PathVariable long idDep){
		return departementRepository.findOne(idDep);
		}
		//Ajouter un Departement
		@RequestMapping(value="/AjouterDepartement", method=RequestMethod.POST)
		public Departement save(@RequestBody Departement d){
		return departementRepository.save(d);
		}
		//Supprimer un Departement
		@RequestMapping(value="/SupprimerDepartement/{id}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long id){
			departementRepository.delete(id);
			return true;
		}
		//mettre à jour un Departement
		@RequestMapping(value="/ModifierDepartement/{id}", method=RequestMethod.PUT)
		public Departement save(@PathVariable  long id,@RequestBody Departement d){
		    d.setIdDep(id);
			return departementRepository.save(d);
		}
		

	}
