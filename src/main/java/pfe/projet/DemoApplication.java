package pfe.projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pfe.projet.dao.EtatRepository;
import pfe.projet.dao.PersonnelRepository;
import pfe.projet.dao.RoleRepository;
import pfe.projet.dao.SemestreRepository;
import pfe.projet.entities.Etat;
import pfe.projet.entities.Personnel;
import pfe.projet.entities.Role;
import pfe.projet.entities.Semestre;
import pfe.projet.web.ImportationRestServices;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {
@Autowired
private PersonnelRepository personnelRepository;
@Autowired
private RoleRepository roleRepository;
@Autowired
private SemestreRepository semestreRepository;
@Autowired
private EtatRepository etatRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		//personnelRepository.save(p);
		//userRepository.save(u);
		Role r1=new Role(1,"Admin");
		Role r2=new Role(2,"utilisateur");
		Role r3=new Role(3,"AgentGRH");
		Role r4=new Role(4,"DirecteurES");
		Semestre s1=new Semestre(1,"semestre 1","السداسية  1");
		Semestre s2=new Semestre(2,"semestre 2","السداسية  2");
		Etat e1=new Etat(1,"actif");
		Etat e2=new Etat(2,"non-actif");
		Etat e3=new Etat(3,"détaché");
		Etat e4=new Etat(4,"Sous Drapeau");
		e1.setLibelleEtatAr("مباشر");
		e2.setLibelleEtatAr("غير مباشر");
		e3.setLibelleEtatAr("ملحق");
		e4.setLibelleEtatAr("تحت السلاح");
		etatRepository.save(e1);
		etatRepository.save(e2);
		etatRepository.save(e3);
		etatRepository.save(e4);
		semestreRepository.save(s1);
		semestreRepository.save(s2);
		roleRepository.save(r1);
		roleRepository.save(r2);
		roleRepository.save(r3);
		roleRepository.save(r4);
		Personnel p1=new Personnel();
		p1.setMatricule("232445684");
		p1.setCin("099013453");
		p1.setEtat(e1);
		p1.setLogin("Ahmed");
		p1.setMotpasse("Ahmed");
		p1.setPrenom("Ahmed");
		p1.setNom("Jmal");
		p1.setPrenomAr("أحمد");
		p1.setNomAr("الجمل");
		p1.setRole(r1);
		//personnelRepository.save(p1);
		//userRepository.save(new User("Basma","Triki","directeur",df.parse("12/01/2018"),"BT@gmail.com"));
		personnelRepository.findAll().forEach(c->{
		System.out.println(c.getMatricule());
		});
	}
}
