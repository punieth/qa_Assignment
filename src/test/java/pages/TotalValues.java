package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import static oracle.jrockit.jfr.events.Bits.intValue;
import static pages.Login.driver;

public class TotalValues {

    private static Logger logger = LoggerFactory.getLogger(Login.class);

    /*
     * Converts the US Dollar amount to string representation of the value
     */
    public static BigDecimal parse(final String amount) throws ParseException {
        final NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        ((DecimalFormat) format).setParseBigDecimal(true);
        return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
    }

    /*
     * Checks whether there are num ValuesStepDef appearing on the screen
     */

    public void numberOfValues(int num) {
        List<WebElement> valuesPresent = null;
        try {
            valuesPresent = driver.findElements(By.id("txt_val"));
        } catch (Exception e) {
            logger.error("Unable to find the webelements");
        }
        Assert.assertEquals(num, valuesPresent.size());

    }

    /*
     * Checks the ValuesStepDef on the screen are greater than num here
     */
    public void valuesGreaterThanZero(int num) {
        try {
            List<WebElement> valuesPresent = driver.findElements(By.id("txt_val"));
            for (int i = 0; i < valuesPresent.size(); i++) {
                String value = valuesPresent.get(i).getText();
                int actualValue = intValue(parse(value));
                Assert.assertTrue(actualValue > num);
            }
        } catch (Exception e) {
            logger.error("Unable to find the webelements and validate");
        }
    }

    /*
     * Checks the total balance
     */
    public void totalBalance(String total) {
        try {
            String totalValue = driver.findElement(By.id("txt_ttl_val")).getText();
            int actualValue = intValue(parse(totalValue));
            Assert.assertEquals(actualValue, total);
        } catch (Exception e) {
            logger.error("Unable to find the webelements and validate");
        }
    }

    /*
     * Checks whether the ValuesStepDef are in the Currency format (US)
     */

    public void checkFormat() {
        try {
            List<WebElement> valuesPresent = driver.findElements(By.id("txt_val"));
            for (int i = 0; i < valuesPresent.size(); i++) {
                String currency = valuesPresent.get(i).getText();
                int value = Integer.parseInt(currency);
                char a_char = currency.charAt(0);
                Assert.assertEquals(a_char, "$");
                NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
                String formattedNumber = format.format(value);
                Assert.assertEquals(value, formattedNumber);
            }
        } catch (Exception e) {
            logger.error("Unable to find the webelements and validate");

        }
    }

    /*
     * Checks whether total balance matches the sum of all the ValuesStepDef
     */

    public void totalbalanceCheck(){
        int number = 0;
        try {
            List<WebElement> valuesPresent = driver.findElements(By.id("txt_val"));
            for (int i = 0; i < valuesPresent.size(); i++) {
                String values = valuesPresent.get(i).getText();
                int actualValue = intValue(parse(values));
                number += actualValue;

                String totalValue = driver.findElement(By.id("txt_ttl_val")).getText();
                int FinalValue = intValue(parse(totalValue));
                Assert.assertEquals(number, FinalValue);

            }
        } catch (Exception e) {
            logger.error("Unable to find the webelements and validate");
        }
    }
}
