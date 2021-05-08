package com.selenium.webdriver.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample {

	private final static String instagramLoginUrl = "https://www.instagram.com/accounts/login/";

	public static void main(String[] args) throws InterruptedException {

		String usernameInput = args[0];
		String passwordInput = args[1];

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(instagramLoginUrl);

		Thread.sleep(2000);

		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys(usernameInput);

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(passwordInput);

		WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button"));
		btnLogin.click();

	}
}
