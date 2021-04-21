package com.ParkHere.codes;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GetAbsoluteDate {

	public String getMonth(String Month){
		
			String str="";
			SimpleDateFormat monthParse = new SimpleDateFormat("MM");
			    SimpleDateFormat monthDisplay = new SimpleDateFormat("MMMM");
			try {
				 str = monthDisplay.format(monthParse.parse(Month));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return str;

	}
	
	public String ProperDate(String Time) {
		
		String[] time=Time.split("-");
		String ProperTime=time[2]+" "+new GetAbsoluteDate().getMonth(time[1])+","+time[0]+" ["+time[3]+":"+time[4]+"]";
		return ProperTime;
		
	}

}

