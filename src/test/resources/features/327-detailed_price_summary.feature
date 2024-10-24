@327
Feature: View a detailed price summary

  User Story:
  As a user, I want to see detailed price summaries when
  I select different pricing options, to help me make an informed decision in step 2.

  Scenario Outline: User should see a detailed price summary
    Given the user is on the enrollment page "<program code>"
    When the user completes step one with valid information "<firstName>", "<lastName>", "<emailAddress>", "<phone>", "<howDidYouHearAboutUs>", "<parentFirstName>", "<parentLastName>", "<parentEmailAddress>", "<parentPhone>"
    Then the user is on the step two of the enrollment process
    When the user clicks on any accordion
    Then the accordion should expand to open the price details
    And price details for each price type follow the data provided
    And each price summary must say "excluding fees" at the end

    Examples:
      | program code | firstName | lastName | emailAddress     | phone      | howDidYouHearAboutUs | parentFirstName | parentLastName | parentEmailAddress | parentPhone |
      | taws         | Faruk     | Boran    | boran@gmail.com  | 1231231234 | Google               | Esma            | Boran          | eboran@gmail.com   | 4321321321  |
      | rfep         | Sureya    | Boran    | sureya@gmail.com | 1234567890 | Facebook             | Teze            | Kennedy        | teze@gmail.com     | 12347494944 |
      | jfft         | Faruk     | Boran    | boran@gmail.com  | 1231231234 | Google               | Esma            | Boran          | eboran@gmail.com   | 4321321321  |
      | jss          | Sureya    | Boran    | sureya@gmail.com | 1234567890 | Facebook             | Teze            | Kennedy        | teze@gmail.com     | 12347494944 |