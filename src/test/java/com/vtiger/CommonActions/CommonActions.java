package com.vtiger.CommonActions;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;


public class CommonActions {
	WebDriver driver;
	WebDriverWait wait;
	public static ExtentTest logger;

	public CommonActions(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void InputText(WebElement ele, String str, String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(str);
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Step failed due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void SelectByVisibleText(WebElement ele, String str, String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			Select select = new Select(ele);
			select.selectByVisibleText(str);
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Step failed due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void SelectByIndex(WebElement ele, String str, String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			Select select = new Select(ele);
			select.selectByIndex(Integer.parseInt(str));
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Step failed due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void SelectByValue(WebElement ele, String str, String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			Select select = new Select(ele);
			select.selectByValue(str);
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Step failed due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void AlertAccept(String msg) {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			logger.pass("Alert generated and  "+msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Step failed due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void AlertDismiss(String msg) {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().dismiss();
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Step failed due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void AlertGetText(String msg) {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().getText();
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Step failed due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}

	public void ClickElement(WebElement ele,String msg) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Unable to click on Element due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void MoveToElement(WebElement ele,String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Unable to click on Element due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void ActionsClick(WebElement ele,String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			Actions act = new Actions(driver);
			act.click(ele).perform();
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Unable to click on Element due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}

	public void ElementExist(WebElement ele,String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.isDisplayed();
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Element not exist due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void DragandDrop(WebElement ele1,WebElement ele2,String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele1));
			wait.until(ExpectedConditions.visibilityOf(ele2));
			Actions act = new Actions(driver);
			act.dragAndDrop(ele1, ele2).perform();
			Thread.sleep(5000);
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Drag and Drop failed due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void uploadfile_sendkeys(WebElement ele,String path,String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.sendKeys(path);
			Thread.sleep(5000);
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Drag and Drop failed due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}
	
	public void uploadfile_Robot_Class(WebElement ele,String path,String msg) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			JavascriptExecutor js = ((JavascriptExecutor) driver);
	        js.executeScript("window.scrollBy(0,500)","");
	        Actions act = new Actions(driver);
	        act.click(ele).perform();
	        StringSelection stringSelection = new StringSelection(path);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
	        Thread.sleep(3000);
	        Robot r = new Robot();
	        r.keyPress(KeyEvent.VK_ENTER);
	        r.keyRelease(KeyEvent.VK_ENTER);
	        r.keyPress(KeyEvent.VK_CONTROL);
	        r.keyPress(KeyEvent.VK_V);
	        r.keyRelease(KeyEvent.VK_CONTROL);
	        r.keyRelease(KeyEvent.VK_V);
	        r.keyPress(KeyEvent.VK_ENTER);
	        r.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(5000);
			System.out.println(path);
			logger.pass(msg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fail("Drag and Drop failed due to error "+e.getMessage()+"  <a href='"+getscreenshot()+"'><span class='label end-time'>Screnshot</span>");
		}
	}

	
	public String getscreenshot() {
		Date date = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyymmss");
		String filename = ft.format(date);
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File srcfile = scrShot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshots/image"+filename+".png";
		File Destfile = new File(path);
		try {
			FileUtils.copyFile(srcfile, Destfile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
	
}
