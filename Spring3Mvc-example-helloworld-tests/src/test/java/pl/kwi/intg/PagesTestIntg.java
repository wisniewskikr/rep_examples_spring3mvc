package pl.kwi.intg;


import java.io.File;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.jboss.shrinkwrap.resolver.api.maven.filter.ScopeFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Arquillian.class)
public class PagesTestIntg {
	
	
	private final static String PATH_HOST = System.getProperty("test.intg.path.host");
	private final static String PATH_CONTEXT = System.getProperty("test.intg.path.context");
	private final static String WAR_FILE = PATH_CONTEXT + ".war";

	private WebDriver driver;
	private Wait<WebDriver> wait;
	
	private InputPage inputPage;
	private OutputPage outputPage;
	
	
	@Deployment
    public static Archive<?> createDeployment() {
		
		MavenDependencyResolver resolver = DependencyResolvers
				.use(MavenDependencyResolver.class)
				.loadMetadataFromPom("pom.xml")
				.includeDependenciesFromPom("pom.xml");
		
        WebArchive war = ShrinkWrap.create(WebArchive.class, WAR_FILE)
        .addPackages(true, "pl.kwi")
        .addAsLibraries(resolver.resolveAsFiles(new ScopeFilter("", "compile", "runtime")))
        .addAsResource("conf/spring-conf.xml");
        
        addFilesToWar(war, new File("src/main/webapp"));
                
        return war;
        
    }
	
	
	@Before
	public void setUp(){
		
		driver = new HtmlUnitDriver();
		wait = new WebDriverWait(driver, 10);		
		
		inputPage = new InputPage(driver, wait);
		outputPage = new OutputPage(driver, wait);
		
	}
	
	@Test
	public void typeNameToInputPageAndCheckOutputPage() {
		
		driver.get(PATH_HOST + PATH_CONTEXT);
		
		inputPage.checkIfPageLoaded();
		inputPage.typeName("Chris");
		inputPage.pressButtonOk();
		
		outputPage.checkIfPageLoaded();
		outputPage.checkHelloWorldText("Chris");
		outputPage.pressButtonBack();
		
		inputPage.checkIfPageLoaded();
		
	}
	
	@Test
	public void typeNoNameToInputPage() {
		
		driver.get(PATH_HOST + PATH_CONTEXT);
		
		inputPage.checkIfPageLoaded();
		inputPage.typeName("");
		inputPage.pressButtonOk();
		
		inputPage.checkIfPageLoaded();
		inputPage.checkIfDisplayedNameValidationError();
		
	}
	
	
	// ****************************************************** //
	
	
	private static void addFilesToWar(WebArchive war, File dir) {
		
		try {
			
			if (!dir.isDirectory()) {
	            throw new Exception("not a directory");
	        }
	        for (File f : dir.listFiles()) {
	            if (f.isFile()) {
	                war.addAsWebResource(f, f.getPath().replace("\\", "/").substring("src/main/webapp/".length()));
	            } else {
	                addFilesToWar(war, f);
	            }
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
        
    }
	

}
