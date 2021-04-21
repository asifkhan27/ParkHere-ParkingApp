package com.ParkHere.SendMail;

public class interactionEmail extends SendEmail{
	
	private String subject;
	private String body;
	
	public boolean mailReceipt(String email,String Vno,String Pslot,String EntryTime,String ExitTime,String Wheel,String Type,String Phno,String ParkingTime,String TotalCost)
	{
		
		
		subject="Thank You For Visiting!";
		body=" \r\n" + 
				"Hello \r\n" + 
				"Thankyou for choosing us and park at Parkhere \r\n" + 
				"Hope you enjoy our service. \r\n" + 
				"For any clarifications or to know more about ParkHere, please contact us on parkhere73@gmail.com, and a relationship manager will be glad to assist you. " + 
				" \r\n" + 
				"Regards,\r\n" + 
				"ParkHere Admin.\r\n" + 
				"The ParkHere Team.\r\n" + 
				
				"\r\r\rVehicle no. "+Vno+"\r"+"Parking Slot. "+Pslot+"\r"+"Entry Time. "+EntryTime+"\r"+"Exit Time. "+ExitTime+"\r"+"Wheel. "+Wheel+"\r"+"Type. "+Type+"\r"+"Ph.no. "+Phno
				+"\r\n\r\r\r\r\r"+"Parking Time(In hrs) : "+ParkingTime+"\r\r"+"Total Cost : Rs. "+TotalCost;
	return start(email,subject,body);
		}
	
	

}

