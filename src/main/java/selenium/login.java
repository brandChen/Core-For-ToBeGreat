package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Administrator on 2017/8/28.
 */
public class login {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "D:/selenium/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "D:/soft/Mozilla Firefox/firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.xjh.com");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("userName")).sendKeys("18500197165");
        driver.findElement(By.id("password")).sendKeys("csz123456");
        driver.findElement(By.className("login_button")).click();

    }
}
