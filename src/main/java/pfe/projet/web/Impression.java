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
import pfe.projet.dao.PersonnelRepository;
import pfe.projet.entities.Personnel;

@RestController
@CrossOrigin("*")
public class Impression {
	
	private Connection connection=null;
	JasperReport jasperReport;
	JasperPrint jasperPrint;

	HttpServletRequest req;

	//demandeStage 
	@RequestMapping(value="/ListePersonnelDepartement")
	 private void EnseignantDepartement(@RequestParam(name="mc",defaultValue="0")long pidDep,
			 @RequestParam(name="mp",defaultValue="")String type){
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
 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/etatEnseignant.jrxml");
	             //parametre du rapport
	             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
	             mesParametres.put("P_idDep", pidDep);
	             mesParametres.put("Ptype", type);
 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
	             	//export pdf
 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/etatEnseignant.pdf");
 
      	   	     //execution du rapport dans le navigateur
			    Runtime runtime = Runtime.getRuntime();
String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/etatEnseignant.pdf" };
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
	//Etat Liste des congés par mois
	@RequestMapping(value="/ListeCongeParType")
	 private void CongeParMoisType(
			 @RequestParam(name="mc",defaultValue="0")int pmois,
			 @RequestParam(name="mp",defaultValue="0")int pannee,
			 @RequestParam(name="mt",defaultValue="0")long idtype){
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
JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/etatCongeType.jrxml");
	             //parametre du rapport
	             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
	             mesParametres.put("pmois", pmois);
	             mesParametres.put("pannee", pannee);
	             mesParametres.put("idtype", idtype);
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
	             	//export pdf
JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/etatCongeType.pdf");

     	   	     //execution du rapport dans le navigateur
			    Runtime runtime = Runtime.getRuntime();
String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/etatCongetype.pdf" };
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
	//Etat Liste des congés par mois
		@RequestMapping(value="/ListeCongeParMois")
		 private void CongeParMois(@RequestParam(name="mc",defaultValue="0")int pmois,
				 @RequestParam(name="mp",defaultValue="0")int pannee){
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
	JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/etatCongeMois.jrxml");
		             //parametre du rapport
		             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
		             mesParametres.put("pmois", pmois);
		             mesParametres.put("pannee", pannee);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
		             	//export pdf
	JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/etatCongeMois.pdf");

	     	   	     //execution du rapport dans le navigateur
				    Runtime runtime = Runtime.getRuntime();
	String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/etatCongeMois.pdf" };
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
	@RequestMapping(value="/ListeCongeParPersonnel")
	 private void CongeParPersonnel(@RequestParam(name="mc",defaultValue="0")long idPers)
	{
		 try{
			 //connexion
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iset_sf","root", "");			 
    JasperReportsViewResolver resolver = new JasperReportsViewResolver();
	 	       resolver.setViewClass(JasperReportsMultiFormatView.class);
	 	     
	 	      ApplicationHome home = new ApplicationHome(this.getClass());
	 	    
	 	     File jarDir = home.getDir();
	 	     File RepDir = new File(jarDir, "pfe/projet/web/reports/");
	 	     File reportsPDF = new File(jarDir, "pfe/projet/web/reports/");

	 	       System.out.println("uploadDir"+RepDir);

	 	       //compiler le rapport
JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/etatCongePersonnel.jrxml");
	             //parametre du rapport
	             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
	             mesParametres.put("idPers", idPers);
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
	             	//export pdf
JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/etatCongePersonnel.pdf");

    	   	     //execution du rapport dans le navigateur
			    Runtime runtime = Runtime.getRuntime();
String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/etatCongePersonnel.pdf" };
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
	PersonnelRepository personnelRepository;
	//Attestation de travail
	//demandeStage 
		@RequestMapping(value="/AttestationTravail")
		 private void AttestationTravail(@RequestParam(name="mc",defaultValue="0")long idPers,@RequestParam(name="mp",defaultValue="")String sexe){
			 try{
				 //connexion
				 Class.forName("com.mysql.jdbc.Driver");
	 			 connection = DriverManager.getConnection(
	 	                    "jdbc:mysql://localhost:3306/iset_sf","root", "");			 
	   JasperReportsViewResolver resolver = new JasperReportsViewResolver();
		 	       resolver.setViewClass(JasperReportsMultiFormatView.class);
		 	    // Personnel p=personnelRepository.findOne(idPers);
		 	      ApplicationHome home = new ApplicationHome(this.getClass());
		 	    
		 	     File jarDir = home.getDir();
		 	     File RepDir = new File(jarDir, "pfe/projet/web/reports/");
		 	     File reportsPDF = new File(jarDir, "pfe/projet/web/reports/");
	 
		 	       System.out.println("uploadDir"+RepDir);

		 	       //compiler le rapport
	 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/AttestationTravail.jrxml");
		             //parametre du rapport
		             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
		             String type;
		             if(sexe.equals("Femme"))
		             {
		            	type="تعمل";
		             }
		             else
		             {
		            	 type="يعمل";
		             }
		            	 mesParametres.put("idPers",idPers);
		            	 mesParametres.put("typePers",type);
		            
	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
		             	//export pdf
	 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/AttestationTravail.pdf");
	 
	      	   	     //execution du rapport dans le navigateur
				    Runtime runtime = Runtime.getRuntime();
	String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/AttestationTravail.pdf" };
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
		//demandeStage 
		@RequestMapping(value="/RepriseTravail")
		 private void RepriseTravail(@RequestParam(name="mc",defaultValue="0")long idPers){
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
	 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/FicheRepriseTravailAr.jrxml");
		             //parametre du rapport
		             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
		             mesParametres.put("idPers",idPers);
	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
		             	//export pdf
	 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/FicheRepriseTravailAr.pdf");
	 
	      	   	     //execution du rapport dans le navigateur
				    Runtime runtime = Runtime.getRuntime();
	String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/FicheRepriseTravailAr.pdf" };
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
		//demandeStage 
		@RequestMapping(value="/RepriseConge")
		 private void RepriseConge(@RequestParam(name="mc",defaultValue="0")long idPers){
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
	 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/FicheRepriseAr.jrxml");
		             //parametre du rapport
		             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
		             mesParametres.put("idPers",idPers);
	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
		             	//export pdf
	 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/FicheRepriseAr.pdf");
	 
	      	   	     //execution du rapport dans le navigateur
				    Runtime runtime = Runtime.getRuntime();
	String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/FicheRepriseAr.pdf" };
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

