package com.comcast.crm.generic.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retrylistener implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
	int count=0;
	int limit=4;
	if(count<limit) {
		count++;
		return true;
	}
		return false;
	}

}
