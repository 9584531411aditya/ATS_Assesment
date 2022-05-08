package test_File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_File.PageFile;

public class NewTest {
	WebDriver driver;
	PageFile pf = new PageFile();

	public static String propfile(String s) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(".\\src\\main\\java\\dataFile\\data.properties"));
		Properties prop = new Properties();
		prop.load(reader);
		return prop.getProperty(s);
	}

	@AfterMethod
	public void afterMethod() {
		pf.closePage();
	}

	@BeforeMethod
	public void beforeMethod() {
		pf.openBrowser();
	}

	@Test(priority = 1)
	public void signUp() throws Exception {

		pf.openLoginPage(propfile("URL"));
		pf.signUp();
		pf.details(propfile("email"), propfile("FirstName"), propfile("LastName"), propfile("Password"),
				propfile("Password"));
		pf.orgDetails(propfile("CompanyName"), propfile("CompanyAddress"));
		pf.companyAdd(propfile("CompanyCountry"), propfile("CompanyProvince"), propfile("CompanyCity"),
				propfile("CompanyZip"), propfile("OrganizationType"));
		pf.role("General Manager");

	}

	@Test(priority = 2)
	public void emailverify() {
		pf.email();
	}

	@Test(priority = 3)
	public void log() throws InterruptedException, IOException {
		pf.openLoginPage(propfile("URL"));
		pf.login(propfile("email"), propfile("Password"));

		pf.projectDetails(propfile("ProjectName"), propfile("ProjectCountry"), propfile("ProjectProvince"),
				propfile("ProjectCity"), propfile("ProjectAddress"), propfile("ProjectBidDate"),
				propfile("ProjectArea"));
		pf.projectBuildClass(propfile("ProjectName"));

	}

}
