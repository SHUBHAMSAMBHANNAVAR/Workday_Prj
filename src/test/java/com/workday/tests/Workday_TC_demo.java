package com.workday.tests;

import org.testng.annotations.Test;

import com.workday.constant.AppConstants;

public class Workday_TC_demo extends BaseClass {
	
	
@Test
  public void Workday_TC_demo(String Proxy) throws InterruptedException {
	
	String Start_proxy_title = start_proxy.startProxy(AppConstants.STARTPROXY);
	
	//String Auth_title = authenticate.Authentication(Proxy);
	
	

}
}