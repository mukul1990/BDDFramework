package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class CheckOutStepDefinition {

	
	public TestContextSetup testContextSetup;
	
	public CheckOutStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@When("^Added \"([^\"]*)\" items of the selected products into the cart$")
	public void added_items_of_the_selected_products_into_the_cart(String quantity)
	{
		int q=Integer.parseInt(quantity);
		testContextSetup.pageObjectManager.landingpage.AddItemToCart(q);
	}

	@Then("User proceeds to checkout and validate the Tom items on checkout page")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_on_checkout_page() {
	    // Write code here that turns the phrase above into concrete actions
	   testContextSetup.pageObjectManager.getcheckoutPage().checkoutProduct();
	}

	@Then("verify user has the ability to enter promo code and place the order")
	public void verify_user_has_the_ability_to_enter_promo_code_and_place_the_order() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 testContextSetup.pageObjectManager.checkoutPage.verifyPromoCode("rahulshettyacademy");
		 Thread.sleep(3000);
		 Assert.assertTrue(testContextSetup.pageObjectManager.getcheckoutPage().getPromoMessage().contains("Code applied"));
		 testContextSetup.pageObjectManager.getcheckoutPage().placeOrder();
	}
}
