package ttt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.*;

public class TestTTTWeb extends SeleniumTestWrapper {

/*    @Test
    public void titleMatches() throws InterruptedException {
        Thread.sleep(5000);
        driver.get(baseUrl);
        Thread.sleep(5000);
        assertEquals("Page Title", driver.getTitle());
        Thread.sleep(5000);
    }*/

    @Test
    public void checkWinnerX() throws InterruptedException
    {
        driver.get(baseUrl);
        startGame();
        Thread.sleep(1000);

        WebElement element0 = findElement("0");
        Thread.sleep(1000);
        WebElement element1 = findElement("1");
        Thread.sleep(1000);
        WebElement element3 = findElement("3");
        Thread.sleep(1000);
        WebElement element2 = findElement("2");
        Thread.sleep(1000);
        WebElement element6 = findElement("6");
        Thread.sleep(2000);
        WebElement winner = driver.findElementById("GState");
        // assertEquals("X", element0.getText());
        // assertEquals("X", element3.getText());
        // assertEquals("X", element6.getText());
        assertEquals("Winner is 'X'", winner.getText());
    }

/*    @Test
    public void assertUpdatingNameChangesSpecificJoke() {
        driver.get(baseUrl + "/config.html");
        
        1. Fill in some name (first name, last name)
        2. Submit form.
        3. Assert that form notifies of success ("Name set as: ...")
        4. Navigate to page to get specific Joke
        5. Enter a specific joke number
        6. Assert the name is used in the joke.
  
    }      */

    public void startGame()
    {
        WebElement element = driver.findElementByClassName("newGame");
        element.click();
    }

    public WebElement findElement(String elem)
    {
        WebElement element = driver.findElementById(elem);
        element.click();

        return element;
    }
}