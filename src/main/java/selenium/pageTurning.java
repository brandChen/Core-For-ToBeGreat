//package selenium;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//
///**
// * Created by szcheng on 2017/10/17.
// */
//public class pageTurning {
//
//    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver", "D:/selenium/geckodriver.exe");
//        System.setProperty("webdriver.firefox.bin", "D:/soft/Mozilla Firefox/firefox.exe");
//        WebDriver driver = new FirefoxDriver();
//        search(driver);
//        int page_number = 0;
//        for (page_number = 2; page_number <= 100; page_number++) {
//            next_page(driver,page_number);
//
//        }
//    }
//    public static void search(WebDriver driver){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        driver.get("https://www.taobao.com/");
//        driver.findElement(By.id("q")).sendKeys("美食");
//        driver.findElement(By.className("btn-search")).click();
//        WebElement page = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("total")));
//        String count = page.getText();
//        count = count.substring(1,5);
//        System.out.println(count);
//    }
//    @SuppressWarnings("deprecation")
//	public static void next_page(WebDriver driver,int page_number){
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("J_Input")));
//            WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("J_Submit")));
//            input.clear();
//            input.sendKeys(page_number+"");
//            submit.click();
//            wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector("span.num"),page_number+""));
//        }catch (TimeoutException e){
//            next_page(driver,page_number);
//        }
//    }
//}
