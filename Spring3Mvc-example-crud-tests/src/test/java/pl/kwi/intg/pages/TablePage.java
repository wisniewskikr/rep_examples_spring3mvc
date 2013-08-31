package pl.kwi.intg.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import pl.kwi.intg.utils.AbstrIntgTestPage;

public class TablePage extends AbstrIntgTestPage {

	public TablePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
	}

	@Override
	public void checkIfPageLoaded() {
		
		// Wait
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("titleText"), "Hello World"));
        
        // Conditions
        title = driver.getTitle();
        assertEquals("Hello World - Table", title);
        text = driver.findElement(By.id("titleText")).getText();
        assertEquals("Hello World", text); 

	}

}
