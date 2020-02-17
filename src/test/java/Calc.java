import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Calc {

    @Test
    public void startWebDriver() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get("https://web2.0calc.com");
        String webTitle = driver.getTitle();
        System.out.print(webTitle);

        boolean verify1 = driver.getTitle().contains("Web 2.0 scientific calculator");
        if (verify1) {
            System.out.println(" - It is OK!");
        } else {
            System.out.println(" - ERROR - Ups, wrong page!");
            driver.quit();
        }

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[id=\"cookieconsentallowal\"]")).click();
        driver.findElement(By.cssSelector("[id=\"input\"]")).sendKeys("35");
        driver.findElement(By.cssSelector("[id=\"BtnMult\"]")).click();
        driver.findElement(By.cssSelector("[id=\"input\"]")).sendKeys("999");
        driver.findElement(By.cssSelector("[id=\"BtnPlus\"]")).click();
        driver.findElement(By.cssSelector("[id=\"BtnParanL\"]")).click();
        driver.findElement(By.cssSelector("[id=\"input\"]")).sendKeys("100");
        driver.findElement(By.cssSelector("[id=\"BtnDiv\"]")).click();
        driver.findElement(By.cssSelector("[id=\"input\"]")).sendKeys("4");
        driver.findElement(By.cssSelector("[id=\"BtnParanR\"]")).click();
        driver.findElement(By.cssSelector("[id=\"BtnCalc\"]")).click();

        WebElement equal1 = wait.until(presenceOfElementLocated(By.cssSelector("[id=\"result\"]")));
        driver.findElement(By.cssSelector("[class=\"history btn-group open\"]")).click();
        String results = driver.findElement(By.xpath("//*[@id='histframe']/ul/li/p[1]")).getText();
        Assert.assertTrue(results.equals("34990"));


        driver.manage().deleteAllCookies();
        driver.close();


    }
}
