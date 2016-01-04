package net.francais.mashi.utils;

import java.util.Calendar;
import java.util.Date;

public class Utils {
	
	 public static Date createDate(int day, int month, int year){
    	Calendar cal = Calendar.getInstance();
    	cal.set(year, month-1, day);
    	return cal.getTime();
	 }
}
