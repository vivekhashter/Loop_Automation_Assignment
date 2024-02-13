package utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Driver;
import driver.DriverManager;


public class SeleniumUtils{
	public SeleniumUtils() {
	}

	// method to wait until element is visible
	public static WebElement waitUntilElementToBeVisible(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofMinutes(2));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
//            ExtentLogger.fail
			return null;
		}
	}

	// method to wait until element is present
	public static WebElement waitUntilElementPresent(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofMinutes(2));
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
//            ExtentLogger.fail
			return null;
		}
	}

	// method to wait until element is clickable
	public static WebElement waitUntilElementToBeClickable(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofMinutes(2));
			return wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
//            ExtentLogger.fail
			return null;
		}
	}

	// method to refresh page
	public static void refreshPage() {
		DriverManager.getDriver().navigate().refresh();
	}

	// method to wait until element is present and then click on the element
	public static void click(By by, String elementName) {
		WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(20));
		WebElement element = Driver.driver.findElement(by);
		try {
			element.click();
		} catch (Exception e) {
//            ExtentLogger.fail
		}
	}

	// method to wait until element is present and select value in dropdown
	public static void selectItemByVisibleText(By by, final String value) {
		waitUntilElementPresent(by);
		Select select = new Select(DriverManager.getDriver().findElement(by));
		select.selectByVisibleText(value);
	}

	// method to wait until element is present and then send value in field
	public static void sendKeys(By by, String value, String elementName) {
		try {
			WebElement element = Driver.driver.findElement(by);
			element.sendKeys(value);
		} catch (Exception e) {
//            ExtentLogger.fail
		}
	}

	// method to hover over element
	public static void hoverOver(By by1) {
		try {
			Actions actions = new Actions(DriverManager.getDriver());

			Action mouseOver = actions.moveToElement(DriverManager.getDriver().findElement(by1)).build();
			mouseOver.perform();
//            actions.moveToElement(DriverManager.getDriver().findElement(by2));
//            actions.build().perform();
//        actions.click();
		} catch (Exception e) {
//            ExtentLogger.fail
		}
	}

	// method to scroll till element visible on screen
	public static void scroll(By by) {
		try {
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					DriverManager.getDriver().findElement(by));
			Thread.sleep(1000);

		} catch (Exception e) {
//            ExtentLogger.fail
		}
	}

	// method to check whether element present or not
	public static boolean isElementPresent(By by) {
		try {
			boolean isPresent = false;
			if (DriverManager.getDriver().findElements(by).size() > 0) {
				isPresent = true;
			}
			return isPresent;
		} catch (Exception e) {
//            ExtentLogger.fail
		}
		return false;
	}

	// method to hit enter with keyboard
	public static void hitEnter(By by) {
		WebElement element = waitUntilElementPresent(by);
		element.sendKeys(Keys.ENTER);
	}

	public static void scrollInTo(By by) throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].removeAttribute('aria-hidden');",
                DriverManager.getDriver().findElement(by));
		
