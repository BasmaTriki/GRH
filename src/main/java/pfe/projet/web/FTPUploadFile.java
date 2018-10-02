package pfe.projet.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@CrossOrigin("*")
public class FTPUploadFile {
	 String serveur = "192.168.1.14";
	  int port = 21;
	  String user = "iset";
	  String password = "isetsf";
		@Autowired
		CongesRestService congeServices; 
		Conge conge;
@RequestMapping(value = "/uploadCertaficat/{idCong}", method = RequestMethod.POST)
public void transferFichier(@RequestParam(name="upload") File uploadfile,@PathVariable long idCong)
{
	FTPClient ftpClient = new FTPClient();
	try {

		ftpClient.connect(serveur, port);
		ftpClient.login(user, password);
		ftpClient.enterLocalPassiveMode();

		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

		// APPROACH #1: uploads first file using an InputStream
		File firstLocalFile = new File("C:\\Users\\Basma\\Downloads\\bbb.png");

		String firstRemoteFile = "Certaficat2"+".jpg";
		InputStream inputStream = new FileInputStream(firstLocalFile);

		System.out.println("Start uploading first file");
		boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
		inputStream.close();
		if (done) {
			System.out.println("The first file is uploaded successfully.");
		}

		// APPROACH #2: uploads second file using an OutputStream
		File secondLocalFile = new File("D:/crack.txt");
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
