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

import pfe.projet.dao.AGradeRepository;
import pfe.projet.entities.AGrade;
import pfe.projet.entities.Grade;
@RestController
@CrossOrigin("*")
public class AGradeRestService {
		@Autowired
		private AGradeRepository agradeRepository;
		//Retourner la liste des AGrades
		@RequestMapping(value="/AGrades", method=RequestMethod.GET)
		public List<AGrade> getAGrade(){
			return agradeRepository.findAll();
		}
		@RequestMapping(value="/chercherPersonnelGrade", method=RequestMethod.GET)
		public List<AGrade>chercherPersonnelGrade(
				@RequestParam(name="mc",defaultValue="0")long mat){
			return agradeRepository.chercherGrade(mat);
		}
		@RequestMapping(value="/chercherPersonnelGradeActuel", method=RequestMethod.GET)
		public List<AGrade>chercherGradeActuel(
				@RequestParam(name="mc",defaultValue="0")long mat){
			return agradeRepository.chercherGradeActuel(mat);
		}
		@RequestMapping(value="/chercherAGrade", method=RequestMethod.GET)
		public Page<AGrade>chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="5")int size){
			return agradeRepository.chercher("%"+mc+"%",new PageRequest(page,size));
		}
		//Retourner un seul AGrade
		@RequestMapping(value="/AGrade/{id_agrade}", method=RequestMethod.GET)
		public AGrade getAGrade(@PathVariable long id_agrade){
		return agradeRepository.findOne(id_agrade);
		}
		//Ajouter un AGrade
		@RequestMapping(value="/AjouterAGrade", method=RequestMethod.POST)
		public AGrade save(@RequestBody AGrade g){
		return agradeRepository.save(g);
		}
		//Supprimer un AGrade
		@RequestMapping(value="/SupprimerAGrade/{id}", method=RequestMethod.DELETE)
		public boolean supprimer(@PathVariable long id){
			agradeRepository.delete(id);
			return true;
		}
		//mettre à jour un AGrade
		@RequestMapping(value="/ModifierAGrade/{id}", method=RequestMethod.PUT)
		public AGrade save(@PathVariable  long id,@RequestBody AGrade g){
		    g.setId_agrade(id);
			return agradeRepository.save(g);
		}
		

	}
