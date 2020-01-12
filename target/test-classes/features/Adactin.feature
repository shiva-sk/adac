Feature: To Validate Whole Booking process

  Scenario Outline: To verify obtained Booking OrderNo
    Given Launch into https://adactin.com/HotelApp/
    When Provide The Required "<userName>","<password>" in Login Page
    And Provide "<Location>","<Hotels>","<Type>","<Children>" and click search
    And Click RadioButton and Submit
    And Provide "<FirstName>","<LastName>","<BillingAddress>","<CType>","<Month>" and click Booknow
    Then Print the OrderNo
    And Exit the browser

    Examples: 
      | userName   |  | password |  | Location |  | Hotels        |  | Type   |  | Children |  | FirstName |  | LastName |  | BillingAddress |  | CType        |  | Month |
      | shivask127 |  | OAZ65Z   |  | Sydney   |  | Hotel Cornice |  | Deluxe |  | 1 - One  |  | siva      |  | kumar    |  | OMR,Chennai    |  | Master Card |  | May   |
