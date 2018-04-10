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
import pfe.projet.dao.UserRepository;
import pfe.projet.entities.User;
@RestController
@CrossOrigin("*")
public class UserRestService {
@Autowired
private UserRepository userRepository;
@RequestMapping(value="/users", method=RequestMethod.GET)
public List<User> getUser(){
	return userRepository.findAll();
}
@RequestMapping(value="/chercherUsers", method=RequestMethod.GET)
public Page<User>chercher(
		@RequestParam(name="mc",defaultValue="") String mc,
		@RequestParam(name="mp",defaultValue="") String mp,
		@RequestParam(name="page",defaultValue="0") int page,
		@RequestParam(name="size",defaultValue="5")int size){
	return userRepository.chercher("%"+mc+"%","%"+mp+"%",new PageRequest(page,size));
}
@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
public User getUser(@PathVariable Long id){
return userRepository.findOne(id);
}
@RequestMapping(value="/users", method=RequestMethod.POST)
public User save(@RequestBody User u){
return userRepository.save(u);
}
@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
public boolean supprimer(@PathVariable Long id){
	userRepository.delete(id);
	return true;
}
@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
public User save(@PathVariable Long id,@RequestBody User u){
    u.setId(id);
	return userRepository.save(u);
}
}
