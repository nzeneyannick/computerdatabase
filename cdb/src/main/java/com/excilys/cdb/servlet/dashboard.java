package com.excilys.cdb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.excilys.cdb.entities.Computer;
import com.excilys.cdb.service.impl.ComputerService;

@Component
@WebServlet("/dashboard")
public class dashboard extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String CHAMP_NAME_COMPUTER = "search";
	public static final String ID_COMPUTER = "selection";
	public static final String VUE = "/views/dashboard.jsp";

	@Autowired
	private ComputerService computerService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Transactional
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer = computerService.getListComputer();
		int sumComputer = listComputer.size();
		request.setAttribute("listComputer", listComputer);
		request.setAttribute("sumComputer", sumComputer);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nameComputerSearch = "";
		nameComputerSearch = request.getParameter(CHAMP_NAME_COMPUTER);
		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer = computerService.findByName(nameComputerSearch);
		int sumComputer = listComputer.size();

		request.setAttribute("listComputer", listComputer);
		request.setAttribute("sumComputer", sumComputer);
		request.getRequestDispatcher(VUE).forward(request, response);

		String[] idComputer;
		idComputer = request.getParameterValues(ID_COMPUTER);
		String[] tabId = idComputer[0].split(",");
		if (idComputer.length != 0) {

			for (int i = 0; i < tabId.length; i++) {

				int idCompt = Integer.valueOf(tabId[i]);
				computerService.deleteComputer(idCompt);
			}
		}
		doGet(request, response);

	}

}
