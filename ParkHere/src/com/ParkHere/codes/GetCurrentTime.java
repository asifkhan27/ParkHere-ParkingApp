package com.ParkHere.codes;

import java.util.Calendar;


public class GetCurrentTime {
public String gettime() {
	Calendar c=Calendar.getInstance();
	
	StringBuffer time=new StringBuffer();
	time.append(c.get(Calendar.YEAR));
	time.append("-");
	time.append(c.get(Calendar.MONTH)+1);
	time.append("-");
	time.append(c.get(Calendar.DATE));
	time.append("-");
	
	if(c.get(Calendar.HOUR_OF_DAY)==0) {
		time.append(24);
	}else {
		time.append(c.get(Calendar.HOUR_OF_DAY));
	}
		
	time.append("-");
	time.append(c.get(Calendar.MINUTE));
	return time.toString();
	
	
}
public float  HourBetweenTwoTimeStamp(String Time) {
	
	Calendar c=Calendar.getInstance();
	int YEAR=c.get(Calendar.YEAR);
	int MONTH=c.get(Calendar.MONTH)+1;
	int DATE=c.get(Calendar.DATE);
	int HOUR;
	if(c.get(Calendar.HOUR_OF_DAY)==0) {
		HOUR=24;
	}else {
		HOUR=c.get(Calendar.HOUR_OF_DAY);
	}
	float MINUTE=c.get(Calendar.MINUTE);
	float totalHour;
	float totalMin;
	
	String [] time=Time.split("-");
	
	YEAR=YEAR-Integer.parseInt(time[0]);
	YEAR=Math.abs(YEAR);
	
	MONTH=MONTH-Integer.parseInt(time[1]);
	MONTH=Math.abs(MONTH);
	
	DATE=DATE-Integer.parseInt(time[2]);
	DATE=Math.abs(DATE);

	
	HOUR=HOUR-Integer.parseInt(time[3]);
	HOUR=Math.abs(HOUR);

	
	MINUTE=MINUTE-Integer.parseInt(time[4]);
	MINUTE=Math.abs(MINUTE);
	
	totalHour=YEAR*365*24+MONTH*30*24+DATE*24+HOUR;
	totalMin=MINUTE/60;
	totalHour=totalHour+totalMin;
			
	return totalHour;
	
}

}
