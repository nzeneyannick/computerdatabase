package com.excilys.validateur;



public class ValidateurBack {

	public void isValidRange(String start, String end) throws Exception {

		boolean result = false;
		result = end.compareTo(start) >= 0;
		System.out.println(result);

		if (result == false) {

			throw new Exception("La date discontinued doit etre supérieur à la date continued");
		}

	}

	public void checkDateOrName(String value) throws Exception {

		if ("null".equals(value) || value.isEmpty()) {

			throw new Exception("Veuillez remplir les champs name et date");
		}
		

	}

	public void checkId(Integer val) throws Exception {

		if (val == null || val == 0) {
			throw new Exception("Veuillez rentrer une valeur non nulle");

		}
	}

	public void checkName(String name) throws Exception {
		if ("null".equals(name) || name.isEmpty()) {
			throw new Exception("Veuillez rentrer le nom ");
		}
	}

}
