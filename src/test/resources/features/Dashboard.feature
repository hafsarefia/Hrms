#Author: refia_hafsa@hotmail.com
Feature: Dashboard
	@dash
  Scenario: Dashboard menu view for admin
    When user is logged with valid admin credentials
    Then user _ dashboard menu is displayed
      | Admin | PIM | Leave | Time | Recruitment | Performance | Dashboard | Directory |
