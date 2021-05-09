package com.selenium.webdriver.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample {

	private final static String instagramUrl = "https://www.instagram.com/";

	public static void main(String[] args) throws InterruptedException {

		String usernameInput = args[0];
		String passwordInput = args[1];

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(instagramUrl + usernameInput);

		Thread.sleep(2000);
		
		/* xxx Takipçi Tab'ýna Basma */

		driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/ul/li[2]/a")).click();

		Thread.sleep(2000);
		
		/* Login */
		
		driver.findElement(By.name("username")).sendKeys(usernameInput);

		driver.findElement(By.name("password")).sendKeys(passwordInput);

		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div/div")).click();

		Thread.sleep(4000);
		
		/* xxx Takipçi Tab'ýna Basma */

		driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/ul/li[2]/a")).click();

		Thread.sleep(2000);
		
		int followerCount = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/ul/li[2]/a/span")).getText());

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement followersPopupScroll = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]"));
		
		int scroll = 0;
		while (scroll < (followerCount / 12)) {
			jsExecutor.executeScript("arguments[0].scrollBy(0, arguments[0].scrollHeight);", followersPopupScroll);
			Thread.sleep(1250);
			scroll++;
		}

		List<WebElement> followers = driver.findElements(By.cssSelector(".FPmhX.notranslate._0imsa"));

		int count = 0;
		for (WebElement follower : followers) {
			count++;
			System.out.println(count + " --> " + follower.getText());
		}

	}
}
