package com.rif.juntadas.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {

	public static SimpleDateFormat shortDate = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String shortDate(Date date) {
		return (date != null)? shortDate.format(date): "";
	}
}
