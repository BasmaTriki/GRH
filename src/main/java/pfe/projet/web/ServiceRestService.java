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

import pfe.projet.dao.ServiceRepository;
import pfe.projet.entities.Service;

@RestController
@CrossOrigin("*")
public class ServiceRestService {
	@Autowired
	private ServiceRepository serviceRepository;
	//Retourner la liste des Services
	@RequestMapping(value="/Services", method=RequestMethod.GET)
	public List<Service> getServices(){
		return serviceRepository.findAll();
	}
	@RequestMapping(value="/chercherService", method=RequestMethod.GET)
	public Page<Service>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return serviceRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}
	//Retourner un seul Service
	@RequestMapping(value="/Service/{idServ}", method=RequestMethod.GET)
	public Service getService(@PathVariable long idServ){
	return serviceRepository.findOne(idServ);
	}
	//Ajouter un Service
	@RequestMapping(value="/AjouterService", method=RequestMethod.POST)
	public Service save(@RequestBody Service s){
	return serviceRepository.save(s);
	}
	//Supprimer un service
	@RequestMapping(value="/SupprimerService/{idServ}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long idServ){
		serviceRepository.delete(idServ);
		return true;
	}
	//mettre à jour un Service
	@RequestMapping(value="/ModifierService/{idServ}", method=RequestMethod.PUT)
	public Service save(@PathVariable  long idServ,@RequestBody Service s){
	    s.setIdServ(idServ);
		return serviceRepository.save(s);
	}
}
