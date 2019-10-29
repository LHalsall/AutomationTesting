package main;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTest {
    WebDriver driver;
    Actions builder;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void begin() throws InterruptedException {
        driver.get("https://www.youidraw.com/apps/painter/");
        Thread.sleep(1000);
        WebElement chooseBrush = driver.findElement(By.id("pencil"));
        chooseBrush.click();
        WebElement chooseType = driver.findElement(By.id("cmbPencil"));
        chooseType.click();
        Thread.sleep(2000);
        List<WebElement> chooseSpecific = driver.findElements(By.tagName("option"));
        for (WebElement cs : chooseSpecific) {
            if (cs.getAttribute("value").contains("Fur")) {
                cs.click();
                break;
            }

        }
        List<WebElement> chooseSize = driver.findElements(By.tagName("span"));
        for (WebElement ct : chooseSize) {
            if (ct.getAttribute("class").contains("ui-icon ui-icon-triangle-1-n")) {
                ct.click();
                ct.click();
                ct.click();
                ct.click();
                ct.click();
                ct.click();
                break;
            }

        }
        Thread.sleep(2000);
        builder = new Actions(driver);

        // L
        builder.moveByOffset(500, 200).perform();
        builder.clickAndHold().moveByOffset(0, 250).release().perform();
        builder.clickAndHold().moveByOffset(100, 0).release().perform();
        Thread.sleep(1000);
        // U
        builder.moveByOffset(100, -200).perform();
        builder.clickAndHold().moveByOffset(0, 200).release().perform();
        builder.clickAndHold().moveByOffset(100, 0).release().perform();
        builder.clickAndHold().moveByOffset(0, -200).release().perform();
        Thread.sleep(1000);
        // K
        builder.moveByOffset(100, 0).release().perform();
        builder.clickAndHold().moveByOffset(0, 200).release().perform();
        builder.moveByOffset(0, -100).release().perform();
        builder.clickAndHold().moveByOffset(50, -100).release().perform();
        builder.moveByOffset(-50, 100).release().perform();
        builder.clickAndHold().moveByOffset(50, 100).release().perform();
        Thread.sleep(1000);
        // E
        builder.moveByOffset(100, 0).release().perform();
        builder.clickAndHold().moveByOffset(0, -200).release().perform();
        builder.clickAndHold().moveByOffset(50, 0).release().perform();
        builder.moveByOffset(-50, 100).release().perform();
        builder.clickAndHold().moveByOffset(50, 0).release().perform();
        builder.moveByOffset(-50, 100).release().perform();
        builder.clickAndHold().moveByOffset(50, 0).release().perform();
        // Line
        builder.moveByOffset(-600, 50).release().perform();
        builder.clickAndHold().moveByOffset(600, 0).release().perform();
        Thread.sleep(5000);
    }

    @After
    public void teardown() {
        driver.close();
    }

}
