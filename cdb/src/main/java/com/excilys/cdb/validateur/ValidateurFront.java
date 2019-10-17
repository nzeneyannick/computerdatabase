package com.excilys.cdb.validateur;


public class ValidateurFront {

	public void isValidRange(String start, String end) throws Exception {

		boolean result = false;
		result = end.compareTo(start) >= 0;
		System.out.println(result);

		if (result == false) {

			throw new Exception("La date discontinued doit etre supérieur à la date continued");
		}

	}

	public void checkDateOrName(String  value) throws Exception {

		if (value == null || value.isEmpty() || value.length()==0) {

			throw new Exception("Veuillez remplir les champs");
		}	

	}
	
	}




