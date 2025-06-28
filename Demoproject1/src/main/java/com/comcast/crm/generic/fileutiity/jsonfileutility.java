package com.comcast.crm.generic.fileutiity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonfileutility {
    
	public Object getdatafromjsonfile(String key) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parse=new JSONParser();
		Object obj = parse.parse(new FileReader("./Testdata/testjsondata.json"));
		JSONObject map=(JSONObject) obj;
		Object data = map.get(key);
		
		return data;
	}
}
