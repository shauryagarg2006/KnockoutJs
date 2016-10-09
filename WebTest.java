package selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	@Test
	public void NumberOfFrustratedDev() throws Exception {
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//span[.='Frustration of Software Developers']/../../following-sibling::div/descendant::span[@data-bind='text: votes']")));
		List<WebElement> partCount = driver.findElements(By.xpath(
				"//span[.='Frustration of Software Developers']/../../following-sibling::div/descendant::span[@data-bind='text: votes']"));
		assertNotNull(partCount);
		assertFalse(partCount.isEmpty());
		assertEquals("55", (partCount.get(0).getText()));

	}

	@Test
	public void SoftChangesSurveyHasAmazonImg() throws Exception {
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//span[.='Software Changes Survey']/../../descendant::img[@src='/media/amazongc-micro.jpg']")));
		List<WebElement> partCount = driver.findElements(By
				.xpath("//span[.='Software Changes Survey']/../../descendant::img[@src='/media/amazongc-micro.jpg']"));
		assertFalse(partCount.isEmpty());

	}

	@Test
	public void OpenShouldHaveParticipateBtn() throws Exception {
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='row']/descendant::span[@data-bind='text: status' and .='OPEN']")));
		List<WebElement> openList = driver
				.findElements(By.xpath("//div[@class='row']/descendant::span[@data-bind='text: status' and .='OPEN']"));

		if (!openList.isEmpty()) {
			for (WebElement temp : openList) {
				List<WebElement> item = temp.findElements(By.xpath("../../descendant::button"));
				assertNotNull(item);
				assertFalse(item.isEmpty());
				assertEquals("Participate", item.get(0).getText());
			}
		}

	}

	@Test
	public void NumberOfClosedEqualFive() throws Exception {
		driver.get("http://www.checkbox.io/studies.html");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> spans = driver.findElements(By.xpath("//a[@class='status']/span[.='CLOSED']"));
		assertNotNull(spans);
		assertEquals(5, spans.size());
	}

}
