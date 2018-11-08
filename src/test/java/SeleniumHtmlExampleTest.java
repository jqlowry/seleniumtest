
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumHtmlExampleTest {
    @Test
    public static void testCallJuice() {
        // turn off htmlunit warnings
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

        System.out.println("********************");
        System.out.println("*   Testing HTML");
        System.out.println("********************");
        // Create a new instance of the HTML driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.


        WebDriver driver = new HtmlUnitDriver();

        //WebDriver driver = new HtmlUnitDriver();
        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");
        // Check the title of the page
        System.out.println("********************");
        System.out.println("*   Page title is: " + driver.getTitle());
        System.out.println("********************");

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
        System.out.println("********************");
        System.out.println("*   Page title is: " + driver.getTitle());
        System.out.println("********************");

        //Get list of search result strings.
        List<WebElement> allSearchResults=driver.findElements(By.cssSelector("ol li h3>a"));

        //Iterate the above list to get all the search titles & links from that page.
        for(WebElement eachResult : allSearchResults) {
            System.out.println("Title : " + eachResult.getText() + ", Link : " + eachResult.getAttribute("href"));
        }

        //Close the browser
        driver.quit();

    }
}
