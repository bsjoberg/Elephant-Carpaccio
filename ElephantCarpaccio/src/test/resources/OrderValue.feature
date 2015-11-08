Feature: Display Order Value after Item Added
	As a retail shopper 
	I want to add items and get the total value 
	So that I know how much my stuff will cost before taxes
	
Scenario: Checkout one item for 400 dollars
	Given The price of "item one" is 400
	When I add "item one" to my cart
	Then the order value should be 400

Scenario: Checkout one item for 300 dollars
	Given The price of "item one" is 300
	When I add "item one" to my cart
	Then the order value should be 300
	
#Scenario: Checkout one item for 255.53 dollars
#	Given The price of "item one" is 255.53
#	When I add "item one" to my cart
#	Then the order value should be 255.53
	
#Scenario Outline: Checkout one item for different dollar amounts
#	Given The price of "item one" is <price>
#	When I add "item one" to my cart
#	Then the order value should be <total>
	
#	Examples
#	| price		| total		|
#	| 400		| 400		|
#	| 300		| 300 		|
#	| 255.53	| 255.53	|
	
#Scenario: Checkout two items of same price
#	Given The price of "item one" is $300
#	When I add "item one" to my cart
#	And I add "item two" to my cart
#	Then the order value should be $600