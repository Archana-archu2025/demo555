package com.comcast.crm.generic.fileutiity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyfileutility {
	public String getdatafromthepropertyfile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\Testdata\\browser firefox.properties");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
	
		return data;
	}
}
