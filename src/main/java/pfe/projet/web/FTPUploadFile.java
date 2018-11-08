package pfe.projet.web;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pfe.projet.entities.Conge;
import pfe.projet.entities.DemandeVacation;
import pfe.projet.entities.EnseignantFonctionnaireEtat;
import pfe.projet.entities.EnseignantLibre;
import pfe.projet.entities.EnseignantVacataire;
@RestController
@CrossOrigin("*")
public class FTPUploadFile {
	 String serveur = "localhost";
	  int port = 21;
	  String user = "iset";
	  String password = "isetsf";
		@Autowired
		CongesRestService congeServices; 
		Conge conge;
		String chemin;
		DemandeVacation demande;
		EnseignantLibre  enseignantL;
		EnseignantFonctionnaireEtat enseignantF;
		@Autowired
		DemandeVacationRestService demandeServices;
		@Autowired
		EnseignantFonctionnaireEtatRestService enseignantFServices;
		@Autowired
		EnsignantLibreRestService enseignantLServices;
		@Autowired
		EnseignantVacataireRestService enseignantVacServices;
		EnseignantVacataire enseignant;
@RequestMapping(value = "/uploadCertificat/{idCong}", method = RequestMethod.POST)
public ResponseEntity<?> transferFichier(@RequestParam(name="upload") MultipartFile uploadfile,@PathVariable long idCong)
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
	      stream.close();
	      chemin=filechemin+"/"+filepath;
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

		String firstRemoteFile = "Certificat"+idCong+".jpg";
		InputStream inputStream = new FileInputStream(firstLocalFile);

		System.out.println("Start uploading first file");
		boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
		inputStream.close();
		if (done) {
			System.out.println("The first file is uploaded successfully.");
			  conge=congeServices.getOneConge(idCong);
		      conge.setCertaficat(firstRemoteFile);
		      congeServices.save(idCong, conge);
		}

		// APPROACH #2: uploads second file using an OutputStream
		/*File secondLocalFile = new File("D:/crack.txt");
		String secondRemoteFile = "crack.txt";
		inputStream = new FileInputStream(secondLocalFile);

		System.out.println("Start uploading second file");
		OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
        byte[] bytesIn = new byte[4096];
        int read = 0;

        while ((read = inputStream.read(bytesIn)) != -1) {
        	outputStream.write(bytesIn, 0, read);
        }
        inputStream.close();
        outputStream.close();

        boolean completed = ftpClient.completePendingCommand();
		if (completed) {
			System.out.println("The second file is uploaded successfully.");
		}*/

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
//envoyer les diplome sous form pdf
@RequestMapping(value = "/uploadDiplomeVac/{idDemande}", method = RequestMethod.POST)
public ResponseEntity<?> transferDiplome(@RequestParam(name="upload") MultipartFile uploadfile,@PathVariable long idDemande)
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
	      // Save the file locally
	      BufferedOutputStream stream =
	          new BufferedOutputStream(new FileOutputStream(filechemin+"/"+filepath));
	      stream.write(uploadfile.getBytes());
	      stream.close();
	      chemin=filechemin+"/"+filepath;
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
        demande=demandeServices.getOnedemandeVacation(idDemande);
		String firstRemoteFile =demande.getPrenom()+"_"+demande.getNom()+idDemande+".pdf";
		InputStream inputStream = new FileInputStream(firstLocalFile);

