package com.loyaltyservice.utill;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ToolBox {

	private ToolBox() {

	}
	
	private final static Pattern ALFA_NUMERIC = Pattern.compile("^[a-zA-Z0-9 -]+$");

	public static boolean isAlfaNumeric(String str) {
		if (str == null) {
			return false;
		}
		return ALFA_NUMERIC.matcher(str).matches();
	}

	private final static Pattern SPECIAL_CHAR =
			// Pattern.compile("^[a-zA-Z0-9/*@!^$# %&*(){}\\[\\],.;:\\\".*\\\"]+$");
			Pattern.compile("^[a-zA-Z0-9, $-]+$");

	public static boolean isAllowSpecialChar(String str) {
		if (str == null) {
			return false;
		}
		return SPECIAL_CHAR.matcher(str).matches();
	}

	public static String tojsonString(Object o) throws JsonProcessingException {
		ObjectMapper map = new ObjectMapper();
		String s = map.writeValueAsString(o);
		return s;
	}

	public static int sizeOfCollection(Collection collection) {
		if (isEmptyCollection(collection))
			return 0;
		else
			return collection.size();

	}

	public static <T> boolean isEmptyCollection(Collection<T> obj) {
		return null == obj || obj.isEmpty();
	}

	public static <T, V> boolean isEmptyCollection(Map<T, V> obj) {
		return null == obj || obj.isEmpty();
	}

	public static boolean isEmptyObject(Object obj) {
		return null == obj || obj.toString().trim().isEmpty();
	}

	public static boolean isEmptyString(String str) {
		boolean status = false;
		if (str == null || str.trim().isEmpty() || str.trim().equalsIgnoreCase("null")) {
			return true;
		}
		return status;
	}

	public static boolean isNullString(String str) {
		boolean status = false;
		if (str == null) {
			return true;
		}
		return status;
	}

	public static boolean isEmptyArrObj(Object[] Arr) {
		Object[] array = (Object[]) Arr;
		return array.length <= 0;
	}

	public static String getDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return dateFormat.format(date);
	}

	public static String getStringAfterTrim(String string) {
		if (string != null && !"".equalsIgnoreCase(string.trim()) && !"null".equalsIgnoreCase(string)) {
			return string.trim();
		}
		return string;
	}

	public final static Pattern CHARACTER = Pattern.compile(".*[a-zA-Z].*");
	public final static Pattern NUMERIC = Pattern.compile("^[0-9]+$");

	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		return NUMERIC.matcher(str).matches();
	}

	public static String generateRandomNumber(long len) {
		long tLen = (long) Math.pow(10, len - 1) * 9;

		long number = (long) (Math.random() * tLen) + (long) Math.pow(10, len - 1) * 1;

		String tVal = number + "";
		if (tVal.length() != len) {
			throw new IllegalStateException("The random number '" + tVal + "' is not '" + len + "' digits");
		}
		return tVal;
	}

	public static Date getCurrentDate() {
		return new Date();
	}

	public static boolean validatePattern(String name, String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(name.trim());
		return matcher.matches();
	}

	public static boolean isYearRegex(String str) {
		return str.matches("^(?:36[0-5]|3[0-5]\\d|[12]\\d{2}|[1-9]\\d?)$");
	}

	public static boolean isNaturalnumberRegex(String str) {
		return str.matches("^[1-5]+$");
	}

	public static boolean validateSize(String name, String length) {
		if (name.length() <= Integer.parseInt(length))
			return true;
		else
			return false;
	}

	// Validating id Matcher
	public boolean validateIdChecker(String id) {

		final String NUMERIC_PATTERN = "([1-9]|[1-9][0-9]|[1-9][0-9][0-9]|1000)";
		Pattern pattern = Pattern.compile(NUMERIC_PATTERN);
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}

	// Validating name Matcher
	public boolean validateNameChecker(String name) {

		final String NAME_PATTERN = name.replaceAll("\\p{Zs}+", " ");
		Pattern pattern = Pattern.compile(NAME_PATTERN);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	// Validating multiple id Matcher
	public boolean validateIdsChecker(String partnerIds) {
		
		Pattern pattern = null;
		Matcher matcher = null;
		final String NUMERIC_PATTERN = "([1-9]|[1-9][0-9]|[1-9][0-9][0-9]|1000)";
		String[] partnerList = partnerIds.split(",");
		
		for (String partner: partnerList) {
			pattern = Pattern.compile(NUMERIC_PATTERN);
			matcher = pattern.matcher(partner);
			if(!partner.matches(NUMERIC_PATTERN)) {
				return matcher.matches();
			}
		}
		
		return matcher.matches();
	}

}
