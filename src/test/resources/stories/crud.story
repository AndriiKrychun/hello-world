
Scenario: delete
Given defect
When I delete this defect
Then statusCode of delete request should be 200


Scenario: create

When I create new defect
Then statusCode of post request should be 200


