package tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import Pages.HistoryPage;


public final class HistoryTests extends BaseTest {
	
    @Test
	public void historyStoreFunctionality() throws InterruptedException, AWTException, IOException {
		HistoryPage hp = new HistoryPage();	
		hp.clickonHistory();
		hp.clickondropdown();
		hp.clickToSelectPage();
		hp.grandSum();
		hp.screenshotToGithub();
	}
}