//		WebElement element1 = DriverManager.getDriver().findElement(By.xpath("//div[@id='root']//div[@aria-hidden='true']"));
//		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//		js.executeScript("arguments[0].removeAttribute('aria-hidden');", element1);
	}

	public static void tableValues() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(20));
		float arr[] = new float[7];
		float arr1[] = new float[7];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
			arr1[i] = 0;
		}
		for (int a = 1; a <= 3; a++) {

			for (int i = 2; i <= 8; i++) {
				float sum = 0;

				for (int j = 1; j <= 50; j++) {
					if (a == 3 && j == 7) {
						break;
					}

					String xpath = "//div[@id='root']//div[@id='view-table-id']//table//tbody//tr[" + j + "]/td[" + i+ "]";
					String value = Driver.driver.findElement(By.xpath(xpath)).getText().replace("$", "").replace(",","");

					sum = Float.parseFloat(value);
					arr[i - 2] += sum;

				}
				if (a == 1) {

					String xpath = "//div[@id='root']//div[@id='view-table-id']//table//tbody//tr[52]/td[" + i + "]";
					String value = Driver.driver.findElement(By.xpath(xpath)).getText().replace("$", "").replace(",",
							"");
					arr1[i - 2] = Float.parseFloat(value);
				}
			}

			if (a == 3) {

			} else {
				WebElement element2 = Driver.driver.findElement(By.xpath("//button[@data-testid='pagination-next']"));
				// Execute JavaScript to scroll to the element
				((JavascriptExecutor) Driver.driver).executeScript("arguments[0].scrollIntoView(true);", element2);
				Thread.sleep(5000);
				Driver.driver.findElement(By.xpath("//button[@data-testid='pagination-next']")).click();
			}

		}
		for (int i = 0; i < arr.length; i++) {
			String formattedNumber = String.format("%.2f", arr[i]);
			String formattedNumber1 = String.format("%.2f", arr[i]);
			arr[i] = Float.parseFloat(formattedNumber);
			arr1[i] = Float.parseFloat(formattedNumber1);

			if (arr[i] == arr1[i]) {
				System.out.println("Grand total is matched at " + (i + 1) + "position");
			}
		}
	}

	public static  void screenshot() throws IOException, AWTException, InterruptedException {
		Driver.quitDriver();
		Thread.sleep(1000);
		
		BufferedImage terminalImage = captureTerminalScreenshot();
		// Step 2: Save the screenshot to a temporary file
		long currentTimeMillis = System.currentTimeMillis();
		File tempFile = new File("screenshots/terminalScreenshot" + currentTimeMillis + ".png");
		// Create directory if it doesn't exist
		tempFile.getParentFile().mkdirs();
		javax.imageio.ImageIO.write(terminalImage, "png", tempFile);

		// Step 3: Use GitHub API to create a new repository if it doesn't exist already
		String githubToken = "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";
		GitHub github = GitHub.connectUsingOAuth(githubToken);
		String repoName = "screenshot-repo";
		GHRepository repository;
		try {
			repository = github.getRepository(github.getMyself().getLogin() + "/" + repoName);
		} catch (IOException e) {
			// Repository does not exist, create a new one
			GHCreateRepositoryBuilder builder = github.createRepository(repoName);
			repository = builder.create();
		}

		String filePath = "screenshot" + currentTimeMillis + ".png";
		String commitMessage = "Adding terminal screenshot";
		String branchName = "main";
		byte[] fileContentBytes = FileUtils.readFileToByteArray(tempFile);
		try {

			repository.createContent().content(fileContentBytes).path(filePath)
					.message(commitMessage + "existing file" + tempFile.getName()).branch(branchName)

					.commit();

		} catch (Exception e) {
			System.err.println("Error: Unable to access GitHub repository.");
			e.printStackTrace();
		} finally {
			String fileName = tempFile.getName();
			if (tempFile.delete()) {
				System.out.println(fileName + "is deleted");
			}
		}
	}
	
	    

	private static BufferedImage captureTerminalScreenshot() throws AWTException {
		// Capture screenshot of the entire screen
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenImage = new Robot().createScreenCapture(screenRect);

        return screenImage;
	}
	public static void tableToCsv() throws InterruptedException {
		Thread.sleep(6000);
		WebElement element3 = Driver.driver.findElement(By.xpath("(//div[@id='main_start_app']//div//div//div//div//div)[1]"));
		((JavascriptExecutor) Driver.driver).executeScript("arguments[0].removeAttribute('style');", element3);

		WebElement table = Driver.driver.findElement(By.xpath("//div[@id='root']//div[@id='view-table-id']//table"));

		//

		try {
			// Create a FileWriter object to write data to CSV file
			FileWriter csvWriter = new FileWriter("chargebacks_payouts.csv");

			// Write the header line to the CSV file
			csvWriter.append(
					"order_id,platform, slug ,b_name ,vb_name,order_date,transaction_type,payout_id,payout_date,net_payout,lost_sale");
			csvWriter.append("\n");
			// Find all rows of the table
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			String orderid = "";
			String b_name = "";
			String platform= "";
			String slug = "";
			String vb_name = "";
			String order_date = "";
			String transaction_type = "";
			String payout_id = "";
			String payout_date = "";
			String net_payout = "";
			String lost_sale = "";

			// Loop through each row
			for (WebElement row : rows) {
				// Find all columns of the current row
				List<WebElement> columns = row.findElements(By.tagName("td"));

				// Loop through each column
				for (int i = 0; i < columns.size(); i++) {
					String text = columns.get(i).getText().trim().replaceAll(",", " ");
					if (columns.size() == 8) {

						if (i == 0) {

							orderid = text;

						}

						if (i == 1) {
							b_name = text;

						}

						if (i == 2)
							continue;

						if (i == 3) {
							transaction_type = text;
						}
						if (i == 4) {
							lost_sale = text;
						}
						if (i == 5) {
							net_payout = text;
						}
						if (i == 6) {
							payout_id = text;
						}
						if (i == 7) {
							payout_date = text;
						}
					} else if (columns.size() == 5) {
						if (i == 0) {
							transaction_type = text;
						}
						if (i == 1) {
							lost_sale = text;
						}
						if (i == 2) {
							net_payout = text;
						}
						if (i == 3) {
							payout_id = text;
						}
						if (i == 4) {
							payout_date = text;
						}
					}

				}
				if (columns != null && !columns.isEmpty()) {

					csvWriter.append(orderid.replace("#", "") + ",");
					csvWriter.append(platform + ",");
					csvWriter.append(slug + ",");
					csvWriter.append(b_name + ",");
					csvWriter.append(vb_name + ",");
					csvWriter.append(order_date + ",");
					csvWriter.append(transaction_type + ",");
					csvWriter.append(("Pending".equalsIgnoreCase(payout_id) ? " " : payout_id) + ",");
					csvWriter.append(("Pending".equalsIgnoreCase(payout_date) ? " " : payout_date) + ",");
					csvWriter.append(net_payout.replace("$", "") + ",");
					csvWriter.append(lost_sale.replace("$", "") + ",");
					csvWriter.append("\n");
				}

			}

			// Close the FileWriter
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
