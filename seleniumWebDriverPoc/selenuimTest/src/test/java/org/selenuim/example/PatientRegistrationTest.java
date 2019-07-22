package org.selenuim.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PatientRegistrationTest {

	@Test
	public void testRegistration(){

		WebDriver driver = new WebDriverStartup().startWebDriver();

		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Outpatient Clinic")).click();
		driver.findElement(By.id("loginButton")).click();

		//Name
		driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
		Assert.assertEquals("Register a patient", driver.findElement(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/h2")).getText());
		driver.findElement(By.name("givenName")).sendKeys("testGivenName2");
		driver.findElement(By.name("middleName")).sendKeys("testMiddleName2");
		driver.findElement(By.name("familyName")).sendKeys("testFamilyName2");

		// Gender
		driver.findElement(By.id("genderLabel")).click();
		Select selectGender = new Select(driver.findElement(By.id("gender-field")));
		selectGender.selectByValue("M");

		// Birthday
		driver.findElement(By.id("birthdateLabel")).click();
		driver.findElement(By.name("birthdateDay")).sendKeys("19");
		Select selectMonth = new Select(driver.findElement(By.name("birthdateMonth")));
		selectMonth.selectByVisibleText("July");
		driver.findElement(By.name("birthdateYear")).sendKeys("1990");

		// Address
		driver.findElement(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/ul[@id='formBreadcrumb']/li[@class='doing'][2]/ul/li[@class='question-legend'][1]/span")).click();
		driver.findElement(By.id("address1")).sendKeys("test address1");
		driver.findElement(By.id("address2")).sendKeys("test address2");


		// Phone number
		driver.findElement(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/ul[@id='formBreadcrumb']/li[@class='doing'][2]/ul/li[@class='question-legend'][1]/span")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("0123456789");

		driver.findElement(By.id("confirmation_label")).click();

		// validate inputs
		Assert.assertEquals("Name: testGivenName2, testMiddleName2, testFamilyName2",driver.findElement(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[1]")).getText());
		Assert.assertEquals("Gender: Male",driver.findElement(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[2]")).getText());
		Assert.assertEquals("Birthdate: 19, July, 1990",driver.findElement(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[3]")).getText());
		Assert.assertEquals("Address: test address1, test address2",driver.findElement(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[4]")).getText());
		Assert.assertEquals("Phone Number: 0123456789",driver.findElement(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[5]")).getText());
		Assert.assertEquals("Relatives: --",driver.findElement(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[6]")).getText());

		driver.findElement(By.id("submit")).click();
	}

}
