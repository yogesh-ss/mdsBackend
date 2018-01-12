package com.mds.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ProductProfileUtil {
	
	public static int getRandomNumber() {
		return (new Random()).nextInt(90000000) + 10000000;
	}
	
	public static Timestamp getcurrentDate() {
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		  Date currentDate = new Date();
			try {
				return new Timestamp(sdf.parse(sdf.format(currentDate)).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Timestamp(currentDate.getTime());
	}
	
	public static String getCurrentTimeSatmpAsString() {
		return new Timestamp(new Date().getTime()).toString();
	}
}
