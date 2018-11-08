package pfe.projet.web;

import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
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
	 String serveur = "localhost";
	  int port = 21;
	  String user = "iset";
	  String password = "isetsf";
	@Autowired
	DemandeVacationRestService demandeVacService;
	DemandeVacation demande;
    String chemin;
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
	      chemin=filechemin+"/"+filepath;
	      stream.close();
	}
	    catch (Exception e) {
	      System.out.println(e.getMessage());
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	    FTPClient ftpClient = new FTPClient();
		try {

			ftpClient.connect(serveur, port);
			ftpClient.login(user, password);
			ftpClient.enterLocalPassiveMode();

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			// APPROACH #1: uploads first file using an InputStream
			File firstLocalFile = new File(chemin);

			String firstRemoteFile = demande.getPrenom()+"-"+demande.getNom()+".pdf";
			InputStream inputStream = new FileInputStream(firstLocalFile);

			System.out.println("Start uploading first file");
			boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
			inputStream.close();
			if (done) {
				System.out.println("The first file is uploaded successfully.");
			    demande.setDiplomes(firstRemoteFile);
			      demandeVacService.save(idDemande, demande);
				
			}
		}
		 catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	    return new ResponseEntity<>(HttpStatus.OK);
	  }
}
