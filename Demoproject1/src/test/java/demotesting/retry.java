package demotesting;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class retry {
	@Test(retryAnalyzer = com.comcast.crm.generic.listenerutility.retrylistener.class)
public void retryexecute() {
		assertEquals("", "aaa");
	System.out.println("====retry====");
	
}
}
