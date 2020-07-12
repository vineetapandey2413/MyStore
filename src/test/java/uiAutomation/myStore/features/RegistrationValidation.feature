Feature: Validate the registration flow

@registrationSuccess,@Regression
Scenario Outline: Verify the registration success flow

Given User is in Authentication screen
When In Authentication section, user enters email address "<email>"
When User clicks on Create An Account button
Then User redirects to Create An Account page
And User enters personal information "<title>","<firstname>","<lastname>","<email>","<password>","<day>","<month>","<year>"
And User enters address details "<fn>","<ln>","<company>","<add1>","<add2>","<city>","<state>","<zipcode>","<country>"
And User enters additional info "<info>"
And User enters home phone "<homephone>"
And User enters mobile phone "<mobile>"
And User enters address alias "<alias>"
And User clicks on register button
Then User should be registered successfully

Examples:
|authemail		|title |firstname |lastname |email |password |day |month |year |fn|ln |company | add1 | add2 | city | state | zipcode | country | info | homephone | mobile | alias |
|vtest3@test.com|Mrs |vtesf |vtestl |vtest7u@test.com |test123 |24|9 |1990 |vtestf|ln |beb | PCMC | wegdr | Tumbe |3| 77077 |United States| my information | 1234569856 | 1523698789 | address |



