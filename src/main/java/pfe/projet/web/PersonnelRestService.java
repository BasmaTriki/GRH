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

import pfe.projet.dao.PersonnelRepository;
import pfe.projet.entities.Personnel;
@RestController
@CrossOrigin("*")
public class PersonnelRestService {
	@Autowired
	private PersonnelRepository personnelRepository;
	//Retourner la list des Personnels
	@RequestMapping(value="/Personnels", method=RequestMethod.GET)
	public List<Personnel> getPersonnel(){
		return personnelRepository.findAll();
	}
	@RequestMapping(value="/chercherPersonnel", method=RequestMethod.GET)
	public List<Personnel>chercher(
			@RequestParam(name="mc",defaultValue="true") boolean etat)
	{
		return personnelRepository.chercherPersonnel(etat);
	}
	@RequestMapping(value="/chercherPersonnelLogin", method=RequestMethod.GET)
	public Personnel chercherLogin(
			@RequestParam(name="mc",defaultValue="") String log,
			@RequestParam(name="mp",defaultValue="") String motpass)
	{
		return personnelRepository.chercherPersonnelLogin(log+"", motpass+"");
	}
	@RequestMapping(value="/chercherTypePersonnel", method=RequestMethod.GET)
	public String chercherType(
			@RequestParam(name="mc",defaultValue="0") long mat){
		return personnelRepository.chercherType(mat);
	}
	@RequestMapping(value="/chercherPersonnelActif", method=RequestMethod.GET)
	public Page<Personnel> chercherPers(
	@RequestParam(name="mc",defaultValue="")String mc,
	@RequestParam(name="page",defaultValue="0") int page,
	@RequestParam(name="size",defaultValue="5")int size)
	{
		return personnelRepository.chercherPers(""+mc+"%",new PageRequest(page,size));
	}
	//Retourner une seul personne
	@RequestMapping(value="/Personnel/{matricule}", method=RequestMethod.GET)
	public Personnel getPersonnel(@PathVariable long matricule){
	return personnelRepository.findOne(matricule);
	}
	//Ajouter une personnel
	@RequestMapping(value="/AjouterPersonnel", method=RequestMethod.POST)
	public Personnel save(@RequestBody Personnel p){
	return personnelRepository.save(p);
	}
	//Supprimer une Personnel
	@RequestMapping(value="/SupprimerPersonnel/{matricule}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long matricule){
		personnelRepository.delete(matricule);
		return true;
	}
	//mettre à jour une Personnel
	@RequestMapping(value="/ModifierPersonnel/{matricule}", method=RequestMethod.PUT)
	public Personnel save(@PathVariable  long matricule,@RequestBody Personnel p){
		Personnel updateble = personnelRepository.findOne(matricule);
		updateble.setMatricule(matricule);
		updateble.setCin(p.getCin());
		updateble.setAdresse(p.getAdresse());
		updateble.setNom(p.getNom());
		updateble.setPrenom(p.getPrenom());
		updateble.setEmail(p.getEmail());
		updateble.setLieuNaissance(p.getLieuNaissance());
		updateble.setTelephone(p.getTelephone());
		updateble.setEtat(p.isEtat());
		updateble.setDatenaissance(p.getDatenaissance());
		updateble.setLogin(p.getLogin());
		updateble.setMotpasse(p.getMotpasse());
		return personnelRepository.save(updateble);
	}
	

}
