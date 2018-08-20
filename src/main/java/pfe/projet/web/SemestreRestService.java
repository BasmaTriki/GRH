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
import pfe.projet.dao.SemestreRepository;
import pfe.projet.entities.Semestre;
@RestController
@CrossOrigin("*")
public class SemestreRestService {
	@Autowired
	private SemestreRepository semestreRepository;
	//Retourner la liste des Semestres
	@RequestMapping(value="/Semestres", method=RequestMethod.GET)
	public List<Semestre> getEnseignants(){
		return semestreRepository.findAll();
	}
	@RequestMapping(value="/chercherSemestre", method=RequestMethod.GET)
	public Page<Semestre>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return semestreRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}

	//Retourner un seul Semestre
	@RequestMapping(value="/Semestre/{idSem}", method=RequestMethod.GET)
	public Semestre getEnseignant(@PathVariable int idSem){
	return semestreRepository.findOne(idSem);
	}
	//Ajouter un Semestre
	@RequestMapping(value="/AjouterSemestre", method=RequestMethod.POST)
	public Semestre save(@RequestBody Semestre sem){
	return semestreRepository.save(sem);
	}
	//Supprimer un Semestre
	@RequestMapping(value="/SupprimerSemestre/{idSem}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int idSem){
		semestreRepository.delete(idSem);
		return true;
	}
	//mettre à jour un Semestre
	@RequestMapping(value="/ModifierSemestre/{idSem}", method=RequestMethod.PUT)
	public Semestre save(@PathVariable int idSem,@RequestBody Semestre sem){
	    sem.setIdSem(idSem);
		return semestreRepository.save(sem);
	}
	
}
