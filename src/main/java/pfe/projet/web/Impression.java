package pfe.projet.web;
import java.io.File;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.stereotype.Controller;
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
	  String mois[] = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
	  String moisAr[] = {"جانفي", "فيفري", "مارس", "أفريل", "ماي", "جوان", "جويلية", "أوت", "سبتمبر", "أكتوبر", "نوفمبر", "ديسمبر"};
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
	             mesParametres.put("mois", mois[pmois-1]);
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
	@RequestMapping(value="/ListeCongeParTypeAr")
	 private void CongeParMoisTypeAr(
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
JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/etatCongeTypeAr.jrxml");
	             //parametre du rapport
	             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
	             mesParametres.put("pmois", pmois);
	             mesParametres.put("pannee", pannee);
	             mesParametres.put("idtype", idtype);
	             mesParametres.put("mois", moisAr[pmois-1]);
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
	             	//export pdf
JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/etatCongeTypeAr.pdf");

    	   	     //execution du rapport dans le navigateur
			    Runtime runtime = Runtime.getRuntime();
String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/etatCongetypeAr.pdf" };
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
		             if(sexe.equals("Femme")||sexe.equals("انثى"))
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
	 //JasperExportManager.exportReportToXslFile(jasperPrint, reportsPDF+"/AttestationTravail.pdf");
	 
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
		 private void RepriseConge(@RequestParam(name="mc",defaultValue="0")long idCng){
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
		             mesParametres.put("idCng",idCng);
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
		@RequestMapping(value="/FichePersonnel")
		 private void FichePersonnel(@RequestParam(name="mc",defaultValue="0")long idPers){
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
	 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/FichePersonnelAr.jrxml");
		             //parametre du rapport
	 JasperReport subReport = JasperCompileManager.compileReport(RepDir+"/Enfants.jrxml");
    
     System.out.println(subReport);
     //String subReport="Enfants.jasper";
		             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
		             mesParametres.put("idPers",idPers);
		            // mesParametres.put("subReport", subReport);
	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
		             	//export pdf
	 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/FichePersonnelAr.pdf");
	 
	      	   	     //execution du rapport dans le navigateur
				    Runtime runtime = Runtime.getRuntime();
	String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/FichePersonnelAr.pdf" };
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
		@RequestMapping(value="/ListeEnseignantDepartement")
		 private void ListeEnseignantDepartement(@RequestParam(name="mc",defaultValue="0")long idDep){
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
	 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/ListeEnseignantParDepartement.jrxml");
		             //parametre du rapport
		             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
		             mesParametres.put("idDep",idDep);
	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
		             	//export pdf
	 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/ListeEnseignantParDepartement.pdf");
	 
	      	   	     //execution du rapport dans le navigateur
				    Runtime runtime = Runtime.getRuntime();
	String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/ListeEnseignantParDepartement.pdf" };
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
		//Liste des enseignants par Grade
		@RequestMapping(value="/ListeEnseignantGrade")
		 private void ListeEnseignantGrade(@RequestParam(name="mc",defaultValue="0")long idGrade){
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
	 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/ListeEnseignantParGrade.jrxml");
		             //parametre du rapport
		             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
		             mesParametres.put("idGrade",idGrade);
	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
		             	//export pdf
	 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/ListeEnseignantParGrade.pdf");
	 
	      	   	     //execution du rapport dans le navigateur
				    Runtime runtime = Runtime.getRuntime();
	String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/ListeEnseignantParGrade.pdf" };
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
		//Listes des enseignants par corps
		@RequestMapping(value="/ListeEnseignantCorps")
		 private void ListeEnseignantCorps(@RequestParam(name="mc",defaultValue="0")long idCps){
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
	 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/ListeEnseignantParCorps.jrxml");
		             //parametre du rapport
		             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
		             mesParametres.put("idCps",idCps);
	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
		             	//export pdf
	 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/ListeEnseignantParCorps.pdf");
	 
	      	   	     //execution du rapport dans le navigateur
				    Runtime runtime = Runtime.getRuntime();
	String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/ListeEnseignantParCorps.pdf" };
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
		//Liste des enseignants Actif
		@RequestMapping(value="/ListeEnseignantActif")
		 private void ListeEnseignantActif(@RequestParam(name="mc",defaultValue="")String annUniv){
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
	 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/ListeEnseignantActif.jrxml");
		             //parametre du rapport
		             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
		             mesParametres.put("annUniv",annUniv);
	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
		             	//export pdf
	 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/ListeEnseignantActif.pdf");
	 
	      	   	     //execution du rapport dans le navigateur
				    Runtime runtime = Runtime.getRuntime();
	String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/ListeEnseignantActif.pdf" };
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
		//Liste des enseignants Inactif
				@RequestMapping(value="/ListeEnseignantInactif")
				 private void ListeEnseignantInactif(@RequestParam(name="mc",defaultValue="")String annUniv){
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
			 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/ListeEnseignantInactif.jrxml");
				             //parametre du rapport
				             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
				             mesParametres.put("annUniv",annUniv);
			 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
				             	//export pdf
			 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/ListeEnseignantInactif.pdf");
			 
			      	   	     //execution du rapport dans le navigateur
						    Runtime runtime = Runtime.getRuntime();
			String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/ListeEnseignantInactif.pdf" };
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
				//Liste des Mutations
				@RequestMapping(value="/ListeMutations")
				 private void ListeDeMutation(@RequestParam(name="mc",defaultValue="")String annUniv,@RequestParam(name="mp",defaultValue="0")int annee){
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
			 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/MutationsEns.jrxml");
				             //parametre du rapport
				             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
				             mesParametres.put("AnneUniv",annUniv);
				             mesParametres.put("annee",annee);
			 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
				             	//export pdf
			 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/MutationEnseignant.pdf");
			 
			      	   	     //execution du rapport dans le navigateur
						    Runtime runtime = Runtime.getRuntime();
			String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/MutationEnseignant.pdf" };
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
				//Liste des enseignants par departement et par grade
				@RequestMapping(value="/ListeEnseigParDep")
				 private void ListeDeEnseig(@RequestParam(name="mc",defaultValue="")String annUniv){
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
			 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/NomberEnseignanentA.jrxml");
				             //parametre du rapport
				             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
				             mesParametres.put("AnneeUniv",annUniv);
			 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
				             	//export pdf
			 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/NomberEnseignantActif.pdf");
			 
			      	   	     //execution du rapport dans le navigateur
						    Runtime runtime = Runtime.getRuntime();
			String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/NomberEnseignantActif.pdf" };
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
				//Prime Rendement
				@RequestMapping(value="/PrimeRendement")
				 private void PrimeRendement(@RequestParam(name="mc",defaultValue="")String annUniv,@RequestParam(name="d1")Date d1,@RequestParam(name="d2")Date d2){
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
			 JasperReport jasperReport = JasperCompileManager.compileReport(RepDir+"/PrimeRendement.jrxml");
				             //parametre du rapport
				             HashMap<String, Object> mesParametres = new HashMap<String, Object>();
				             mesParametres.put("annUniv",annUniv);
				             mesParametres.put("mois1",d1);
				             mesParametres.put("mois2",d2);
			 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mesParametres, connection);
				             	//export pdf
			 JasperExportManager.exportReportToPdfFile(jasperPrint, reportsPDF+"/PrimeRendement.pdf");
			 
			      	   	     //execution du rapport dans le navigateur
						    Runtime runtime = Runtime.getRuntime();
			String[] args = { "C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe", reportsPDF+"/PrimeRendement.pdf" };
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

