Feature:View Product
  Scenario: Visitor wants to view product list
    Given I am a visitor
    When I search for a product
    Then the product list page will be displayed
