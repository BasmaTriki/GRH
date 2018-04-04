package pfe.projet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pfe.projet.dao.UserRepository;
import pfe.projet.entities.User;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {
@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		//DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		//userRepository.save(new User("Marwa","BenBrahim","directeur",df.parse("20/10/2017"),"Marwa@gmail.com"));
		//userRepository.save(new User("Basma","Triki","directeur",df.parse("12/01/2018"),"BT@gmail.com"));
	    userRepository.findAll().forEach(c->{
		System.out.println(c.getLogin());
		});
	}
}
