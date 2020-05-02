package com.sample.AppDemo;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{ 
	
	 public static WebDriver driver;
	 String pwd = System.getProperty("pwd");
	 String sPath = System.getProperty("user.dir");
	 static String OS = System.getProperty("os.name").toLowerCase();
	
   @Test
    public void testApp() throws Exception
    {
	   System.out.println("Osname "+OS);
	   System.out.println("This is for Testing Ouput in Concource Console Using Maven");
       System.out.println("Project Working Dirctory: "+pwd);
	   if (isWindows()) {
			System.out.println("This is Windows");
			  //System.setProperty("webdriver.chrome.driver", sPath+"\\Drivers\\chromedriver.exe");
			  System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("Drivers/chromedriver.exe").getPath());
		} else if (isMac()) {
			System.out.println("This is Mac");
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
			  //System.setProperty("webdriver.chrome.driver", sPath+"//Drivers//chromedriver");
			 System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("Drivers/chromedriver").getPath());
		} else if (isSolaris()) {
			System.out.println("This is Solaris");
		} else {
			System.out.println("Your OS is not support!!");
		}
	   DesiredCapabilities dc = DesiredCapabilities.chrome();
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(10000);
		System.out.println("Title "+driver.getTitle());
         driver.close();
         driver.quit();
    }
   
   
   public static boolean isWindows() {
 
		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}
}
