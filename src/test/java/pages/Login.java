package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Webdriver;



public class Login {
    private static Logger logger = LoggerFactory.getLogger(Login.class);
    public static WebDriver driver = null;

    /*
     * Initializes the driver and opens the URL
     */
     public void getURL(){
        this.driver = Webdriver.webdriverInitialize();
        try {
            driver.get("https://www.exercise1.com/ValuesStepDef");
            logger.info("Fetched the given URL");
        }
        catch (Exception e){
            logger.error("Failed to navigate to the given URL");
        }
    }

}
