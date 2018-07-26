package pfe.projet.web;
import java.io.File;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@CrossOrigin("*")
public class Impression {
	
	private Connection connection=null;
	JasperReport jasperReport;
	JasperPrint jasperPrint;

	HttpServletRequest req;

	//demandeStage 
	@RequestMapping(value="/ListePersonnelDepartement")
	 private void EnseignantDepartement(@RequestParam(name="mc",defaultValue="0")long pidDep){
		 try{
			 //connexion
			 Class.forName("com.mysql.jdbc.Driver");
 			 connection = DriverManager.getConnection(
 	                    "jdbc:mysql://localhost:3306/iset_sf","root", "");			 
   JasperReportsViewResolver resolver = new JasperReportsViewResolver();
	 	       resolver.setViewClass(JasperReportsMultiFormatView.class);
	 	     
	 	      ApplicationHome home = new ApplicationHome(this.getClass());
	 	    
	 	     File jarDir = home.getDir();
	 	     File RepDir = new File(jarDir, "pfe/projet/web/reports/");
	 	     File reportsPDF = new File(jarDir, "pfe/projet/web/reports/");
 
	 	       System.out.println("uploadDir"+RepDir);

	 	       //compiler le rapport
 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/test1.jrxml");
	             //parametre du rapport
	             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
	             mesParametres.put("P_idDep", pidDep);
 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
	             	//export pdf
 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/test1.pdf");
 
      	   	     //execution du rapport dans le navigateur
			    Runtime runtime = Runtime.getRuntime();
String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/test1.pdf" };
              try {
                  final Process process = runtime.exec(args);
              } catch (IOException e) {
           // TODO Auto-generated catch block
                  e.printStackTrace();
              }
		 } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	        
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }

}

