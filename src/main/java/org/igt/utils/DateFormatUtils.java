package org.igt.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatUtils {
	
	private DateFormatUtils() {}

	private static String pattern = "yyyy-MM-dd'T'HH:mm:ss-SSSSZ";
	private static final String LOCALDATETIME = "Asia/India";

	public static String yyyyMmDdFormat() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		return smpldtfrmt.format(new Date());
	}

	public static String departuredateFormat() {
		String pattern = "ddMMyy:HHmm";
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		Date date = calendar.getTime();
		return smpldtfrmt.format(date);
	}

	public static String arrivaldateFormat() {
		String pattern = "ddMMyy:HHmm";
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		calendar.add(Calendar.HOUR, 6);
		Date date = calendar.getTime();
		return smpldtfrmt.format(date);
	}

	public static String currentDateTime() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern, Locale.UK);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(LOCALDATETIME));
		String date = smpldtfrmt.format(new Date());
		return date.substring(0, 24);
	}

	public static String plusOneHourFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(LOCALDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() + 3600000));
		return date.substring(0, 20).concat("0500");
	}

	public static String minusOneHourFormat() {
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(LOCALDATETIME));
		String date = smpldtfrmt.format(new Date(System.currentTimeMillis() - 3600000));
		return date.substring(0, 20).concat("0500");
	}

}
