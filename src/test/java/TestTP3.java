import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

public class TestTP3 {

    WebDriver driver;

    @Before
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }

    @Test
    public void testEntrer()
    {
        HomePage homePage = new HomePage(driver);
        homePage.rechercheAvecEnter("Bordeaux");

        ResultsPage resultsPage = new ResultsPage(driver);
        String result = resultsPage.getResult(0);
        Assert.assertThat(result, is("Site officiel de la ville de Bordeaux | Bordeaux"));

        //ResultsPage resultsPage = new ResultsPage();
        //Assert.assertThat(resultsPage.getResult(0), is("Site officiel de la ville de Bordeaux | Bordeaux"));
    }

    @Test
    public void testClick()
    {
        HomePage homePage = new HomePage(driver);
        homePage.rechercheAvecClick("Bordeaux");

        ResultsPage resultsPage = new ResultsPage(driver);
        String result = resultsPage.getResult(0);
        Assert.assertThat(result, is("Site officiel de la ville de Bordeaux | Bordeaux"));

        /*ResultsPage resultsPage = new ResultsPage();
        Assert.assertThat(resultsPage.getResult(0), is("Site officiel de la ville de Bordeaux | Bordeaux"));

        */
    }
}
