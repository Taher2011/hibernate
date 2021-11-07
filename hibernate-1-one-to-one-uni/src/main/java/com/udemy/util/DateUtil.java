package com.udemy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	// The date formatter
	// - dd: day in month (number)
	// - MM: month in year (number)
	// - yyyy: year
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	// read a date string and parse/convert to a date
	public static Date parseDate(String dateStr) throws ParseException {
		Date date = formatter.parse(dateStr);
		return date;
	}

	// read a date and format/convert to a string
	public static String formatDate(Date date) {
		String result = null;
		if (date != null) {
			result = formatter.format(date);
		}
		return result;
	}

}
