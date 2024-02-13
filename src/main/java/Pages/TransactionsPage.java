package Pages;

import org.openqa.selenium.By;

import utils.SeleniumUtils;

public class TransactionsPage {
	private static final By Transaction = By.xpath("//span[normalize-space()='Transactions']");
	private static final By FilterOne =By.xpath("(//body//header)[2]//button[1]");
	private static final By Clear = By.xpath("//button[text()='Clear']");
	
	private static final By Artisan=By.xpath("//p[text()='Artisan Alchemy']//parent::div//parent::li");
	private static final By Blissful_Buffet=By.xpath("//p[text()='Blissful Buffet']//parent::div//parent::li");
	
	private static final By Apply_Btn=By.xpath("//button[@data-testid='applyBtn']");

	private static final By FilterTwo =By.xpath("(//body//header)[2]//button[3]");
	private static final By Grubhub = By.xpath("//p[text()='Grubhub']//parent::div//parent::li");
	
	public void clickonTransaction() throws InterruptedException {

		SeleniumUtils.click(Transaction, "transaction");
	}
	public void clickonFilterOne() throws InterruptedException {

		SeleniumUtils.click(FilterOne, "FilterOne");
	}
	public void clickonClear() throws InterruptedException {

		SeleniumUtils.click(Clear, "clear");
	}
	public void clickonArtisan() throws InterruptedException {

		SeleniumUtils.click(Artisan, "Artisan");
	}
	public void clickonBlissful() throws InterruptedException {

		SeleniumUtils.click(Blissful_Buffet, "blissful_buffet");
	}
	public void clickonApplyButton() throws InterruptedException {

		SeleniumUtils.click(Apply_Btn, "Apply button");
	}
	public void clickonGrubHubb() throws InterruptedException {

		SeleniumUtils.click(Grubhub, "GrubHub");
	}
	public void clickonFilterTwo() throws InterruptedException {

		SeleniumUtils.click(FilterTwo, "FilterTwo");
	}
	public void tableToCsvConversion() throws InterruptedException {

		SeleniumUtils.tableToCsv();
		
	}
}
