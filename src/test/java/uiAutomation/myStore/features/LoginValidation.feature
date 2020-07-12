Feature: Login feature 

@loginsuccess
Scenario Outline: Validate the login scenarios 

	Given User is in home page 
	When User clicks on Sign in link 
	When User enters the "<email>" and "<password>" 
	When User clicks on Sign in button 
	Then User should gets logged in successfully 
	
	Examples: 
		| email 		  |	password |
		|vtest@gmail.com |  test123 |