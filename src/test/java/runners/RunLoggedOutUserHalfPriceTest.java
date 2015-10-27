package runners;

import core.UiTestBaseClass;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        glue = "steps",
        features = "classpath:promo/loggedOutCustomer_halfPrice.feature")
public class RunLoggedOutUserHalfPriceTest extends UiTestBaseClass {


}
