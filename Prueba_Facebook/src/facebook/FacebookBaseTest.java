package facebook;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FacebookBaseTest {
	
	protected WebDriver driver;
	
	protected void setUp(String browser, String url) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.out.println("Starting the browser");
		System.setProperty("webdriver.chrome.driver","C:\\test_automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//Wait implicito de 15 segundos
	}
	
	@After
	public void tearDown() {		
		System.out.println("Destruye la configuracion");
		//driver.quit();
	}
	
	protected void valitedTagFaile(String nameFaile) {
		WebElement tag2 = driver.findElement(By.xpath("//a[@class='taggee']"));
		assertEquals(nameFaile,tag2.getText());//assertEquals verifica la coincidencia de un texto específico en un campo indicado en tag1 que es la etiqueta.
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//Whit implicito de 15 segundos
		
	}
	
		protected void valitedTag(String nameTag) {
		WebElement photo1 = driver.findElement(By.xpath("//div[@class='tagWrapper']"));//Expande la foto a etiquetar
		photo1.click();
		WebElement tag1 = driver.findElement(By.xpath("//a[@class='taggee']"));
		System.out.println(tag1.getText());//Imprime el texto obtenido de la ubicación
		assertEquals(nameTag,tag1.getText());//assertEquals verifica la coincidencia de un texto específico en un campo indicado en tag1 que es la etiqueta.
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//Whit implicito de 15 segundos
	}

	protected void gotoPhotos() {
		WebElement photos = driver.findElement(By.xpath("//a[@data-tab-key='photos']"));
		photos.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Wait implicito de 5 segundos
	}

	protected void searchFacebookFriend(String friendName) {
		WebElement persona1 = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		WebElement buscar = driver.findElement(By.xpath("//button[@data-testid='facebar_search_button']"));
		persona1.clear();//Se limpia el campo de busqueda
		persona1.sendKeys(friendName);//Se ingrsa el nombre a buscar
		buscar.submit();
		
		WebElement ira = driver.findElement(By.xpath("//div[@class='_52eh _5bcu']"));//Se ingresa al perfil
		ira.click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);//Wait implicito de 25 segundos
		
	}
	

	protected void logIntoFacebook(String user, String password) {
	    WebElement userBox = driver.findElement(By.id("email"));
	    WebElement pssBox = driver.findElement(By.id("pass"));
	    WebElement entrar = driver.findElement(By.xpath("//input[@value=\"Entrar\"]"));
	    
	    userBox.clear();
	    userBox.sendKeys(user);
	    pssBox.clear();
	    pssBox.sendKeys(password);
	    entrar.click();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//Wait implicito de 15 segundos
	}

}
