Feature: Orange Tests

  Scenario Outline: Orange
    Given estoy en Orange
    When me logeo
    And estoy en la landing page
    Then veo la <opcion> en quick actions

    Examples:
      | opcion         |
      | Assign leave   |
      | Leave List     |
      | Leave Calendar |

    Scenario: Orange Pending Request
      Given estoy en Orange
      When me logeo
      And obtengo la cantidad de leave request to approve
      And ingreso a la seccion de leave requests
      Then la cantidad de elementos a desplegarse debe coincidir