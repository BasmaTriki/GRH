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
import pfe.projet.dao.RoleRepository;
import pfe.projet.entities.Role;
@RestController
@CrossOrigin("*")
public class RoleRestService {
	
		@Autowired
		private RoleRepository roleRepository;
		//Retourner la liste des Roles
		@RequestMapping(value="/Roles", method=RequestMethod.GET)
		public List<Role> getRole(){
			return roleRepository.findAll();
		}
		@RequestMapping(value="/chercherRole", method=RequestMethod.GET)
		public Page<Role>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return roleRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		}
		//Retourner un seul Role
		@RequestMapping(value="/Role/{idRole}", method=RequestMethod.GET)
		public Role getOneRole(@PathVariable long idRole){
		return roleRepository.findOne(idRole);
		}
		//Ajouter un Role
		@RequestMapping(value="/AjouterRole", method=RequestMethod.POST)
		public Role save(@RequestBody Role r){
		return roleRepository.save(r);
		}
		//Supprimer un Role
		@RequestMapping(value="/SupprimerRole/{idRole}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long idRole){
			roleRepository.delete(idRole);
			return true;
		}
		//mettre à jour un Role
		@RequestMapping(value="/ModifierRole/{idRole}", method=RequestMethod.PUT)
		public Role save(@PathVariable  long idRole,@RequestBody Role r){
		    r.setIdRole(idRole);
			return roleRepository.save(r);
		}
		

	}
