Feature: Slotegrator Test Suite UI
  Scenario: Check authentication
    Given Open auth page
    When Auth with default user
    Then Verification Main page has been loaded

  Scenario: Open players list
    Given Open page and auth with default user
    When Open menu item - 'Users' and section 'Players'
    Then Verification Player management page has been loaded

  Scenario: Open players list and sort
    Given Open page and auth with default user
    When Open menu item - 'Users' and section 'Players'
    Then Verification Player management page has been loaded
    And Sort players table by Username and verify sorting successful