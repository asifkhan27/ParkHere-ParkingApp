package com.asif.FileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateReceipt {
	private File location;
	
	public CreateReceipt(File Loc) {
		this.location=Loc;
	}
	
	public void writeIntoReceipt(String Vno,String Pslot,String EntryTime,String ExitTime,String Wheel,String Type,String Phno,String ParkingTime,String TotalCost) {
		
		String body="Vehicle no. "+Vno+"\r"+"Parking Slot. "+Pslot+"\r"+"Entry Time. "+EntryTime+"\r"+"Exit Time. "+ExitTime+"\r"+"Wheel. "+Wheel+"\r"+"Type. "+Type+"\r"+"Ph.no. "+Phno
				+"\r\n\r\r\r\r\r"+"Parking Time(In hrs) : "+ParkingTime+"\r\r"+"Total Cost : Rs. "+TotalCost;

		byte [] b=body.getBytes();
		try {
			FileOutputStream fos=new FileOutputStream(location);
			fos.write(b);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
