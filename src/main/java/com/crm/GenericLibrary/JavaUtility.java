package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method will generate random number and return it to user
	 * @author Rafeek
	 * @return
	 */
	public int getRandomNumber() {
		Random r=new Random();
		int random = r.nextInt();
		return random;
		
	}
	/**
	 * This method will return current system date and return it to user
	 * @author Rafeek
	 * @return
	 */
	public String getSystemDate() {
		Date d=new Date();
		String date = d.toString();
		return date;
	}
	/**
	 * this method will generate system data and return data in format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d=new Date();
		String d1 = d.toString();
		String[] date = d1.split(" ");
		String mon = date[1];
		String day = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		String DateFormate = day+" "+mon+" "+year+" "+time;
		return DateFormate;
	}
}
