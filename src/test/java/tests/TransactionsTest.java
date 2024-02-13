package tests;

import org.testng.annotations.Test;

import Pages.HistoryPage;
import Pages.TransactionsPage;
import utils.SeleniumUtils;

public class TransactionsTest extends BaseTest {

	@Test
	public void transactions() throws InterruptedException {
		HistoryPage hp = new HistoryPage();
		TransactionsPage tp = new TransactionsPage();

		tp.clickonTransaction();
		tp.clickonFilterOne();
		tp.clickonClear();
		tp.clickonArtisan();
		tp.clickonBlissful();
		tp.clickonApplyButton();
		tp.clickonFilterTwo();
		tp.clickonClear();
		tp.clickonGrubHubb();
		tp.clickonApplyButton();
		tp.tableToCsvConversion();

	}

}
