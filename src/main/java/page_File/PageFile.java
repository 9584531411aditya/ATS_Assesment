package page_File;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageFile {
	WebDriver driver;
	GMail g = new GMail();
	// WebDriverWait wait = new WebDriverWait(driver, 30);
	By SignUp = By.xpath("//span[normalize-space()='Sign Up']");
	By Email = By.xpath("(//input[@name='email'])[1]");
	By FirstName = By.xpath("(//input[@type='text'])[2]");
	By LastName = By.xpath("(//input[@type='text'])[3]");
	By Password = By.xpath("(//input[@name='password'])[1]");
	By ConfirmPassword = By.xpath("(//input[@name='password'])[2]");
	By Continue = By.xpath("//button[@type='submit']");
	By CompanyName = By.xpath("//label[text()='Company Name *']/parent::div/div/input");
	By CompanyAdd = By.xpath("//label[text()='Company Address *']/parent::div/div/input");
	By Country = By.xpath("//label[text()='Country *']/parent::div/div//input");
	By Option = By.xpath("(//div[@role='menuitem'])[1]");
	By State = By.xpath("//label[text()='State/Province *']/parent::div/div//input");
	By City = By.xpath("//label[text()='City *']/parent::div/div//input");
	By Zip = By.xpath("//label[text()='Zip/Postal Code *']/parent::div/div//input");
	By orgType = By.xpath("//label[text()='Organization Type *']/parent::div/div");
	By typeOption = By.xpath("//ul[@role='listbox']//li");
	By next = By.xpath("//button[@type='submit']");
	By role = By.xpath("//p[@class='MuiTypography-root-475 MuiTypography-body1-477']");
	By signUp = By.xpath("//span[text()='sign up']");
	By returnlogin = By.xpath("//a[text()='return to login page']");
	By uName = By.xpath("//input[@name='username']");
	By passcode = By.xpath("//input[@name='password']");
	By logButton = By.xpath("//button[@type='submit']");

	By createProject = By.xpath("//span[text()='New Project']");
	By proName = By.xpath("//label[text()='Project Name *']/parent::div/div//input");
	By proAdd = By.xpath("//textarea[@name='address']");
	By proBidDate = By.xpath("//input[@name='bidDate']");
	By proArea = By.xpath("//label[text()='Area (in sq. ft.) *']/parent::div/div//input");
	By proBuildType = By.xpath("//span[normalize-space()='Place of Worship']");

	By buttonFinish = By.xpath("//button[@type='submit']");
	By managePro = By.xpath("//span[text()='Manage Projects']");
	By proSearch = By.xpath("//input[@placeholder='Enter your search']");

	public void openBrowser() {
		String browserName = "Chrome";

		if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void openLoginPage(String URL) {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(URL);

	}

	public void closePage() {
		driver.quit();

	}

	public void signUp() {
		driver.findElement(SignUp).click();
	}

	public void details(String e, String f, String l, String p, String cp) {
		driver.findElement(Email).sendKeys(e);
		driver.findElement(FirstName).sendKeys(f);
		driver.findElement(LastName).sendKeys(l);
		driver.findElement(Password).sendKeys(p);
		driver.findElement(ConfirmPassword).sendKeys(cp);
		driver.findElement(Continue).click();
	}

	public void orgDetails(String cn, String cadd) {

		driver.findElement(CompanyName).sendKeys(cn);
		driver.findElement(CompanyAdd).sendKeys(cadd);

	}

	public void companyAdd(String cou, String state, String city, String zip, String type) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(Country).sendKeys(cou);
		Thread.sleep(2000);
		driver.findElement(Option).click();

		driver.findElement(State).sendKeys(state);
		Thread.sleep(2000);
		driver.findElement(Option).click();

		driver.findElement(City).sendKeys(city);
		Thread.sleep(2000);
		driver.findElement(Option).click();

		driver.findElement(Zip).sendKeys(zip);

		driver.findElement(orgType).click();
		DropDown(typeOption, type);

		driver.findElement(next).click();
	}

	public void email() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(g.actiLink());
		System.out.println(g.actiLink());
	}

	public void login(String e, String p) {
		driver.findElement(uName).sendKeys(e);
		driver.findElement(passcode).sendKeys(p);
		driver.findElement(logButton).click();
	}

	public void projectDetails(String pro_Name, String p_cou, String p_state, String p_city, String p_add,
			String p_bidDate, String p_area) throws InterruptedException {
		driver.findElement(createProject).click();
		driver.findElement(proName).sendKeys(pro_Name);
		Thread.sleep(2000);
		driver.findElement(Country).sendKeys(p_cou);
		Thread.sleep(2000);
		driver.findElement(Option).click();
		Thread.sleep(2000);
		driver.findElement(State).sendKeys(p_state);
		Thread.sleep(2000);
		driver.findElement(Option).click();

		Thread.sleep(2000);
		driver.findElement(City).sendKeys(p_city);
		Thread.sleep(2000);

		driver.findElement(Option).click();

		driver.findElement(proAdd).sendKeys(p_add);
		driver.findElement(proBidDate).sendKeys(p_bidDate);
		driver.findElement(proArea).sendKeys(p_area);
		driver.findElement(next).click();

	}

	public void projectBuildClass(String pro_Name) throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement PublicSpace = (WebElement) jse.executeScript(
				"return document.querySelector(\"body > div:nth-child(13) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(1)\")");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", PublicSpace);
		driver.findElement(proBuildType).click();
		driver.findElement(next).click();
		Thread.sleep(3000);
		driver.findElement(buttonFinish).click();
		Thread.sleep(3000);
		driver.findElement(managePro).click();

		driver.findElement(proSearch).sendKeys(pro_Name);
		Thread.sleep(10000);
	}

	public void role(String r) {
		DropDown(role, r);
		driver.findElement(signUp).click();

	}


	public void checkBox(By locator, String valueName) {
		List<WebElement> element = driver.findElements(locator);
		for (int i = 0; i < element.size(); i++) {
			String value = (element.get(i).getText());
			if (value.equals(valueName)) {
				element.get(i).click();
			}
		}

	}

	public void hidden(By locator, String value) {
		List<WebElement> hidden = driver.findElements(locator);
		int count = hidden.size();

		for (int i = 0; i < count; i++) {
			WebElement ele = hidden.get(i);
			int x = ele.getLocation().getX();

			if (x != 0) {
				ele.click();
			}
			break;
		}
	}

	public void DropDown(By locator, String value) {
		List<WebElement> dropDown = driver.findElements(locator);

		for (WebElement element : dropDown) {
			if (element.getText().equalsIgnoreCase(value)) {
				element.click();
				break;
			}
		}

	}

}
