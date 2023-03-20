Feature: Search and place the order for products

@checkout
Scenario Outline: Placing order for products Experience

Given User is on GreenCart Landing page
When user search with short productName <Name> and actual product is found on home page
And Added "3" items of the selected products into the cart
Then User proceeds to checkout and validate the <Name> items on checkout page
And verify user has the ability to enter promo code and place the order

Examples:
|Name|
|Tom|

