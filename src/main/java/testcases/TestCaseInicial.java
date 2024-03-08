package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseInicial {
  private WebDriver driver;
  
  private String baseUrl;

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Path\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  baseUrl = "https://www.google.es/";
  }

  @Test
  public void testCase() throws Exception {
	  //EMPEZAR CASO DE PRUEBA
	  driver.get(baseUrl);
	
	  //FIN DE CASO DE PRUEBA
	  System.out.println("FINALIZAMOS");
    
  }

  @After
  public void tearDown() throws Exception {
	  driver.quit();
  }

}
