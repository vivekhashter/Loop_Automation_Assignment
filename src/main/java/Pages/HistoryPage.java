package Pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import driver.Driver;
import utils.SeleniumUtils;

public class HistoryPage {
	private static final By Email = By.xpath("//input[@id=':r1:']");
	private static final By Password = By.xpath("//input[@id=':r2:']");
	private static final By Login = By.xpath("//button[normalize-space()='Login']");
	private static final By Skip = By.xpath("//button[normalize-space()='Skip for now']");
	private static final By Charge = By.xpath("//span[normalize-space()='3P Chargebacks']");
	private static final By History = By.xpath("//span[normalize-space()='History by Store']");
	private static final By Rows = By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-13lp5y3-MuiSelect-select-MuiInputBase-input-MuiOutlinedInput-input']//parent::div)[1]");
	private static final By Rows_Per_Page= By.xpath("//*[@id='menu-']/div[3]/ul/li[3]");
	private static final By Scroll= By.xpath("//div[@id='root']//div[@aria-hidden='true']");
	
	public void  scrollInto() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element1 = Driver.driver.findElement(By.xpath("//div[@id='root']//div[@aria-hidden='true']"));
		JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
		js.executeScript("arguments[0].removeAttribute('aria-hidden');", element1);
		
	}
	
		

	public void enterEmail(String email) throws InterruptedException {
		
		SeleniumUtils.sendKeys(Email, email, "email");
		
	}

	public void enterPassword(String password) throws InterruptedException {

		SeleniumUtils.sendKeys(Password, password, "Password");
	}

	public void clickonLogin() throws InterruptedException {

		SeleniumUtils.click(Login, "login");
	}

	public void clickonSkip() {
		SeleniumUtils.click(Skip, "skip");
	}

	public void clickonCharge() throws InterruptedException {

		SeleniumUtils.click(Charge, "Charge");
	}

	public void clickonHistory() throws InterruptedException {
		

		SeleniumUtils.click(History, "History");
		Thread.sleep(20000);
	}
	public void clickondropdown() throws InterruptedException {
		Thread.sleep(5000);
		WebElement element = Driver.driver.findElement(By.xpath(
				"(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-13lp5y3-MuiSelect-select-MuiInputBase-input-MuiOutlinedInput-input']//parent::div)[1]"));

		// Execute JavaScript to scroll to the element
		((JavascriptExecutor)Driver.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		element.click();
		Thread.sleep(4000);

//		SeleniumUtils.click(Rows, "Rows");
	}
	public void clickToSelectPage() throws InterruptedException {

		SeleniumUtils.click(Rows_Per_Page, "50 pages");
	}
	public void scrollDown() {
		SeleniumUtils.scroll(Rows);
	}
	public void grandSum() throws InterruptedException {
		SeleniumUtils.tableValues();
		
	}
	public void screenshotToGithub() throws InterruptedException , AWTException, IOException {
		SeleniumUtils.screenshot();
	}

}
