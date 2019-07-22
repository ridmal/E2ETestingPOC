package org.selenuim.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverStartup {

	public WebDriver startWebDriver(){

		String exePath = "Add web driver path to here";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		return driver;
	}

}
