package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by szcheng on 2017/10/23.
 */
public class addAgent {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "D:/我的文档/WeChat Files/qqhycbs/Files/geckodriver.exe");
        //System.setProperty("webdriver.ie.driver","src/com/test/lib/IEDriverServer.exe");
        System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new InternetExplorerDriver();
       // WebDriverWait  wait= new WebDriverWait(driver,10);
        login(driver);
        add(driver);
        //selectDataGe("")
    }
    public static void login(WebDriver driver){
        WebDriverWait  wait= new WebDriverWait(driver,10);
        driver.get("http://10.148.181.126:8080/hpaySupport/auth/showLogin.action");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("szcheng@handpay.com.cn");
        driver.findElement(By.id("password")).sendKeys("china76!");
        driver.findElement(By.id("otpCode")).sendKeys("888888");
        driver.findElement((By.className("btn-primary"))).click();

    }
    public static void add(WebDriver driver) throws InterruptedException{
        WebDriverWait wait= new WebDriverWait(driver,30);
        driver.findElement(By.xpath("//div[@id='remarkMessage']/div[3]/button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.first-menu:nth-child(1)")));
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("li.first-menu:nth-child(1)")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.second-menu:nth-child(1)")));
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("li.second-menu:nth-child(1)")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sub_li_a_1280")));
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".sub_li_a_1280")).click();
        driver.switchTo().frame("iframe_main"); //左侧目录节点与右侧新增列表不是同一个iframe，需先从左侧跳转到右侧的iframe中
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("certificateMail")));
        driver.findElement(By.id("certificateMail")).sendKeys("csz测试");
        driver.findElement(By.id("customerServiceEmail")).sendKeys("2267407637@qq.com");
        Select selectAgent= new Select(driver.findElement(By.id("agentType"))); 
        selectAgent.selectByIndex(1);
        driver.findElement(By.id("proxyAgentArea")).sendKeys("上海");
        driver.findElement(By.id("corpFullName")).sendKeys("瀚银科技");
        driver.findElement(By.id("corpShortName")).sendKeys("瀚银");
        driver.findElement(By.id("corpAddress")).sendKeys("蒙自路763号");
        driver.findElement(By.id("faxNumber")).sendKeys("65268110");
        driver.findElement(By.id("registerNumber")).sendKeys("Hpay8888");
        driver.findElement(By.id("registerAddress")).sendKeys("上海黄浦");
        driver.findElement(By.id("businessContractsName")).sendKeys("张三");
        Thread.sleep(3000); 
        driver.findElement(By.id("registerImage")).sendKeys("E:\\123.png");
        driver.findElement(By.cssSelector("#file > button:nth-child(2)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".hp_alert_show_btn")).click();
        driver.findElement(By.id("businessContractsMobile")).sendKeys("021-83943782");
        driver.findElement(By.id("businessContractsEmail")).sendKeys("szhang@handpay.com.cn");
        driver.findElement(By.id("expireTime")).click();
        driver.switchTo().defaultContent();  //从当前的iframe中跳出
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[6]/iframe")));//切换到日期控件的iframe中
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".Wselday")).click();
        driver.switchTo().defaultContent(); //从日期控件的iframe中跳出
        driver.switchTo().frame("iframe_main"); //返回到之前的iframe
        driver.findElement(By.id("agentCode")).sendKeys("handpay1102");
        Thread.sleep(3000); 
        driver.findElement(By.id("agentLogoImage")).sendKeys("C:\\Users\\szcheng\\Desktop\\1102.png");
        driver.findElement(By.cssSelector("#agentLogoFile > button:nth-child(2)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".hp_alert_show_btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#businessDevelopmentName_chosen > a:nth-child(1)")).click();
        WebElement target = driver.findElement(By.cssSelector("li.active-result:nth-child(2)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", target);//下拉浏览器的滚动条至“业务联系人”选择框处
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("li.active-result:nth-child(2)")).click();
        Select selectBank= new Select(driver.findElement(By.id("accountBankName"))); 
        selectBank.selectByVisibleText("工商银行");
        driver.findElement(By.id("accountBankCardNo")).sendKeys("6212261001982370202");
        driver.findElement(By.id("accountName")).sendKeys("李四");
        driver.findElement(By.id("accountBranchName")).sendKeys("中国工商银行黄浦分行");
        driver.findElement(By.cssSelector("#agentModelType_chosen > a:nth-child(1)")).click();
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#agentModelType_chosen > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2)")));
        driver.findElement(By.cssSelector("#agentModelType_chosen > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2)"));
        driver.findElement(By.id("agentInsureFee")).sendKeys("1000");
        driver.findElement(By.id("shieldFlag")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#productName_chosen > a:nth-child(1)")).click();
        //WebElement we = driver.findElement(By.cssSelector("#productName_chosen > div:nth-child(2)"));
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",we);
        //((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //String js = "var q=document.documentElement.scrollTop=10000";
        //((JavascriptExecutor)driver).executeScript(js);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("li.active-result:nth-child(5)")).click();
    }
}