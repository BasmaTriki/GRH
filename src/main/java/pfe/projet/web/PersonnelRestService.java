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
	@Autowired
	private EmailRestServices emailServices;
	//Retourner la list des Personnels
	@RequestMapping(value="/Personnels", method=RequestMethod.GET)
	public List<Personnel> getPersonnel(){
		return personnelRepository.findAll();
	}
	@RequestMapping(value="/chercherPersonnel", method=RequestMethod.GET)
	public List<Personnel>chercher(
			@RequestParam(name="mc",defaultValue="1") int etat)
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
	@RequestMapping(value="/chercherMatriculePersonnel", method=RequestMethod.GET)
	public Personnel chercherMatricule(
			@RequestParam(name="mc",defaultValue="") String mat){
		return personnelRepository.chercherPersMat(mat+"");
	}
	@RequestMapping(value="/chercherPersonnelActif", method=RequestMethod.GET)
	public Page<Personnel> chercherPers(
	@RequestParam(name="mc",defaultValue="")String mc,
	@RequestParam(name="page",defaultValue="0") int page,
	@RequestParam(name="size",defaultValue="5")int size)
	{
		return personnelRepository.chercherPersCompte(""+mc+"%",new PageRequest(page,size));
	}
	//Retourner une seul personne
	@RequestMapping(value="/Personnel/{idPers}", method=RequestMethod.GET)
	public Personnel getPersonnel(@PathVariable long idPers){
	return personnelRepository.findOne(idPers);
	}
	//Ajouter une personnel
	@RequestMapping(value="/AjouterPersonnel", method=RequestMethod.POST)
	public Personnel save(@RequestBody Personnel p){
	return personnelRepository.save(p);
	}
	//Supprimer une Personnel
	@RequestMapping(value="/SupprimerPersonnel/{idPers}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long idPers){
		personnelRepository.delete(idPers);
		return true;
	}
	//Envoyer un email nouvelle compte
		@RequestMapping(value="/NouvelleComptePersonnel/{idPers}", method=RequestMethod.GET)
		public boolean MailNouvelleCompte(@PathVariable long idPers){
			Personnel p=personnelRepository.findOne(idPers);
		    emailServices.SendLoginMotPass(p);
			return true;
		}
		//Envoyer un email nouvelle compte
				@RequestMapping(value="/MotPassOblierPersonnel", method=RequestMethod.GET)
				public boolean MailMotPassOblier(@RequestParam(name="id",defaultValue="")long idPers,
						@RequestParam(name="mail",defaultValue="")String mail){
					Personnel p=personnelRepository.findOne(idPers);
				    emailServices.SendMotPassOblier(p,mail);
					return true;
				}
	//mettre à jour une Personnel
	@RequestMapping(value="/ModifierPersonnel/{idPers}", method=RequestMethod.PUT)
	public Personnel save(@PathVariable  long idPers,@RequestBody Personnel p){
		Personnel updateble = personnelRepository.findOne(idPers);
		updateble.setIdPers(idPers);
		updateble.setMatricule(p.getMatricule());
		updateble.setCin(p.getCin());
		updateble.setAdresse(p.getAdresse());
		updateble.setNom(p.getNom());
		updateble.setPrenom(p.getPrenom());
		updateble.setEmail(p.getEmail());
		updateble.setLieuNaissance(p.getLieuNaissance());
		updateble.setNomAr(p.getNomAr());
		updateble.setPrenomAr(p.getPrenomAr());
		updateble.setLieuNaissanceAr(p.getLieuNaissanceAr());
		updateble.setAdresseAr(p.getAdresseAr());
		updateble.setTelephone(p.getTelephone());
		updateble.setEtat(p.getEtat());
		updateble.setRole(p.getRole());
		updateble.setEtatCivil(p.getEtatCivil());
		updateble.setEtatCivilAr(p.getEtatCivilAr());
		updateble.setRib(p.getRib());
		updateble.setNomConjoint(p.getNomConjoint());
		updateble.setProfConjoint(p.getProfConjoint());
		updateble.setNomConjointAr(p.getNomConjointAr());
		updateble.setProfConjointAr(p.getProfConjointAr());
		updateble.setOrganismeOrigine(p.getOrganismeOrigine());
		updateble.setDatenaissance(p.getDatenaissance());
		updateble.setLogin(p.getLogin());
		updateble.setMotpasse(p.getMotpasse());
		return personnelRepository.save(updateble);
	}
	

}
