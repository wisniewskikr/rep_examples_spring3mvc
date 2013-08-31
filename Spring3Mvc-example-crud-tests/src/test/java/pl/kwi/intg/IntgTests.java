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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pl.kwi.intg.pages.TablePage;
import pl.kwi.intg.utils.IntgTestUtils;

@RunWith(Arquillian.class)
public class IntgTests {
	
	
	private final static String PATH_HOST = System.getProperty("test.intg.path.host");
	private final static String PATH_CONTEXT = System.getProperty("test.intg.path.context");
	private final static String WAR_FILE = PATH_CONTEXT + ".war";
	
	private TablePage tablePage;
	
	
	@Deployment
    public static Archive<?> createDeployment() {
		
		MavenDependencyResolver resolver = DependencyResolvers
				.use(MavenDependencyResolver.class)
				.loadMetadataFromPom("pom.xml")
				.includeDependenciesFromPom("pom.xml");
		
        WebArchive war = ShrinkWrap.create(WebArchive.class, WAR_FILE)
        .addPackages(true, "pl.kwi")
        .addAsLibraries(resolver.resolveAsFiles(new ScopeFilter("", "compile", "runtime")))
        .addAsResource("conf/spring-conf.xml")
        .addAsResource("conf/spring-db.xml");
        
        IntgTestUtils.addFilesToWar(war, new File("src/main/webapp"));
                
        return war;
        
    }
	
	
	@Before
	public void setUp(){
		
		WebDriver driver = new HtmlUnitDriver();
		Wait<WebDriver> wait = new WebDriverWait(driver, 10);		
		
		tablePage = new TablePage(driver, wait);
		
	}
	
	@Test
	public void createTestCase() {
		
		tablePage.initBrowserByUrl(PATH_HOST + PATH_CONTEXT);
		
		tablePage.checkIfPageLoaded();
		
	}
	

}
