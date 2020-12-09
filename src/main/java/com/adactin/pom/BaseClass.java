package com.adactin.pom;


	import java.io.File;
	import java.io.IOException;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class BaseClass {
		public static WebDriver driver;

		public static WebDriver getBrowser(String browserName) {

			try {
				if (browserName.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\newChrome\\chromedriver.exe");
					driver = new ChromeDriver();
				} else if (browserName.equalsIgnoreCase("ie")) {
					System.setProperty("webdriver.ie.driver", "C:\\Users\\Lenovo\\Desktop\\newChrome\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				} else {
					System.out.println("Invalid BrowserName");
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return driver;
		}

		public static void waitForElement(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		public static void getURL(String url) {
			try {
				driver.get(url);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public static void inputValueToElement(WebElement element, String value) {
			waitForElement(element);
			try {
				element.sendKeys(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void clickElement(WebElement element) {
			waitForElement(element);
			try {
				element.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void moveToElement(WebElement element) {
			waitForElement(element);
			try {
				Actions ac = new Actions(driver);
				ac.moveToElement(element).build().perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void close() {
			driver.close();
		}

		public static void quit() {
			driver.quit();
		}

		public static void navigateTo(String value) {
			driver.navigate().to(value);
			;
		}

		public static void navigateBack() {
			driver.navigate().back();
		}

		public static void navigateForward() {
			driver.navigate().forward();
		}

		public static void navigateRefresh() {
			driver.navigate().refresh();
		}

		public static void dropDown(WebElement element, String option, String value) {
			try {
				Select sd = new Select(element);
				if (option.equalsIgnoreCase("index")) {
					sd.selectByIndex(Integer.parseInt(value));
				} else if (option.equalsIgnoreCase("value")) {
					sd.selectByValue(value);
				} else if (option.equalsIgnoreCase("visibleText")) {
					sd.selectByVisibleText(value);
				} else {
					System.out.println("invalid option");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

		}

		public static void switchToFrameUsingId(String option, int index) {
			try {
				if (option.equalsIgnoreCase("id")) {
					driver.switchTo().frame(index);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void switchToFrameUsingName(String option, String name) {

			try {
				if (option.equalsIgnoreCase("Framename")) {
					driver.switchTo().frame(name);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void switchToFrameUsingWebelement(String option, String frameElement) {

			try {
				if (option.equalsIgnoreCase("Webelement")) {
					driver.switchTo().frame(frameElement);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void windoHandle(String option) {

			try {
				if (option.equalsIgnoreCase("parentWindow")) {
					String pid = driver.getWindowHandle();
					System.out.println(pid);
					String pTitle = driver.switchTo().window(pid).getTitle();
					System.out.println(pTitle);
				} else if (option.equalsIgnoreCase("Allwindows")) {
					Set<String> aalId = driver.getWindowHandles();
					for (String id : aalId) {
						String allTitle = driver.switchTo().window(id).getTitle();
						System.out.println(allTitle);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void screenShot(String filename) throws IOException {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir")+"\\Screenshot\\"+filename+".png");
			FileUtils.copyFile(srcFile, destFile);
			
			
			
		}

		}



