Feature:Booking a hotel through RLH

Scenario Outline:Book a hotel
Description:book a hotel through quickbook 
Given user is on RLH website
When user enters "<location>"
Then choose hotel in entered location
Then select hotel from different options
Then Fill the form to book a hotel
And Get the price details
Examples:
	| location | 
	| Red lion hotel port angeles  | 
 