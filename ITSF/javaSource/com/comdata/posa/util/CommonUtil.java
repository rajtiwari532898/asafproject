/**
 * 
 */
package com.comdata.posa.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.tcs.dvt.constant.DvtConstants;


/**
 * @author 195964
 *
 */
public  final class CommonUtil {
	private CommonUtil(){
		//do nothing
	}
	
	private static final Logger M_LOGGER = Logger.getLogger(CommonUtil.class);
	public static final Long MS_FACTOR = 24L * 60L * 60L * 1000L;	
	private final static Double AVERAGE_MILLIS_PER_MONTH = 365.24 * 24 * 60 * 60 * 1000 / 12;
	public static final String CONF_FILE = "posa.properties";
	
	public static Long getNoOfDays(Date startDate, Date endDate) {
		return (endDate.getTime() - startDate.getTime()) / MS_FACTOR;
	}
	
	public static double monthsBetween(Date d1, Date d2) {   
	    return (d2.getTime() - d1.getTime()) / AVERAGE_MILLIS_PER_MONTH;    
	} 
	
	public static String changeDateFormatToMMDDYYYY(Date date) {	
		DateFormat dateFormat = new SimpleDateFormat(DvtConstants.MM_DD_YYYY_DATE_FORMAT,Locale.getDefault());
		String formattedDate = "";
		if (date != null) {
			try {
				formattedDate = dateFormat.format(date);
			} catch (Exception e) {
				M_LOGGER.error("Error in changeDateFormatToMMDDYYYY:", e);
			}
		}
		return formattedDate;
	}
	public static Calendar changeDateFormatToCalender(String dateInp){
		Calendar cal=null;
		String pattern = DvtConstants.MM_DD_YYYY_DATE_FORMAT;
	    SimpleDateFormat format = new SimpleDateFormat(pattern,Locale.getDefault());
	    try {
	      Date date = format.parse(dateInp);
	      cal=Calendar.getInstance();
		  cal.setTime(date);
	    } catch (ParseException e) {
	    	M_LOGGER.error("Erron in CommonUtil.ChangeDateFormatToCalender : "+e.getMessage());
	    }			
		return cal;
		
	}
	public static Calendar changeDateToCalender(Date dateInp){
		Calendar cal=null;
		try {	      
		      cal=Calendar.getInstance();
			  cal.setTime(dateInp);
		 } catch (Exception e) {
			 M_LOGGER.error("Erron in CommonUtil.ChangeDateToCalender : "+e.getMessage());
	    }			
		return cal;		
	}
	/**
	 * @author TCS This method changes Date Format 
	 * @param Date
	 * @return Date
	 */
	public static Date changeDateFormatDt(Date tempDate){
		Date temp = null;
		SimpleDateFormat formatter=  new SimpleDateFormat(DvtConstants.MM_DD_YYYY_DATE_FORMAT,Locale.getDefault());
		String dateNow = formatter.format(tempDate);
		try {
			temp =  formatter.parse(dateNow);

		} catch (java.text.ParseException e) {
			M_LOGGER.error("Error in parsing date", e);
		}
		return temp;
	}
	/**
	* This utility method returns a past date before number of days.
	* @param days
	* @return
	*/
	public static Date getDateBeforeDays(int days) {
		long backDateMS = System.currentTimeMillis() - ((long)days) *24*60*60*1000;
		Date backDate = new Date();
		backDate.setTime(backDateMS);
		return backDate;
	}
	/**  
	* This utility method returns a future date after number of days.  
	* @param days  
	* @return  
	*/  
	public static Date getDateAfterDays(int days) {   
		long backDateMS = System.currentTimeMillis() + ((long)days) *24*60*60*1000;   
		Date backDate = new Date();   
		backDate.setTime(backDateMS);   
		return backDate;   
	}    
 
	public static String changeDateFormatToYyyyMmDd(Date date) {
	//	Date testDate = null;
		//SimpleDateFormat utilFormat = new SimpleDateFormat(Resources.SIMPLE_DATE_FORMAT);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy",Locale.getDefault());
		String formattedDate = "";
		if (date != null) {
			try {
				formattedDate = dateFormat.format(date);
			} catch (Exception e) {
				M_LOGGER.error("Error in changeDateFormatToYyyyMmDd:", e);
			}
		}
			return formattedDate;
	}
	public static String readFileAsString(File file)
    throws java.io.IOException{
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader=null;
        try{
        		reader = new BufferedReader(
                new FileReader(file));
		        char[] buf = new char[1024];
		        int numRead=0;
		        while((numRead=reader.read(buf)) != -1){
		            String readData = String.valueOf(buf, 0, numRead);
		            fileData.append(readData);
		            buf = new char[1024];
		        	}			        
        }catch(IOException ex){
        	M_LOGGER.debug("Exception in CommonUtil : " +ex.getMessage());
        	throw ex;
        }finally{
        	reader.close();
        }
        return fileData.toString();
    }
/**
 * This utility method returns property from the Properties File for a given key
 * @param filename  
 * @return  property
 */
	public static String getProperty(String fileName){
		String strPath="";	
		ResourceBundle rb= ResourceBundle.getBundle("DVT");		
		String strMatchFile=DvtConstants.FAQ_FILE_NAME+","+DvtConstants.TERMS_FILE_NAME+","+DvtConstants.PRIVACY_FILE_NAME+","+
		DvtConstants.CONTACT_US_FILE+","+DvtConstants.LOST_CARD+","+DvtConstants.DISPUTE_TRAN+","+DvtConstants.OPEN_WAY_URL;
		try{				
			if((strMatchFile.indexOf(fileName.trim()))!=-1){
				rb= ResourceBundle.getBundle("PosaLinks");					
			}
			strPath=rb.getString(fileName.trim());
		 }catch(Exception e){
			 M_LOGGER.debug("Required Property for"+fileName+"is not Found :: "+e.getMessage());			
		}		
		return strPath;	
	}	
	
	/**
	 * Check the phone no
	 * of pattern (123)456-7890, 123-456-7890,(123)-456-7890 
	 * else format the phone no
	 */
	public static String validatePhone(String phNo){
	 	Pattern p = Pattern.compile("^\\(?(\\d{3})\\)?[-\\s]?(\\d{3})[-\\s](\\d{4})$"); 
		Matcher m = p.matcher(phNo);
		String phone=null;
		boolean matchFound = m.matches();
		if(matchFound)
			return phNo;
		else{
			phone=phNo.substring(0, 3)+"-"+phNo.substring(3,6)+"-"+phNo.substring(6);
			return phone;		
			}
	}
	
}