		System.out.println("Start uploading first file");
		boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
		inputStream.close();
		if (done) {
			System.out.println("The first file is uploaded successfully.");
			demande.setDiplomes(firstRemoteFile);
			demandeServices.save(idDemande, demande);
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
//upload Autorisation enseignant Fonctionnaire d'etat
@RequestMapping(value = "/uploadAutorisation/{idPers}", method = RequestMethod.POST)
public ResponseEntity<?> transferAutorisation(@RequestParam(name="upload") MultipartFile uploadfile,@PathVariable long idPers)
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
	      // Save the file locally
	      BufferedOutputStream stream =
	          new BufferedOutputStream(new FileOutputStream(filechemin+"/"+filepath));
	      stream.write(uploadfile.getBytes());
	      stream.close();
	      chemin=filechemin+"/"+filepath;
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
		enseignantF=enseignantFServices.getEnseignant(idPers);
		String firstRemoteFile ="Autorisation"+idPers+".jpg";
		InputStream inputStream = new FileInputStream(firstLocalFile);

		System.out.println("Start uploading first file");
		boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
		inputStream.close();
		if (done) {
			System.out.println("The first file is uploaded successfully.");
			enseignantF.setAutorisation(firstRemoteFile);
			enseignantFServices.save(idPers,enseignantF);
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
//upload declaration enseignant Libre
@RequestMapping(value = "/uploadDeclaration/{idPers}", method = RequestMethod.POST)
public ResponseEntity<?> transferDeclaration(@RequestParam(name="upload") MultipartFile uploadfile,@PathVariable long idPers)
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
	      // Save the file locally
	      BufferedOutputStream stream =
	          new BufferedOutputStream(new FileOutputStream(filechemin+"/"+filepath));
	      stream.write(uploadfile.getBytes());
	      stream.close();
	      chemin=filechemin+"/"+filepath;
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
		enseignantL=enseignantLServices.getEnseignant(idPers);
		String firstRemoteFile ="Declaration"+idPers+".jpg";
		InputStream inputStream = new FileInputStream(firstLocalFile);

		System.out.println("Start uploading first file");
		boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
		inputStream.close();
		if (done) {
			System.out.println("The first file is uploaded successfully.");
			enseignantL.setDeclarationH(firstRemoteFile);
			enseignantLServices.save(idPers,enseignantL);
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
//download diplomes de demande
@RequestMapping(value = "/downloadDiplomes/{idDemande}", method = RequestMethod.GET)
public void telechargerDiplomes(@PathVariable long idDemande)
{ 
	
	demande=demandeServices.getOnedemandeVacation(idDemande);
	String remoteFile1 = demande.getDiplomes();
	FTPClient ftpClient = new FTPClient();
	try {

		ftpClient.connect(serveur, port);
		ftpClient.login(user, password);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

		// APPROACH #1: using retrieveFile(String, OutputStream)
		File downloadFile1 = new File("D:\\"+remoteFile1);
		OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
		boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
		outputStream1.close();

		if (success) {
			System.out.println("File #1 has been downloaded successfully.");
		}
	} catch (IOException ex) {
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

}
//download certificat
@RequestMapping(value = "/downloadCertificat/{idCong}", method = RequestMethod.GET)
public void telechargerFichier(@PathVariable long idCong)
{ 
	
	conge=congeServices.getOneConge(idCong);
	String remoteFile1 = conge.getCertaficat();
	FTPClient ftpClient = new FTPClient();
	try {

		ftpClient.connect(serveur, port);
		ftpClient.login(user, password);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

		// APPROACH #1: using retrieveFile(String, OutputStream)
		File downloadFile1 = new File("D:\\"+remoteFile1);
		OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
		boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
		outputStream1.close();

		if (success) {
			System.out.println("File #1 has been downloaded successfully.");
		}
	} catch (IOException ex) {
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
}
//download Autorisation
@RequestMapping(value = "/downloadAutorisation/{idPers}", method = RequestMethod.GET)
public void telechargerAutorisation(@PathVariable long idPers)
{ 
	
	enseignantF=enseignantFServices.getEnseignant(idPers);
	String remoteFile1 = enseignantF.getAutorisation();
	FTPClient ftpClient = new FTPClient();
	try {

		ftpClient.connect(serveur, port);
		ftpClient.login(user, password);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

		// APPROACH #1: using retrieveFile(String, OutputStream)
		File downloadFile1 = new File("D:\\"+remoteFile1);
		OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
		boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
		outputStream1.close();

		if (success) {
			System.out.println("File #1 has been downloaded successfully.");
		}
	} catch (IOException ex) {
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
}
//download Declaration
@RequestMapping(value = "/downloadDeclaration/{idPers}", method = RequestMethod.GET)
public void telechargerDeclartion(@PathVariable long idPers)
{ 
	
	enseignantL=enseignantLServices.getEnseignant(idPers);
	String remoteFile1 = enseignantL.getDeclarationH();
	FTPClient ftpClient = new FTPClient();
	try {

		ftpClient.connect(serveur, port);
		ftpClient.login(user, password);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

		// APPROACH #1: using retrieveFile(String, OutputStream)
		File downloadFile1 = new File("D:\\"+remoteFile1);
		OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
		boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
		outputStream1.close();

		if (success) {
			System.out.println("File #1 has been downloaded successfully.");
		}
	} catch (IOException ex) {
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
}
//download diplomes de demande
@RequestMapping(value = "/downloadDiplomesEnseignant/{idPers}", method = RequestMethod.GET)
public void telechargerDiplomesEnsg(@PathVariable long idPers)
{ 
	
	enseignant=enseignantVacServices.getEnseignant(idPers);
	String remoteFile1 = demande.getDiplomes();
	FTPClient ftpClient = new FTPClient();
	try {

		ftpClient.connect(serveur, port);
		ftpClient.login(user, password);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

		// APPROACH #1: using retrieveFile(String, OutputStream)
		File downloadFile1 = new File("D:\\"+remoteFile1);
		OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
		boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
		outputStream1.close();

		if (success) {
			System.out.println("File #1 has been downloaded successfully.");
		}
	} catch (IOException ex) {
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

}
}
