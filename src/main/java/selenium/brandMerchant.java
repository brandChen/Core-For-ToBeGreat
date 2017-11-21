package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


/**
 * Created by Administrator on 2017/9/12.
 */
public class brandMerchant {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "D:/我的文档/WeChat Files/qqhycbs/Files/geckodriver.exe");
        //System.setProperty("webdriver.ie.driver","src/com/test/lib/IEDriverServer.exe");
        System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.xjh.com");
        driver.findElement(By.xpath(".//*[@id='webmenu']/li[3]/a")).click();

        new Actions(driver).moveToElement(driver.findElement(By.linkText("品牌商家"))).build().perform();
        List<WebElement> brandBusList = driver.findElement(By.id("subBrand")).findElements(By.tagName("li"));
        if (brandBusList.size() > 0) {
            for (WebElement brandbus : brandBusList) {
                System.out.println(brandbus.findElement(By.className("arrow1")).getText());
            }
        }
        //driver.close();
    }
}
