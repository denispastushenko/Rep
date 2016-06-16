import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebExample {
    private RemoteWebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Z:/Downloads/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void demo() throws InterruptedException {
        webDriver.get("https://www.youtube.com");
        webDriver.findElement(By.xpath("//input[@name ='search_query']")).sendKeys("Pranks with clowns");
        webDriver.findElement(By.xpath("//button[@class = 'yt-uix-button yt-uix-button-size-default yt-uix-button-default search-btn-component search-button']")).click();
        webDriver.findElement(By.xpath("//a[@href='/watch?v=WHZPEkZCqwA' and @dir]")).click();
        Thread.sleep(9000);
    }

    @Test
    public void logIn() throws IOException, InterruptedException, AWTException {
        Robot r = new Robot();
        webDriver.get("https://www.facebook.com");
        webDriver.findElement(By.id("email")).sendKeys("+380936781402");
        webDriver.findElement(By.id("pass")).sendKeys("1996baba");
        webDriver.findElement(By.xpath("//input[@value ='Log In']")).click();
        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_ESCAPE);
        webDriver.findElement(By.xpath("//div[@class='_586i']")).sendKeys("Денис Пастушенко");
        webDriver.findElement(By.xpath("//button[@class ='_42ft _4jy0 _4w98 _4jy3 _517h _51sy _4w97']")).click();
        webDriver.findElement(By.xpath("//div[@class='_5d-5']")).click();
        Thread.sleep(9000);
    }
    @After
    public void shoutDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}