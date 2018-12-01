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

import pfe.projet.dao.TypeCongeRepository;
import pfe.projet.entities.TypeConge;

@RestController
@CrossOrigin("*")
public class TypeCongeRestService {

	@Autowired
	private TypeCongeRepository typeCongeRepository;
	//Retourner la liste des TypeConges
	@RequestMapping(value="/TypeConges", method=RequestMethod.GET)
	public List<TypeConge> getTypeConges(){
		return typeCongeRepository.findAll();
	}
	@RequestMapping(value="/chercherTypeConge", method=RequestMethod.GET)
	public Page<TypeConge>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return typeCongeRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}
	@RequestMapping(value="/ListeParType", method=RequestMethod.GET)
	public List<TypeConge>chercherParType(
			@RequestParam(name="mc",defaultValue="")String mc){
		return typeCongeRepository.chercherParType(mc+"%");
	}
	//Retourner un seul TypeConge
	@RequestMapping(value="/TypeConge/{idCg}", method=RequestMethod.GET)
	public TypeConge getTypeConge(@PathVariable long idCg){
	return typeCongeRepository.findOne(idCg);
	}
	//Ajouter TypeConge
	@RequestMapping(value="/AjouterTypeConge", method=RequestMethod.POST)
	public TypeConge save(@RequestBody TypeConge tc){
	return typeCongeRepository.save(tc);
	}
	//Supprimer une TypeConge
	@RequestMapping(value="/SupprimerTypeConge/{idCg}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long idCg){
		typeCongeRepository.delete(idCg);
		return true;
	}
	//mettre à jour une TypeConge
	@RequestMapping(value="/ModifierTypeConge/{idCg}", method=RequestMethod.PUT)
	public TypeConge save(@PathVariable  long idCg,@RequestBody TypeConge tc){
	    tc.setIdCg(idCg);
		return typeCongeRepository.save(tc);
	}
}
