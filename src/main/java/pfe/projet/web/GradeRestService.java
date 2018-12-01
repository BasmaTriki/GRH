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

import pfe.projet.dao.GradeRepository;
import pfe.projet.entities.Grade;
@RestController
@CrossOrigin("*")
public class GradeRestService {
		@Autowired
		private GradeRepository gradeRepository;
		//Retourner la liste des Grades
		@RequestMapping(value="/Grades", method=RequestMethod.GET)
		public List<Grade> getGrade(){
			return gradeRepository.findAll();
		}
		@RequestMapping(value="/chercherGrade", method=RequestMethod.GET)
		public Page<Grade>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return gradeRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		}
		
		//Retourner un seul Grade
		@RequestMapping(value="/Grade/{id}", method=RequestMethod.GET)
		public Grade getGrade(@PathVariable long id){
		return gradeRepository.findOne(id);
		}
		//Ajouter un Grade
		@RequestMapping(value="/AjouterGrade", method=RequestMethod.POST)
		public Grade save(@RequestBody Grade g){
		return gradeRepository.save(g);
		}
		//Supprimer un Grade
		@RequestMapping(value="/SupprimerGrade/{id}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long id){
			gradeRepository.delete(id);
			return true;
		}
		//mettre à jour un Grade
		@RequestMapping(value="/ModifierGrade/{id}", method=RequestMethod.PUT)
		public Grade save(@PathVariable  long id,@RequestBody Grade g){
		    g.setId(id);
			return gradeRepository.save(g);
		}
		

	}
