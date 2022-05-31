package com.salesforce.utility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Commonutilities {
	
	public static String getpropertyvalue(String key) throws IOException
	{
		Properties prop =new Properties();
		String path= Constants.PROPERTIES_PATH;
		FileInputStream fr= new FileInputStream(path);
		 try {
			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 String value=prop.getProperty(key); //get values from  properties files
		 System.out.println("value from the file"+value);
		
			fr.close();
		
		
		 return value;
		
	}

	
}

