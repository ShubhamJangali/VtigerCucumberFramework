package com.vtiger.stepdifinitions;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDefinitions {
	public static WebDriver driver;
	public static Properties prop;
	public static  ExtentHtmlReporter htmlrepoter;
	public static ExtentReports extent;
	public static Map<String,Map<String,String>> dt;
	public static ExtentTest Logger;
	public static String TC_Name;
	
	
	public void initiation() {
		if(prop==null)
		prop = readproperties();
		if(extent==null)
		CreateExtentReport();
		if(dt==null)
		dt = JsonReader();
	}

	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("AppURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("ImplicitWait"))));
	}
	
	public void CloseApp() {
		driver.close();
	}

	public Properties readproperties() {
		Properties prop=null;
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Setting/Config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public Map<String,Map<String,String>> JsonReader() {
		Map<String,Map<String,String>> userData=null;
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/Data/TestData.json");
		try {
			userData = mapper.readValue(
					file, new TypeReference<Map<String, Map<String,String>>>() {
			});
			
//			System.out.println("Name :"+userData.get("VerifyInvalidLogin_TC03").get("Userid"));
//			System.out.println("Password :"+userData.get("VerifyInvalidLogin_TC03").get("Password"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return userData;
	}
	
	public void CreateExtentReport() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("ddMMyyyymmss");
		String filename = df.format(date);
		htmlrepoter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/ExtentReport"+filename+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlrepoter);
		extent.setSystemInfo("HostName", "Automation Test Hub");
		extent.setSystemInfo("UserName", "Shubham");
		htmlrepoter.config().setTheme(Theme.STANDARD);
	}
	
}
