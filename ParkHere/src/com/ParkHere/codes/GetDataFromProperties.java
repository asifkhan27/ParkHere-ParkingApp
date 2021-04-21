package com.ParkHere.codes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetDataFromProperties {
	public String get(String name) {
		

			Properties prop = new Properties();
			InputStream input = null;
			try {
			    input = ClassLoader.getSystemClassLoader().getResourceAsStream("ParkingData.properties");
			    prop.load(input);
			 
			} catch (IOException io) {
			    io.printStackTrace();
			}
			return prop.getProperty(name);
		}

/*public void set(String name,int value) {
	
	Properties prop = new Properties();
	InputStream input = null;
	try {
	    input = ClassLoader.getSystemClassLoader().getResourceAsStream("ParkingData.properties");
	    prop.load(input);
	    
	    prop.setProperty(name,value+"");

	} catch (IOException io) {
	    io.printStackTrace();
	}
}*/
	

}
