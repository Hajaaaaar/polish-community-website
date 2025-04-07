//
//package com.example.polishCommunity.functional;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.By;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import java.time.Duration;
//
//public class LoginPageTest {
//    private WebDriver webDriver;
//    private WebDriverWait wait;
//
//    @BeforeEach
//    void setup() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//     //   options.addArguments("--start-maximized");
////        options.addArguments("--headless");
//        webDriver = new ChromeDriver(options);
//        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//    }
//
//    @Test
//    void testLoginPage() {
//        System.out.println("Opening login page...");
//        webDriver.get("http://localhost:8081/signin-register");
//
//        // Wait for the elements to be visible before interacting
//        System.out.println("Entering email...");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginEmail"))).sendKeys("hajarnefaa@gmail.com");
//
//        System.out.println("Entering password...");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginPassword"))).sendKeys("@Hajar18");
//
//        System.out.println("Clicking login button...");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log In']"))).click();
//
//        // Wait for page to load after login
//        System.out.println("Waiting for redirection...");
//        wait.until(ExpectedConditions.urlToBe("http://localhost:8081/home"));
//
//        // Check the current URL and verify it's the expected one
//        System.out.println("Final URL: " + webDriver.getCurrentUrl());
//        Assertions.assertEquals("http://localhost:8081/home", webDriver.getCurrentUrl());
//    }
//
//    @AfterEach
//    void tearDown() {
//        if (webDriver != null) {
//            webDriver.quit();
//        }
//    }
//}
//
