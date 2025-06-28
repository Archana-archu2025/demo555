package com.comcast.crm.generic.webdriverutility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Pattern;


public class javautility {

	 public int createrandomnumber() {
		 Random r=new Random();
		 int randomnum = r.nextInt(1000, 9999);
		 return randomnum;
	 }
	 
	 public LocalDate getdate() {
		 
		 LocalDate todaydate = LocalDate.now();
		return todaydate;
	 }
	 
 public LocalDate getdatepuledays() {
		 
		 LocalDate todaydate = LocalDate.now().plusDays(30);
		return todaydate;
	 }
 
 
	 public long createrandomphonenumber() {
		 Random r=new Random();
		 long randomnum = r.nextInt(100000000,999999999);
		 return randomnum;
	 }
	 
	 
	 public int createrandomnumberforindustry() {
		 Random r=new Random();
		 int randomnum = r.nextInt(2,29);
		 return randomnum;
	 }
	 
	 public int createrandomnumberfortype() {
		 Random r=new Random();
		 int randomnum = r.nextInt(2,9);
		 return randomnum;
	 }
	 
	 
	 public int createrandomnumberforcategory() {
		 Random r=new Random();
		 int randomnum = r.nextInt(1,3);
		 return randomnum;
	 }
	 
	 
}
