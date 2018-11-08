package pfe.projet.web;

import org.springframework.stereotype.Service;
import pfe.projet.entities.DemandeVacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@Service
public class EmailRestServices {
	@Autowired
private JavaMailSender javaMail;
public EmailRestServices(JavaMailSender javaMail)
{
	this.javaMail=javaMail;
}
public void SendEmailAccepter(DemandeVacation demande)
{//send Email
	try {
	SimpleMailMessage mail=new SimpleMailMessage();
	mail.setTo(demande.getEmail());
	//mail.setFrom("isetsfax2018@gmail.com");
	mail.setSubject("Concernant votre demande de vacation");
	mail.setText("Félécitations.\nVotre demande de vacation a été acceptée au sein de l'ISET Sfax.\nNous vous remercions de bien vouloir prendre contact avec notre administration le plus rapidement possible.\nMerci et à bientôt.");
	javaMail.send(mail);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
public void SendEmailRefuser(DemandeVacation demande)
{
	//send Email
	try {
	SimpleMailMessage mail=new SimpleMailMessage();
	mail.setTo(demande.getEmail());
	mail.setFrom("isetsfax2018@gmail.com");
	mail.setSubject("Concernant votre demande de vacation");
	mail.setText("Faisant suite à votre condidature, nous avons le regret de vous informer que votre demande n'a pas été retenue."
			+ "\n Nous sommes sensibles à l'intérêt que vous avez porté à notre établissement et nous vous souhaitons une bonne continuation.");
	javaMail.send(mail);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}
