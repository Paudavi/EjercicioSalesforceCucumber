#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: Salesforce exercise
  I want to use this template for my feature file
  
  Background: Entering Salesforce with a user
	Given Initilize browser with chorme and going to Salesforce
 	When User enters "paudavi@ola.com" and "olapaula123	" and logs in
 
 
  @TestOne
  Scenario: Navigates windows
  Then Navigates windows of service page
    
   @TestTwo
   Scenario Outline: Creating accounts in service page
   Given entering service page
   Then user creates <account> with <valoracion>,<customer>,<propiedad>,<sector>, <priority>,<SLA>,<opp>, <bin>, <wantedMonth>, <wantedDay>
  	Examples:
   |account	|valoracion	|customer	|propiedad	|sector	|priority	|SLA	|opp	|bin	|	wantedMonth	|wantedDay	|
   |Cuenta1	|Hot	|Prospect	|Public	|Banking	|Low	|Silver	|No	|No	| agosto|	20|
   |Cuenta2	|Cold	|Customer - Channel	|Subsidiary	|Chemicals	|High	|Bronze	|Yes	|No	| julio|	12|
   
   @TestThree
   Scenario: Creating empty account
   Given entering service page
   Then user creates an empty account
   
   @TestFour
   Scenario Outline: Creating and modifying contacts for new accounts
   Given entering service page
   And going to <account>, creating a new contact with <name> and <surname>
   Then modifying existing contact "Tipo" to <value1>
   And modifying other contact with this number "1431655766" of employees
  
   
   Examples:
   |account	|name	|surname	|value0	|value1	|
   |Cuenta2	|Pau	|Davi	|Other	|Customer - Direct	|
    
 