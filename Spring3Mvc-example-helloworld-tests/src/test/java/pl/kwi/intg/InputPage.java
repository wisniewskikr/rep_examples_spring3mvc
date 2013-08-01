package pl.kwi.intg;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class InputPage {
	
	
	private WebDriver driver;
	private Wait<WebDriver> wait;
	private String text;
	private String title;
	
	
	public InputPage(WebDriver driver, Wait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void checkIfPageLoaded() {
		
		// Wait
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("title"), "Hello World"));
        
        // Conditions
        title = driver.getTitle();
        assertEquals("Hello World - Input", title);
        text = driver.findElement(By.id("title")).getText();
        assertEquals("Hello World", text); 
		
	}
	
	public void typeName(String name) {
		driver.findElement(By.id("name")).sendKeys(name);
	}
	
	public void pressButtonOk() {
		driver.findElement(By.id("ok")).click();
	}
	
	public void checkIfDisplayedNameValidationError() {
		text = driver.findElement(By.id("name.errors")).getText();
		assertEquals("Please fill this field", text);
	}
	

}
