package com.ParkHere.codes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.asif.database.interactionJDBC;


public class Receipt {
	private int Parkingcost;
	private String VehicleType;
	private float TotalHour;
	private float TotalCost;
	
	public List<String> getCost(String Vno) {
		
		ArrayList<String> value=new ArrayList<String>();
		try {
			
			Collections.addAll(value,new interactionJDBC().getsvalue(Vno));

			switch(value.get(2)) {
			
			case "SUV":  
				VehicleType="SuvCost";
					break;
			case "Hatchback":
				VehicleType="HatchbackCost";
				break;
			case "Sedan":
				VehicleType="SedanCost";
				break;
			case "BIKE":
				VehicleType="BIKECost";
				break;
			}
			Parkingcost=Integer.parseInt(new GetDataFromProperties().get(VehicleType));
			TotalHour=new GetCurrentTime().HourBetweenTwoTimeStamp(value.get(5));
			TotalCost=Parkingcost*TotalHour;
			
			
			value.add(new GetCurrentTime().gettime());
			value.add(String.valueOf(Math.round(TotalHour * 100.0) / 100.0));
			value.add(String.valueOf(Math.round(TotalCost * 100.0) / 100.0));

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	

}
