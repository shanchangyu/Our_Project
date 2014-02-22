/**
 * 
 */
package com.thosepeople.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenzhuo
 * 
 */
public class DateUtils {
	private static final String YMD_FORMAT = "yyyy-MM-dd";

	public static Date getDateOfYMDFormat(String time) {
		SimpleDateFormat format = new SimpleDateFormat(YMD_FORMAT);
		try {
			return format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
