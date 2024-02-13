package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.HistoryPage;
import config.ConfigFactory;
import driver.Driver;

public class BaseTest {
	HistoryPage hp = new HistoryPage();

	protected BaseTest() {
	}
    @BeforeMethod
	public void setUp() throws InterruptedException {
		Driver.initDriver();
		hp.scrollInto();
		hp.enterEmail(ConfigFactory.getConfig().Email());
		hp.enterPassword(ConfigFactory.getConfig().Password());
		hp.clickonLogin();
		hp.clickonSkip();
		hp.clickonCharge();
		
	}

}
