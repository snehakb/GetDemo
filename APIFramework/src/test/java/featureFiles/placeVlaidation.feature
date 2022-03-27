Feature: Validation Maps API

@AddPlace
Scenario Outline: Validate the wheather add place api is adding the place
Given the body for addingPlace with "<name>" "<Language>" "<address>"
When User send the "AddPlaceApi" from "Post" method
Then API call should be success and status will be 200
And "Status" in response will be "OK"
And "scope" in response will be "APP"
And verify the Placeid created maps to "<name>" using "getPlaceAPI"

Examples: 
       |name|Language|address|
       |Abhi|Kannada|Dharwad|
       |Sneha|English|Hubli|
       
       
@DeletePlace      
Scenario: Check DeleteAPI is working
Given DeletePlace Payload
When User send the "DeletePlaceAPI" from "Post" method 
Then API call should be success and status will be 200  
And "Status" in response will be "OK" 