
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumHtmlExampleTest {
    @Test
    public static void testCallJuice() {
        System.out.println("Testing HTML");
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.

        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        //System.out.println(System.getProperty("webdriver.ie.driver"));
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless","--no-sandbox","--disable-dev-shm-usage");

        WebDriver driver = new HtmlUnitDriver();

        //WebDriver driver = new HtmlUnitDriver();
        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Water!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("water!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.close();

    }
}
