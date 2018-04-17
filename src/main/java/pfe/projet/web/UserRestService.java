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
		@RequestParam(required = false) Date date,
		@RequestParam(name="page",defaultValue="0") int page,
		@RequestParam(name="size",defaultValue="5")int size){
	return userRepository.chercher(date,new PageRequest(page,size));
}
/*@RequestMapping(value="/chercheUser", method=RequestMethod.GET)
public Page<User>chercherUser(
		@RequestParam(name="mc",defaultValue="") String mc,
		@RequestParam(name="mp",defaultValue="") String mp){
	return userRepository.chercheUser("%"+mc+"%","%"+mp+"%");
}*/
@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
public User getUser(@PathVariable String login){
return userRepository.findOne(login);
}
@RequestMapping(value="/users", method=RequestMethod.POST)
public User save(@RequestBody User u){
return userRepository.save(u);
}
@RequestMapping(value="/users/{login}", method=RequestMethod.DELETE)
public boolean supprimer(@PathVariable String login){
	userRepository.delete(login);
	return true;
}
@RequestMapping(value="/users/{login}", method=RequestMethod.PUT)
public User save(@PathVariable String login,@RequestBody User u){
    u.getCk().setLogin(login);
	return userRepository.save(u);
}
}
