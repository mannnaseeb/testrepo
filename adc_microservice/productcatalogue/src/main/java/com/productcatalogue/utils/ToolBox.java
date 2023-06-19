package com.productcatalogue.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class ToolBox {

	private ToolBox() {

	}

	// Validating id Matcher
	public boolean validateIdChecker(Long id) {

		String idStr = String.valueOf(id);
		final String NUMERIC_PATTERN = "([1-9]|[1-9][0-9]|[1-9][0-9][0-9]|1000)";
		Pattern pattern = Pattern.compile(NUMERIC_PATTERN);
		Matcher matcher = pattern.matcher(idStr);
		return matcher.matches();
	}

	// Validating name Matcher
	public boolean validateNameChecker(String Name) {

		String pattern = "^^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*";
		System.out.println("");
		System.out.println("alphaNumericRegexWithSpace");
		System.out.println(Name.matches(pattern));
		System.out.println("");
		return Name.matches(pattern);
	}

	// Validating company name Matcher
	public boolean validateCompanyNameChecker(String Name) {

		String pattern = "^[a-zA-Z0-9-_ ]+$";
		System.out.println("");
		System.out.println("alphaNumericRegexWithSpace");
		System.out.println(Name.matches(pattern));
		System.out.println("");
		return Name.matches(pattern);
	}

	// Validating multiple id Matcher
	public boolean validateIdsChecker(String partnerIds) {

		Pattern pattern = null;
		Matcher matcher = null;
		final String NUMERIC_PATTERN = "([1-9]|[1-9][0-9]|[1-9][0-9][0-9]|1000)";
		String[] partnerList = partnerIds.split(",");

		for (String partner : partnerList) {
			pattern = Pattern.compile(NUMERIC_PATTERN);
			matcher = pattern.matcher(partner);
			if (!partner.matches(NUMERIC_PATTERN)) {
				return matcher.matches();
			}
		}

		return matcher.matches();
	}

}
