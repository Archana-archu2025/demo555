package demotesting;

import java.util.Random;

public class generaterandomnumber {

	public static void main(String[] args) {
		
		//creating random  number
        Random r=new Random();
        int rn = r.nextInt(100,1000);
        System.out.println(rn);
        
        //creating alphanumeric number
        int num=10;
        String numericnumber="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        
        StringBuffer sb=new StringBuffer(num);
        
        for(int i=0;i<num;i++) {
        	
        	//int index=(int)(numericnumber.length()*Math.random());
        	Random ru=new Random();
        	int index = ru.nextInt(numericnumber.length());
        	sb.append(numericnumber.charAt(index));
        	
        }
    	System.out.println(sb);
        
	}

}
