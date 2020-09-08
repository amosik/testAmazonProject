import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;
    String mainUrl = "https://www.amazon.com/";
    By TAB_BEST_SELLER = By.xpath("//a[text()='Best Sellers']");
    By TITLE = By.xpath("//h1");
    By SEARCH_FIELD = By.cssSelector("#twotabsearchtextbox");
    By BUTTON_SEARCH_LENS = By.cssSelector("input[type='submit'][value='Go']");
    String expectedBestSellerUrl = "https://www.amazon.com/gp/bestsellers/?ref_=nav_cs_bestsellers";
    String actualBestSellerUrl;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(mainUrl);
    }


    @Test
    public void searchField() {
        driver.findElement(SEARCH_FIELD).sendKeys("flowers");
        driver.findElement(BUTTON_SEARCH_LENS).click();
        //WebElement ti = driver.findElements(TITLE).get(0);
    }

    @Test
    public void bestSellerPage() {
        driver.findElement(TAB_BEST_SELLER).click();
        actualBestSellerUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualBestSellerUrl, expectedBestSellerUrl);
    }


    @AfterMethod
    public void afterActions() {
        driver.quit();
    }
}
