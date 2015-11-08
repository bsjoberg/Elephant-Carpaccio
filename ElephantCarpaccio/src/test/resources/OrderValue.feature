Feature: Display Order Value after Item Added
	As a retail shopper 
	I want to add items and get the total value 
	So that I know how much my stuff will cost before taxes
	
Scenario: Checkout one item
	Given The price of "item one" is $400
	When I add "item one" to my cart
	Then the order value should be $400
	
#Scenario: Checkout two items of same price
#	Given The price of "item one" is $300
#	And The price of "item two" is $300
#	When I add "item one" to my cart
#	And I add "item two" to my cart
#	Then the order value should be $600