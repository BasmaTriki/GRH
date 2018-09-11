package pfe.projet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import com.mysql.jdbc.PreparedStatement;

import pfe.projet.dao.AGradeRepository;
import pfe.projet.dao.AdministratifRepository;
import pfe.projet.dao.CorpsRepository;
import pfe.projet.dao.DepartementRepository;
import pfe.projet.dao.EnseignantPermanentRepository;
import pfe.projet.dao.EtatPersonnelRepository;
import pfe.projet.dao.EtatRepository;
import pfe.projet.dao.GradeRepository;
import pfe.projet.dao.PeriodeRepository;
import pfe.projet.dao.PosteAdministrativeRepository;
import pfe.projet.dao.SpecialiteRepository;
import pfe.projet.entities.AGrade;
import pfe.projet.entities.Administratif;
import pfe.projet.entities.Corps;
import pfe.projet.entities.Departement;
import pfe.projet.entities.Enfant;
import pfe.projet.entities.EnseignantPermanent;
import pfe.projet.entities.Etat;
import pfe.projet.entities.EtatPersonnel;
import pfe.projet.entities.Grade;
import pfe.projet.entities.Periode;
import pfe.projet.entities.PosteAdministrative;
import pfe.projet.entities.Specialite;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
 
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
@RestController
@CrossOrigin("*")
public class ImportationAdminRestServices {
	@Autowired
	public DepartementRepository departementRepo=null;
	@Autowired
	public SpecialiteRepository specialiteRepo;
	@Autowired
	public GradeRepository gradeRepo;
	@Autowired
	public AGradeRepository agradeRepo;
	@Autowired
	public PosteAdministrativeRepository posteRepo;
	@Autowired
	public PeriodeRepository periodeRepo;
	public Periode periode;
	@Autowired
	public EtatRepository etatRepo;
	@Autowired
	public EtatPersonnelRepository etatpersRepo;
	//public Departement departement;
	//public Specialite specialite;
	public Etat etat;
	public PosteAdministrative poste;
	public Grade grade;
	public AGrade agrade;
	public EtatPersonnel etatpersonnel;
	public Administratif enp;
	@Autowired
	public AdministratifRepository enpRepo;
	@Autowired
	public CorpsRepository corpsRepo;
	public String prenomAr="";
	public String nomAr;
	public String cin;
	public String matricule="";
	public String sexeAr;
	public Date dateNais;
	public Date dateRecrutement;
	public Date dateTitularisation;
	public String telephone="";
	public String lieuNaisAr;
	private String chemin;
	@RequestMapping(value = "/uploadFileAdminImporter", method = RequestMethod.POST)
	  @ResponseBody
	  public ResponseEntity<?> uploadFile(
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
	      //conge=congeServices.getOneConge(idCong);
	      //conge.setCertaficat(filechemin+"/"+filepath);
	      //congeServices.save(idCong, conge);
	      chemin=filechemin+"/"+filepath;
	      stream.close();
	      treatDocument(chemin);
	}
	    catch (Exception e) {
	      System.out.println(e.getMessage());
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	
	    return new ResponseEntity<>(HttpStatus.OK);
	  } // method uploadFile
	@RequestMapping(value="/ImportationAdminExcel")
	public void treatDocument(@RequestParam(name="mc",defaultValue="")String documentPath) {
		

		if (documentPath != null) {
			try {
//"D:/PFE-2018/base-Ahlem10avril.xlsx"
				//PreparedStatement pstm = null;
				FileInputStream inputStream = new FileInputStream(new File(documentPath));
				XSSFWorkbook fs = new XSSFWorkbook(inputStream);
				XSSFSheet sheet = (XSSFSheet) fs.getSheetAt(0);
				Row row;
				 Iterator<Row> rowIterator = sheet.iterator();
				 //row = sheet.getRow(4);
				// while (rowIterator.hasNext()) {
				for (int i = 7; i < sheet.getLastRowNum(); i++) {
					row = sheet.getRow(i);
					while(row==null)
					{
						i=i+1;
						row=sheet.getRow(i);
					}
					Cell cell = row.getCell(4);
				
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						matricule =String.valueOf(cell.getNumericCellValue());
					} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						matricule=cell.getStringCellValue();
					}
					System.out.println(matricule+" Matricule \t");
					String nomprenom="";
					if (row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC) {
						nomprenom = String.valueOf(row.getCell(3).getNumericCellValue());
					}
					else if (row.getCell(3).getCellType() == Cell.CELL_TYPE_STRING)
					{
						nomprenom  = row.getCell(3).getStringCellValue();
					}
					/*if (row.getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC) 
					{
					nomAr = String.valueOf(row.getCell(2).getStringCellValue());
					}
					else if (row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING) {
						nomAr = row.getCell(2).getStringCellValue();	
					}*/
					prenomAr=nomprenom.substring(0,nomprenom.indexOf(" "));
					nomAr=nomprenom.substring(nomprenom.indexOf(" ")+1);
		
					
					//specialite=new Specialite();
					//System.out.println(row.getCell(6).getStringCellValue());
					/*specialite=specialiteRepo.chercherOneAr(spec);
					if(specialite==null)
					{
						specialite=new Specialite();
						specialite.setLibelleSpAr(spec);
						specialite=specialiteRepo.save(specialite);
					}*/
					/*departement=departementRepo.chercherOneAr(spec);
					if(departement==null)
					{
						departement=new Departement();
						departement.setNomDepAr(spec);
						departement=departementRepo.save(departement);
					}*/
					String spec="";
					cell=row.getCell(2);
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						spec=String.valueOf(cell.getStringCellValue());
					}
					else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						spec=cell.getStringCellValue();
					}
					grade=gradeRepo.chercherOneAr(spec);
					if(grade==null)
					{ Corps corp=corpsRepo.findOne((long) 2);
						grade=new Grade();
						grade.setTitreAr(spec);
						grade.corps=corp;
						grade=gradeRepo.save(grade);
					}
					cell=row.getCell(1);
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						spec=String.valueOf(cell.getStringCellValue());
					}
					else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						spec=cell.getStringCellValue();
					}
					poste=posteRepo.chercherOneAr(spec);
					if(poste==null)
					{ 
						poste=new PosteAdministrative();
						poste.setLibellePosAr(spec);
						posteRepo.save(poste);
					
					}
	
					cell=row.getCell(0);
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						spec=String.valueOf(cell.getStringCellValue());
					}
					else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						spec=cell.getStringCellValue();
					}
					etat=etatRepo.chercherOneAr(spec);
					if(etat==null)
					{
						etat=new Etat();
						etat.setIdEtat(i);
						etat.setLibelleEtatAr(spec);
						etat=etatRepo.save(etat);
					}
					if (etat.getLibelleEtatAr().equals("غير مباشر")) {
						etatpersonnel=new EtatPersonnel();
						etatpersonnel.setEtatInactiveAr(row.getCell(16).getStringCellValue());
					}
				System.out.println(cin);
				enp=new Administratif();
					enp.setCin(cin);
					enp.setMatricule(matricule);
					enp.setPrenomAr(prenomAr);
					enp.setNomAr(nomAr);
					//enp.setSexeAr(sexeAr);
					//enp.setSpecialite(specialite);
					enp.setGradeActuelAr(grade.getTitreAr());
					//enp.setDatenaissance(dateNais);
					//enp.setLieuNaissanceAr(lieuNaisAr);
					//enp.setDepartement(departement);
					enp.setEtat(etat);
					//enp.setTelephone(telephone);
					enp=enpRepo.save(enp);
					if(grade!=null)
					{
						agrade=new AGrade();
						agrade.setGrade(grade);
						agrade.setPersonnel(enp);
						agrade.setDateEvaluation(new Date());
						agrade.setGradeActuel(true);
						agradeRepo.save(agrade);
					}
					if(poste!=null)
					{
						periode=new Periode();
						periode.setDateDebut(new Date());
						periode.setDateFin(new Date());
						periode.setPosteAdmin(poste);
						periode.setPersonnel(enp);
						periodeRepo.save(periode);
					}
					if(etatpersonnel!=null)
					{
						etatpersonnel.setEtat(etat);
						etatpersonnel.setPersonnel(enp);
						etatpersRepo.save(etatpersonnel);
						
					}
					System.out.println(matricule+" cin \t");
					System.out.println(prenomAr+" prenom \t");
					System.out.println(nomAr+" nom \t");
				   // row = rowIterator.next();
				}


				System.out.println("Success import excel to mysql table");
			} catch (IOException ioe) {
				System.out.println(ioe);

		}
	}
}
}