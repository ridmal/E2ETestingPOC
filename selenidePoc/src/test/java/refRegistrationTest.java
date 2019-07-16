
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;


public class refRegistrationTest {
	@Test
	public void userRegistration(){
		Configuration.holdBrowserOpen = true;

		// Login
		open("http://localhost:8090/openmrs");
		$(By.name("username")).setValue("admin");
		$(By.name("password")).setValue("Admin123");
		$(By.id("Outpatient Clinic")).click();
		$(By.id("loginButton")).pressEnter();

		//Name
		$(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
		$(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/h2")).equals("Register a patient");
		$(By.name("givenName")).setValue("testGivenName");
		$(By.name("middleName")).setValue("testMiddleName");
		$(By.name("familyName")).setValue("testFamilyName");

		// Gender
		$(By.id("genderLabel")).click();
		$(By.id("gender-field")).selectOptionByValue("M");

		// Birthday label
		$(By.id("birthdateLabel")).click();
		$(By.name("birthdateDay")).setValue("19");
		$(By.name("birthdateMonth")).selectOptionByValue("12");
		$(By.name("birthdateYear")).setValue("1990");

		// Address
		$(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/ul[@id='formBreadcrumb']/li[@class='doing'][2]/ul/li[@class='question-legend'][1]/span")).click();
		$(By.id("address1")).setValue("test address1");
		$(By.id("address2")).setValue("test address2");

		// Phone number
		$(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/ul[@id='formBreadcrumb']/li[@class='doing'][2]/ul/li[@class='question-legend'][1]/span")).click();
		$(By.name("phoneNumber")).setValue("0123456789");

		$(By.id("confirmation_label")).click();

		$(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[1]")).equals("Name: testGivenName, testMiddleName, testFamilyName");
		$(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[2]")).equals("Gender: Male");
		$(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[3]")).equals("Birthdate: 12, December, 1990");
		$(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[4]")).equals("Address: test address");
		$(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[5]")).equals("Phone Number: 0123456789");
		$(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/div[@id='confirmation']/div[@id='dataCanvas']/div/p[6]")).equals("Relatives: --");

		$(By.id("submit")).click();

	}

}
