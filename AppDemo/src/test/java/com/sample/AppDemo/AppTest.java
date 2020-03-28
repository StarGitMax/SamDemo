package com.sample.AppDemo;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{

	 String pwd = System.getProperty("browser");
	
   @Test
    public void testApp()
    {
        System.out.println("This is for Testing Ouput in Concource Console Using Maven");
        System.out.println("Project Working Dirctory: "+pwd);
    }
}
