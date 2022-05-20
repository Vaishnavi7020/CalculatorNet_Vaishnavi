package calculatortest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class Calculator1 {
		WebDriver driver;

		@BeforeMethod
		public void setUp() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
			
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.get("https://www.calculator.net");
			Thread.sleep(5000);

		}

		@Test(priority = 1)
		public void verifyMultiplication() throws InterruptedException {
			String num1 = "423", num2 = "525", expctedResult = "222075";

			for (int i = 0; i < num1.length(); i++) {

				char digit = num1.charAt(i);
				int val = Character.getNumericValue(digit);
				driver.findElement(By.xpath("//*[@class='scinm' and text()='" + val + "']")).click();
				Thread.sleep(500);

			}

			driver.findElement(By.xpath("//*[@class='sciop' and text()='×']")).click();

			for (int j = 0; j < num2.length(); j++) {

				char digit = num2.charAt(j);
				int val = Character.getNumericValue(digit);
				driver.findElement(By.xpath("//*[@class='scinm' and text()='" + val + "']")).click();
				Thread.sleep(500);

			}

			String actualResult = driver.findElement(By.xpath("//*[@id='sciOutPut']")).getText().trim();
			Thread.sleep(2000);
			Assert.assertEquals(actualResult, expctedResult);

		}
		
		@Test(priority=2)
		public void verifyDivision() throws InterruptedException {
			String expctedResult="20";
			
			driver.findElement(By.xpath("//*[@class='scinm' and text()='4']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='0']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='0']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='0']")).click();
			
			driver.findElement(By.xpath("//*[@class='sciop' and text()='/']")).click();
			
			driver.findElement(By.xpath("//*[@class='scinm' and text()='2']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='0']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='0']")).click();

			String actualResult = driver.findElement(By.xpath("//*[@id='sciOutPut']")).getText().trim();
			Thread.sleep(2000);
			Assert.assertEquals(actualResult, expctedResult);
				
		}

		@Test(priority=3)
		public void verifyAddition() throws InterruptedException {
			String expctedResult="111111";
			
			driver.findElement(By.xpath("//*[@class='sciop' and text()='–']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='2']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='3']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='4']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='2']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='3']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='4']")).click();
			
			driver.findElement(By.xpath("//*[@class='sciop' and text()='+']")).click();
			
			driver.findElement(By.xpath("//*[@class='scinm' and text()='3']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='4']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='5']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='3']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='4']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='5']")).click();

			String actualResult = driver.findElement(By.xpath("//*[@id='sciOutPut']")).getText().trim();
			Thread.sleep(2000);
			Assert.assertEquals(actualResult, expctedResult);
				
		}
		
		@Test(priority=4)
		public void verifySubstraction() throws InterruptedException {
			String expctedResult="23329646";
			
			driver.findElement(By.xpath("//*[@class='scinm' and text()='2']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='3']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='4']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='8']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='2']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='3']")).click();
			
			driver.findElement(By.xpath("//*[@class='sciop' and text()='–']")).click();
			
			driver.findElement(By.xpath("//*[@class='sciop' and text()='–']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='2']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='3']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='0']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='9']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='4']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='8']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='2']")).click();
			driver.findElement(By.xpath("//*[@class='scinm' and text()='3']")).click();

			String actualResult = driver.findElement(By.xpath("//*[@id='sciOutPut']")).getText().trim();
			Thread.sleep(2000);
			Assert.assertEquals(actualResult, expctedResult);
				
		}


		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

	}



