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
import pfe.projet.dao.CorpsRepository;
import pfe.projet.entities.Corps;
@RestController
@CrossOrigin("*")
public class CorpsRestService {
	
		@Autowired
		private CorpsRepository corpsRepository;
		//Retourner la liste des Corpss
		@RequestMapping(value="/Corpss", method=RequestMethod.GET)
		public List<Corps> getCorps(){
			return corpsRepository.findAll();
		}
		@RequestMapping(value="/chercherCorps", method=RequestMethod.GET)
		public Page<Corps>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return corpsRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		}
		//Retourner un seul Corps
		@RequestMapping(value="/Corps/{idcps}", method=RequestMethod.GET)
		public Corps getOneCorps(@PathVariable long idcps){
		return corpsRepository.findOne(idcps);
		}
		//Ajouter un Corps
		@RequestMapping(value="/AjouterCorps", method=RequestMethod.POST)
		public Corps save(@RequestBody Corps c){
		return corpsRepository.save(c);
		}
		//Supprimer un Corps
		@RequestMapping(value="/SupprimerCorps/{idcps}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long idcps){
			corpsRepository.delete(idcps);
			return true;
		}
		//mettre à jour un Corps
		@RequestMapping(value="/ModifierCorps/{idcps}", method=RequestMethod.PUT)
		public Corps save(@PathVariable  long idcps,@RequestBody Corps c){
		    c.setIdcps(idcps);
			return corpsRepository.save(c);
		}
		

	}
