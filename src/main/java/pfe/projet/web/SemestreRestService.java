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
	@RequestMapping(value="/Semestre", method=RequestMethod.GET)
	public List<Semestre> getEnseignants(){
		return semestreRepository.findAll();
	}
	@RequestMapping(value="/chercherSemestret", method=RequestMethod.GET)
	public Page<Semestre>chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return semestreRepository.chercher("%"+mc+"%",new PageRequest(page,size));
	}

	//Retourner un seul Semestre
	@RequestMapping(value="/Semestre/{num_sem}", method=RequestMethod.GET)
	public Semestre getEnseignant(@PathVariable long num_sem){
	return semestreRepository.findOne(num_sem);
	}
	//Ajouter un Semestre
	@RequestMapping(value="/AjouterSemestre", method=RequestMethod.POST)
	public Semestre save(@RequestBody Semestre sem){
	return semestreRepository.save(sem);
	}
	//Supprimer un Semestre
	@RequestMapping(value="/Semestre/{num_sem}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long num_sem){
		semestreRepository.delete(num_sem);
		return true;
	}
	//mettre à jour un Semestre
	@RequestMapping(value="/Semestre/{num_sem}", method=RequestMethod.PUT)
	public Semestre save(@PathVariable  int num_sem,@RequestBody Semestre sem){
	    sem.setIdSem(num_sem);
		return semestreRepository.save(sem);
	}
	
}
