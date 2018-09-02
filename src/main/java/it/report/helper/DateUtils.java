package it.report.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
    public static String dayName(String inputDate){
        Date date = null;
        try {
            date = new SimpleDateFormat("MM-dd-yyyy").parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
    }
    
    public static String dateToString (Date imputDate){
    	DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
    	String reportDate = df.format(imputDate);
		return reportDate;
    }
    
    public static Date stringToDate (String inputString){
    	
    	Date date = null;
    	DateFormat format = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
    	try {
			date = format.parse(inputString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return date;
    }
    
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
    
    public static Date getNextWorkingDay (Date instructionDate, String currency){
    	 Date settlementDate = null;
    	 String instructionDay = dayName(dateToString(instructionDate));
    	 
    	 if (currency.equalsIgnoreCase("AED")||currency.equalsIgnoreCase("SAR")){
    		 if (instructionDay.equalsIgnoreCase("Thursday")){
    			 settlementDate = addDays(instructionDate,3);
    		 }
    		 else if (instructionDay.equalsIgnoreCase("Friday")){
    			 settlementDate = addDays(instructionDate,2);
    		 }
    		 else 
    			 settlementDate = addDays(instructionDate,1);
    	 }
    	 else {

    		 if (instructionDay.equalsIgnoreCase("Friday")){
    			 settlementDate = addDays(instructionDate,3);
    		 }
    		 else if (instructionDay.equalsIgnoreCase("Saturday")){
    			 settlementDate = addDays(instructionDate,2);
    		 }
    		 else {
    			 settlementDate = addDays(instructionDate,1);
    		 }
    	 }
    	 return settlementDate;
    	
    }
    
}



