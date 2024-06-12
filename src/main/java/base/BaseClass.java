package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.w3c.dom.DOMConfiguration;

import actiondriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentManager;

public class BaseClass {
	
	 public static Properties prop;
	 // public static WebDriver driver;           
	 
	 public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();    //Declare ThreadLocal driver for parallel execution

	 public static WebDriver getDriver() {   //create method to access Webdriver
		  return driver.get();
	}
	 
	 @BeforeSuite
	 public void loadConfig() {
		 ExtentManager.setExtent();
		 DOMConfigurator.configure("log4j.xml");          //DOMConfigurator use to initalise log4j
		
		 try {
				prop=new Properties();
				System.out.println("Super constructor Invoke");
				FileInputStream ip=new FileInputStream(System.getProperty("user.dir") +"\\Configuration\\config.properties");
			    prop.load(ip);
			    System.out.println("driver: " +driver );
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
		}
	}
	 
	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			  //driver=new ChromeDriver();
			driver.set(new ChromeDriver());         //Set Browser to ThreadLocalMap
		}else if(browserName.contains("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			 //driver=new FirefoxDriver();
			driver.set(new FirefoxDriver());         //Set Browser to ThreadLocalMap
		}else if(browserName.contains("IE")) {
			WebDriverManager.iedriver().setup();
			//driver=new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());     //Set Browser to ThreadLocalMap

	}
	 // driver.manage().window().maximize();
	 //	Action.implicitWait(driver, 60);
	 //	driver().get(prop.getProperty("url"));
	 
	 getDriver().manage().window().maximize();
	 Action.implicitWait(getDriver(), 60);
	 getDriver().get(prop.getProperty("url"));
  }	

	
	 @AfterSuite
	 public void afterSuite() {
		 ExtentManager.endReport();
		
	}
}	
