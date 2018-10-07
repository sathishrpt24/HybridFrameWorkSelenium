package ScreenShot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenShot {
		
	private  WebDriver driver;
	private String name;

	
	public  ScreenShot(WebDriver driver, String name){
		
		this.driver = driver;
		this.name = name;
	}

	public  void getScreenShot() {
		
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File Dest = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./target"+System.getProperty("User.dir")+name+".png");
		try {
			FileUtils.copyFile(Dest,destination);
		} catch (Exception e) {
			System.out.println("Unable to take screenshot"+ e);
		}
		
	}

	
}

