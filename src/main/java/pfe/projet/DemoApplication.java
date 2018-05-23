package pfe.projet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pfe.projet.dao.PersonnelRepository;
import pfe.projet.dao.UserRepository;
import pfe.projet.entities.Personnel;
import pfe.projet.entities.User;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {
@Autowired
	private UserRepository userRepository;
@Autowired
private PersonnelRepository personnelRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Personnel p=new Personnel();
		p.setMatricule(234567);
		p.setNom("Marwa");
		p.setPrenom("Basma");
		User u=new User("Marwa","Basma",df.parse("12/01/2018"),p);
		personnelRepository.save(p);
		userRepository.save(u);
		//userRepository.save(new User("Basma","Triki","directeur",df.parse("12/01/2018"),"BT@gmail.com"));
	    userRepository.findAll().forEach(c->{
		System.out.println(c.getLogin());
		});
	}
}
