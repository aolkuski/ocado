package steps;

import core.UiTestBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.OcadoHomePage;
import pages.OffersPage;


public class LoggedInUserPromoConditionsSteps extends UiTestBaseClass {
    OcadoHomePage homePage;
    OffersPage offerPage;

    @Given("^a logged in customer$")
    public void a_logged_in_customer() throws Throwable {
        homePage = new OcadoHomePage().getHomePage().registerAnyCustomer();
    }

    @When("^Offers page is displayed$")
    public void offers_page_is_displayed() throws Throwable {
        homePage.navigateToOffers();
    }

    @Then("^add items met promo conditions to trolley$")
    public void add_items_met_promo_conditions_to_trolley() throws Throwable {
        int productsQuantity = 2;
        offerPage = new OffersPage();

        String productsName = offerPage.addFirstProductsToTrolley(productsQuantity);

        offerPage.goToTrolley().assertProductsAdded(productsName, productsQuantity);
    }

}
