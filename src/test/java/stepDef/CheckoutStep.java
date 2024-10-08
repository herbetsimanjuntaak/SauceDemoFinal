package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CheckoutPage;

public class CheckoutStep {

    CheckoutPage checkoutPage = new CheckoutPage();

    @And("User clicks on the Checkout button")
    public void userClicksOnTheCheckoutButton() throws InterruptedException {
        checkoutPage.clickCheckoutButton();
    }

    @And("User fills out the checkout information with first name {string}, last name {string}, and postal code {string}")
    public void userFillsOutTheCheckoutInformationWithFirstNameLastNameAndPostalCode(String firstName, String lastName, String postalCode) {
        checkoutPage.fillInformation(firstName,lastName,postalCode);
    }

    @And("User continues to the next step")
    public void userContinuesToTheNextStep() {
        checkoutPage.clickButtonContinue();
    }

    @Then("User should see a summary of their order")
    public void userShouldSeeASummaryOfTheirOrder() {
        checkoutPage.pageSummary();

    }

    @And("User should see the total price including tax")
    public void userShouldSeeTheTotalPriceIncludingTax() {
        checkoutPage.totalPriceTax();
    }

    @When("User finishes the checkout")
    public void userFinishesTheCheckout() {
        checkoutPage.userFinishesTheCheckout();
    }

    @Then("User should see the order confirmation page with the message {string}")
    public void userShouldSeeTheOrderConfirmationPageWithTheMessage(String confirmationMessage) {
        checkoutPage.userShouldSeeOrderConfirmation(confirmationMessage);
    }

    @And("User tries to continue to the next step")
    public void userTriesToContinueToTheNextStep() {
        checkoutPage.clickButtonContinue();
    }
}
