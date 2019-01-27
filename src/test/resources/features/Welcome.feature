@start

  Feature: Values and Total Balance

    Scenario: Verify all the values and the total amount

      Given I login into the official Page
      And verify there are "5" values appearing on the screen
      And verify the values on the screen are greater than "0"
      And verify the total balance is "$1,000,000.00"
      And verify the values are formatted as currencies
      And verify the total balance matches the sum of the values

