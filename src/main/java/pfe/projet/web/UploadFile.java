package pfe.projet.web;

import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pfe.projet.entities.Conge;
import pfe.projet.entities.DemandeVacation;


@RestController
@CrossOrigin("*")
public class UploadFile {
	@Autowired
	DemandeVacationRestService demandeVacService;
	@Autowired
	CongesRestService congeServices; 
	Conge conge;
	DemandeVacation demande;
	  @RequestMapping(value = "/uploadFile/{idCong}", method = RequestMethod.POST)
	  @ResponseBody
	  public ResponseEntity<?> uploadFile(
			  @PathVariable long idCong,
			  @RequestParam("uploadfile") MultipartFile uploadfile)
	  {
	
	    try {
	      // Get the filename and build the local file path
		    ApplicationHome home = new ApplicationHome(this.getClass());
	        File jarDir = home.getDir();
		     File filechemin = new File(jarDir, "UploadFile/");
		     System.out.println(filechemin);
	        if (!filechemin.exists()) {
	            if (filechemin.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
	        }
	        String filename = uploadfile.getOriginalFilename();
		      String filepath = Paths.get(filename).toString();
		      System.out.println("fff"+filepath);
	    /*  String filename = uploadfile.getOriginalFilename();
	      String directory = env.getProperty("chemin.uploadedFiles");
	      String filepath = Paths.get(directory, filename).toString();
	      */
	      // Save the file locally
	      BufferedOutputStream stream =
	          new BufferedOutputStream(new FileOutputStream(filechemin+"/"+filepath));
	      stream.write(uploadfile.getBytes());
	      conge=congeServices.getOneConge(idCong);
	      conge.setCertaficat(filechemin+"/"+filepath);
	      congeServices.save(idCong, conge);
	      stream.close();
	}
	    catch (Exception e) {
	      System.out.println(e.getMessage());
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	
	    return new ResponseEntity<>(HttpStatus.OK);
	  } // method uploadFile

//ajout 
	  @RequestMapping(value = "/uploadDiplome/{idDemande}", method = RequestMethod.POST)
	  @ResponseBody
	  public ResponseEntity<?> uploadDiplome(
			  @PathVariable long idDemande,
			  @RequestParam("uploadDiplome") MultipartFile uploadfile)
	  {
	
	    try {
	      // Get the filename and build the local file path
		    ApplicationHome home = new ApplicationHome(this.getClass());
	        File jarDir = home.getDir();
		     File filechemin = new File(jarDir, "UploadDiplomeVacation/");
		     System.out.println(filechemin);
	        if (!filechemin.exists()) {
	            if (filechemin.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
	        }
	        String filename = uploadfile.getOriginalFilename();
		      String filepath = Paths.get(filename).toString();
		      System.out.println("fff"+filepath);
	    /*  String filename = uploadfile.getOriginalFilename();
	      String directory = env.getProperty("chemin.uploadedFiles");
	      String filepath = Paths.get(directory, filename).toString();
	      */
	      // Save the file locally
	      BufferedOutputStream stream =
	          new BufferedOutputStream(new FileOutputStream(filechemin+"/"+filepath));
	      stream.write(uploadfile.getBytes());
	      demande=demandeVacService.getOnedemandeVacation(idDemande);
	      demande.setDiplomes(filechemin+"/"+filepath);
	      demandeVacService.save(idDemande, demande);
	      stream.close();
	}
	    catch (Exception e) {
	      System.out.println(e.getMessage());
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	
	    return new ResponseEntity<>(HttpStatus.OK);
	  } // method uploadFile

/*@RequestMapping(value="/addDemandeVac")
	public DemandeVacation addDemande(DemandeVacation d,String photo) {
		if(photo==null ){
			return demandeVacService.save(d);
		}else {
			  ApplicationHome home = new ApplicationHome(this.getClass());
			    File jarDir = home.getDir();
			     File file= new File(jarDir, "UploadFile/"+photo);
	byte[] bFile = new byte[(int) file.length()];
	try {
	            FileInputStream fileInputStream = new FileInputStream(file);
	fileInputStream.read(bFile);
	fileInputStream.close();
	        } catch (Exception ee) {
	ee.printStackTrace();
	}
	d.setPhoto(bFile);		
			return demandeVacService.save(d);
		}
		
	}*/
}
