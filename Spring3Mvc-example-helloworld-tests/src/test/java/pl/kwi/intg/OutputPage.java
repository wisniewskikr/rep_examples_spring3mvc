package pl.kwi.intg;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class OutputPage {
	
	
	private WebDriver driver;
	private Wait<WebDriver> wait;
	private String text;
	private String title;
	
	
	public OutputPage(WebDriver driver, Wait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void checkIfPageLoaded() {
		
		// Wait
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("title"), "Hello World"));
        
        // Conditions
        title = driver.getTitle();
        assertEquals("Hello World - Output", title);
        text = driver.findElement(By.id("title")).getText();
        assertEquals("Hello World", text); 
		
	}
	
	public void checkHelloWorldText(String name) {
		text = driver.findElement(By.id("name")).getText();
        assertEquals("Hello World " + name, text);
	}
	
	public void pressButtonBack() {
		driver.findElement(By.id("back")).click();
	}
	

}
