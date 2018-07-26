package pfe.projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pfe.projet.dao.PersonnelRepository;
import pfe.projet.dao.RoleRepository;
import pfe.projet.entities.Personnel;
import pfe.projet.entities.Role;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {
@Autowired
private PersonnelRepository personnelRepository;
@Autowired
private RoleRepository roleRepository;
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
		roleRepository.save(r1);
		roleRepository.save(r2);
		roleRepository.save(r3);
		roleRepository.save(r4);
		//userRepository.save(new User("Basma","Triki","directeur",df.parse("12/01/2018"),"BT@gmail.com"));
		personnelRepository.findAll().forEach(c->{
		System.out.println(c.getMatricule());
		});
	}
}
