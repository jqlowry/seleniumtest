
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium2ExampleTest {
    @Test
    public static void testCallCheese() {
        System.out.println("Testing");
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.

        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        System.out.println(System.getProperty("webdriver.gecko.driver"));

        WebDriver driver = new FirefoxDriver();

        //WebDriver driver = new HtmlUnitDriver();
        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.close();


        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        System.out.println(System.getProperty("webdriver.chrome.driver"));

        WebDriver chromeDriver = new ChromeDriver();

        //WebDriver driver = new HtmlUnitDriver();
        // And now use this to visit Google
        chromeDriver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement chromeElement = chromeDriver.findElement(By.name("q"));

        // Enter something to search for
        chromeElement.sendKeys("Juice!");

        // Now submit the form. WebDriver will find the form for us from the element
        chromeElement.submit();

        // Check the title of the page
        System.out.println("Page title is: " + chromeDriver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(chromeDriver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("juice!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + chromeDriver.getTitle());

        //Close the browser
        chromeDriver.close();
    }
}
