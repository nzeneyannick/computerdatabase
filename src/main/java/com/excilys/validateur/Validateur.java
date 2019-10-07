package com.excilys.validateur;

import com.excilys.mapper.ComputerMapper;

public class Validateur {
	
	ComputerMapper computerMapper = new ComputerMapper();

	public void isValidRange(String start, String end) throws Exception {
		
		
		boolean result = false;
		result = end.compareTo(start)>=0;
		System.out.println(result);

		if (result == false) {

			throw new Exception("La date discontinued doit etre supérieur à la date continued");
		}
		
	}

	public void checkDateOrName(String value) throws Exception {

		if ("null".equals(value) && value.isEmpty()) {

			throw new Exception("Veuillez remplir les champs");
		}

	}
	
	public void checkId(Integer val) throws Exception{
		
		if (val == null || val ==0) {
			throw new Exception("Veuillez rentrer une valeur non nulle");
			
		}
	}
	


}
