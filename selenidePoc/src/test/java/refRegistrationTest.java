
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class refRegistrationTest {
	@Test
	public void userRegistration() {
		Configuration.holdBrowserOpen = true;

		open("http://localhost:8090/openmrs/login.htm");
		$(By.name("username")).setValue("admin");
		$(By.name("password")).setValue("Admin123");
		$(By.id("Acme Clinic")).click();
		$(By.id("loginButton")).pressEnter();


		$(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
		$(By.xpath("/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/h2")).equals("Register a patient");
		$(By.name("givenName")).setValue("ridmal");
		$(By.name("middleName")).setValue("madushanaka");
		$(By.name("familyName")).setValue("Liyanagamage");

		$(By.id("genderLabel")).click();

	}

}
