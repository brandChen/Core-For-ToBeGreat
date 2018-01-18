//package selenium;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.List;
//
///**
// * Created by Administrator on 2017/9/13.
// */
//public class shoppingCart {
//    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver", "D:/selenium/geckodriver.exe");
//        System.setProperty("webdriver.firefox.bin", "D:/soft/Mozilla Firefox/firefox.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.get("http://www.xjh.com");
//        driver.findElement(By.id("keywords")).clear();
//        driver.findElement(By.id("keywords")).sendKeys("鍗曡偐鍖�");
//        driver.findElement(By.id("keywordsSearch")).findElement(By.tagName("img")).click();
//        // Wait
//        new WebDriverWait(driver, 10).until(
//                ExpectedConditions.presenceOfElementLocated(By.className("search_content_c")));
//
//        // 鍒ゆ柇锛�
//        // 1. 鏄惁鏈変笢瑗�
//        // 2. 鏈夛紝鍙栧嚭閾炬帴
//        List<WebElement> itemList = driver.findElements(By.className("commodity_display_b"));
//        if (itemList.size() > 0) {
//            WebElement item = itemList.get(0);
//            String href =item.findElement(By.xpath("div/a")).getAttribute("href");
//            //item.findElement(By.xpath("div/a/img")).click();
//            driver.navigate().to(href);
//
//            // Wait
//            new WebDriverWait(driver, 10).until(
//                    ExpectedConditions.presenceOfElementLocated(By.className("g_jiaru")));
//          /*new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>(){
//              @Override
//              public Boolean apply(WebDriver d) {
//                    return d.getCurrentUrl().contains("goodsDetail");
//              }});*/
//            driver.findElement(By.className("g_jiaru")).click();
//        } else {
//            throw new NoSuchElementException("娌℃湁鎵惧埌");
//        }
//    }
//}
