Feature: Application Login

Scenario: Home page default login
Given User is on landing page
When User logs into the application using username "John" and password "Doe"
Then Home page is populated
And Cards are displayed

Scenario: Home page default login
Given User is on landing page
When User logs into the application using username "Jane" and password "Doe"
Then Home page is populated
And Cards are displayed