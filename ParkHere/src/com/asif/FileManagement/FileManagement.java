package com.asif.FileManagement;

import java.io.File;
import java.io.IOException;

public class FileManagement {

	public File DataLocation;

	public File FindRoot(String Vno) 
	{
		File [] GetRoots=File.listRoots();
		File Root;
		
		if(GetRoots.length>1)
		{
			Root=GetRoots[1];
		}
		else 
		{
			Root=GetRoots[0];
		}

		return DataLocation(Root,Vno);
		
		
	}
	
	public File DataLocation(File Root, String Vno)
	{
		DataLocation=new File(Root,"ParkHere\\data");
		if(!DataLocation.exists())
		{
			DataLocation.mkdirs();
		}
		return CreateFile(Vno);
		
	}
	
	public File CreateFile(String Vno) {
	String Receiptpath=DataLocation+"\\"+Vno+".txt";
	File ReceiptData=new File(Receiptpath);
	try {
		ReceiptData.createNewFile();
	} catch (IOException e) {
		System.out.print("Unable to create TextFile");
	}
	return ReceiptData;
}
	
}
