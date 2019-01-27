package definitions;

import cucumber.api.java.en.And;
import pages.TotalValues;

public class ValuesStepDef {
    TotalValues page = new TotalValues();

    @And ("verify there are \"([^\"]*)\" values appearing on the screen")
    public void verify_number_of_values(int num){
            page.numberOfValues(num);
    }

    @And ("verify the values on the screen are greater than \"([^\"]*)\"")
    public void values_greater_than_zero(int num){
            page.valuesGreaterThanZero(num);
    }

    @And ("verify the total balance is \"([^\"]*)\"")
    public void verify_total_balance(String total){
            page.totalBalance(total);
    }

    @And ("verify the values are formatted as currencies")
    public void verify_values_as_currencies(){
            page.checkFormat();
    }

    @And ("verify the total balance matches the sum of the values")
    public void total_balance_check(){
            page.totalbalanceCheck();
    }
}
