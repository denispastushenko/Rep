import com.devcolibri.detabase.Connection_Class;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;
import java.sql.*;

public class InstagramTest {
    private  static String SITE = "https://www.instagram.com/";
    private  static String BITCH = "_sv.k_";
    private  static int scroll = 250;
    private WebDriver webDriver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Z:/Downloads/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void testTest() throws InterruptedException, IOException, AWTException {
        RegCheck check = new RegCheck();
        ImageDownload down = new ImageDownload();
        Robot r = new Robot();
        webDriver.get(SITE.concat(BITCH));
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0, 1000)", "");
        webDriver.findElement(By.xpath("//a[@class = '_oidfu']")).click();
        WebElement webElement = webDriver.findElement(By.xpath("//span[@class='_e8fkl']"));
        String elem = webElement.getText();
        System.out.println(elem);
        int rw = Integer.parseInt(elem.replaceAll(",", ""));
        while (rw > webDriver.findElements(By.xpath("//div[@class='_jjzlb']//img")).size()) {
            jse.executeScript(String.format("window.scrollBy(0,%d)", scroll += 250));
            r.mouseWheel(-1);
            Thread.sleep(500);
        }
        List<WebElement> webEl = webDriver.findElements(By.xpath("//div[@class='_jjzlb']/img"));
        Set<String> linkSet = new HashSet<>();
        for (WebElement el : webEl) {
            linkSet.add(check.Regchecking(el.getAttribute("src")));
        }
        for (String s : linkSet) {
            down.saver(s, ImageDownload.FILE_WAY);
        }
        linkSet.stream().forEach(out::println);
        System.out.println(linkSet.size());
    }
    @Test
    public void JDBS_Test() throws InterruptedException, IOException, AWTException, SQLException, ClassNotFoundException {
        RegCheck check = new RegCheck();
        Connection_Class con = new Connection_Class();
        Robot r = new Robot();
        webDriver.get(SITE.concat(BITCH));
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0, 1000)", "");
        webDriver.findElement(By.xpath("//a[@class = '_oidfu']")).click();
        WebElement webElement = webDriver.findElement(By.xpath("//span[@class='_e8fkl']"));
        String elem = webElement.getText();
        System.out.println(elem);
        int rw = Integer.parseInt(elem.replaceAll(",", ""));
        while (rw > webDriver.findElements(By.xpath("//div[@class='_jjzlb']//img")).size()) {
            jse.executeScript(String.format("window.scrollBy(0,%d)", scroll += 250));
            r.mouseWheel(-1);
            Thread.sleep(1000);
        }
        List<WebElement> webEl = webDriver.findElements(By.xpath("//div[@class='_jjzlb']/img"));
        Set<String> linkSet = new HashSet<>();
        for (WebElement el : webEl) {
            linkSet.add(check.Regchecking(el.getAttribute("src")));
        }
        for (String s : linkSet) {
            con.connectMethod(s);
            System.out.println(s);
        }
        linkSet.stream().forEach(out::println);
        System.out.println(linkSet.size());
    }
    @After
    public void shoutDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}