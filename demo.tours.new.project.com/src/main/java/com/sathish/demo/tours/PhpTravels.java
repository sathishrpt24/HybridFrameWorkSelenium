package com.sathish.demo.tours;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpTravels {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Praveen\\Desktop\\Sathish\\Java\\Drivers\\chromedriver.exe");
				
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.newtours.demoaut.com/");
		
		driver.manage().window().maximize();
		
		String s1 = driver.getTitle();
		
		System.out.println("The Page Tittle is" + s1);
		
		// Login section 
		
		driver.findElement(By.name("userName")).sendKeys("demo123");
		
		driver.findElement(By.name("password")).sendKeys("demo123");
		
		WebElement s2 = driver.findElement(By.xpath("//input[@value ='Login']"));
		
		s2.click();

			WebDriverWait wait = new WebDriverWait(driver, 1);
			
		//	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='tripType56' and @value = 'oneway']")));
		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='tripType' and @value = 'oneway']")));
			
			wait.until(ExpectedConditions.titleContains("Find a Flight: Mercury Tours:"));
			
		String s3 = driver.getTitle();

		System.out.println("The new page is loaded successfully"+ s3);
		
		driver.findElement(By.xpath("//input[@name='tripType' and @value = 'oneway']")).click();
		
		WebElement passenger = driver.findElement(By.name("passCount"));
		
		Select select = new Select(passenger);
		
		select.selectByValue("4");
		
		WebElement Departing_From = driver.findElement(By.name("fromPort"));
		
		Select select1 = new Select(Departing_From);
		
		select1.selectByVisibleText("Frankfurt");
		
		WebElement from_month = driver.findElement(By.name("fromMonth"));
		
		Select select2 = new Select(from_month);
		
		select2.selectByIndex(1);
		
		WebElement from_day = driver.findElement(By.name("fromDay"));
		
		Select select3 = new Select(from_day);
		
		select3.selectByIndex(1);
		
		WebElement to_port = driver.findElement(By.name("toPort"));
		
		Select select4 = new Select(to_port);
		
		select4.selectByVisibleText("New York");
		
		
		driver.findElement(By.xpath("//input[@value='Business']")).click();
		
				
		driver.findElement(By.name("findFlights")).click();
		
		List<WebElement> a = driver.findElements(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr")); 
		
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[10]/td/font/font/b
		///html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[9]/td/font/font/b
		int rowcount = a.size();
		
		Iterator<WebElement> itr = a.iterator();
		
		while(itr.hasNext()) {
			
			System.out.println(itr.next());
		}
		
		System.out.println("The size is" + rowcount);
		
		ArrayList<String> b= new ArrayList<String>();
		
		ArrayList<Integer> c= new ArrayList<Integer>();
		
		for(int i = 4; i<=rowcount; i++) {
			
					
				if(i%2 == 0) {
					
				 b.add(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr["+i+"]/td/font/font/b")).getText());
						
				}
			
		}
		
		Iterator<String> itr2 = b.iterator();
		
		while(itr2.hasNext()) {
			
			c.add(Integer.parseInt(itr2.next().substring(8)));
		}
		
		
		
	
		Iterator<Integer> itr3 = c.iterator();
		
		while(itr3.hasNext()) {
			
			System.out.println(itr3.next());
		}
		
			int g = Collections.min(c);	//driver.close();;
	}

}
