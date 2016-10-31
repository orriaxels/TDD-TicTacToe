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
        Thread.sleep(600);
        WebElement element0 = findElement("0");
        Thread.sleep(600);
        WebElement element1 = findElement("1");
        Thread.sleep(600);
        WebElement element3 = findElement("3");
        Thread.sleep(600);
        WebElement element2 = findElement("2");
        Thread.sleep(600);
        WebElement element6 = findElement("6");
        Thread.sleep(600);
        WebElement winner = driver.findElementById("GState");
        assertEquals("Winner is 'X'", winner.getText());
    }

    @Test
    public void checkWinnerO() throws InterruptedException
    {
        driver.get(baseUrl);
        startGame();
        Thread.sleep(600);
        WebElement element0 = findElement("0");
        Thread.sleep(600);
        WebElement element1 = findElement("1");
        Thread.sleep(600);
        WebElement element2 = findElement("2");
        Thread.sleep(600);
        WebElement element4 = findElement("4");
        Thread.sleep(600);
        WebElement element8 = findElement("8");
        Thread.sleep(600);
        WebElement element7 = findElement("7");
        Thread.sleep(600);
        WebElement winner = driver.findElementById("GState");
        assertEquals("Winner is '0'", winner.getText());
    }

    @Test
    public void checkDraw() throws InterruptedException
    {
        driver.get(baseUrl);
        startGame();
        Thread.sleep(600);
        WebElement element0 = findElement("0");
        Thread.sleep(600);
        WebElement element1 = findElement("1");
        Thread.sleep(600);
        WebElement element2 = findElement("2");
        Thread.sleep(600);
        WebElement element4 = findElement("4");
        Thread.sleep(600);
        WebElement element8 = findElement("8");
        Thread.sleep(600);
        WebElement element6 = findElement("6");
        Thread.sleep(600);
        WebElement element3 = findElement("3");
        Thread.sleep(600);
        WebElement element5 = findElement("5");
        Thread.sleep(600);
        WebElement element7 = findElement("7");
        Thread.sleep(600);

        WebElement winner = driver.findElementById("GState");
        assertEquals("Its a Draw", winner.getText());
    }         

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