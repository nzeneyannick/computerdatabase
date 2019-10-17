package com.excilys.cdb.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.excilys.cdb.dto.CompanyDto;
import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Company;
import com.excilys.cdb.service.impl.CompanyService;
import com.excilys.cdb.service.impl.ComputerService;
import com.excilys.cdb.validateur.ValidateurFront;


@Component
@SuppressWarnings("serial")
@WebServlet("/addComputer")
public class AddComputer extends HttpServlet {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ComputerService computerService;
	
    private ValidateurFront validateur = new ValidateurFront();
    public static final String VUE = "/views/addComputer.jsp";

    public static final String CHAMP_NAME_COMPUTER = "name";
    public static final String CHAMP_INTRODUCED = "introduced";
    public static final String CHAMP_DISCONTINUED = "discontinued";
    public static final String CHAMP_NAME_COMPANY = "nameCompany";
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();
    
	 @Override
	  public void init(
	      ServletConfig config) throws ServletException {
	    super.init(config);
	    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	  }

    public void setErreurs(String  key, String value) {
        erreurs.put(key, value);
    }
    

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Company> listComp = companyService.getListCompany();
        request.setAttribute("listCompany", listComp);
        request.getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
        List<Company> listComp = companyService.getListCompany();

        Set<Company> listCompany = new HashSet<Company>(listComp);

        request.setAttribute("listCompany", listCompany);

        String nameComputer = "";
        String introduced = "";
        String discontinued = "";
        String nameCompany = "";

        nameComputer = request.getParameter(CHAMP_NAME_COMPUTER);
        introduced = request.getParameter(CHAMP_INTRODUCED);
        discontinued = request.getParameter(CHAMP_DISCONTINUED);
        nameCompany = request.getParameter(CHAMP_NAME_COMPANY);
        
     

        boolean erreur;

        
            try {
                validateur.checkDateOrName(nameComputer);
            } catch (Exception e) {
                setErreurs(CHAMP_NAME_COMPUTER,e.getMessage() );
                
            }
            try {
                validateur.checkDateOrName(introduced);
            } catch (Exception e) {
                setErreurs(CHAMP_INTRODUCED,e.getMessage() );
            }
            try {
                validateur.checkDateOrName(discontinued);
            } catch (Exception e) {
                setErreurs(CHAMP_DISCONTINUED,e.getMessage() );
            }
            try {
                validateur.checkDateOrName(nameCompany);
            } catch (Exception e) {
                setErreurs(CHAMP_NAME_COMPANY,e.getMessage() );
            }
            
            if (erreurs.isEmpty()) {

                try {
                    validateur.isValidRange(introduced, discontinued);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Company company = companyService.findCompanyByName(nameCompany);

                CompanyDto companyDto = new CompanyDto();
                companyDto.setIdDto(company.getId());
                companyDto.setNameDto(company.getName());
                ComputerDto computerDto = new ComputerDto();
                computerDto.setNameDto(nameComputer);
                computerDto.setIntroducedDto(introduced);
                computerDto.setDiscontinuedDto(discontinued);
                computerDto.setCompanyDto(companyDto);

               
                computerService.createComputer(computerDto);
        	
                resultat = "Computer créé avec succès";
                erreur = false;
               
                request.setAttribute("computerDto", computerDto);
            }
            else {
                resultat = "echec de la création du Computer";
                erreur = true;
            }

        request.setAttribute("erreur", erreur);
        request.setAttribute("message", resultat);       
        request.getRequestDispatcher(VUE).forward(request, response);

    }

}