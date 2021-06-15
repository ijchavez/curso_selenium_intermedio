Feature: Outlined Scenarios

  Scenario Outline: Compras
    Given tengo <valor_inicial> dolares
    When gasto <valor_compra> dolares
    Then me sobran <valor_final> dolares

    Examples:
      | valor_inicial | valor_compra | valor_final |
      | 10            | 5            | 5           |
      | 20            | 8            | 12          |
      | 120           | 20           | 100         |

  Scenario Outline: Buscar Usernames
    Given estoy en un sitio web
    And me encuentro en la pagina principal
    When busco el nombre de usuario <username>
    Then recibo el mensaje <mensaje>

    Examples:
      | username   | mensaje                       |
      | marcus     | No se encuentra en el sistema |
      | Rox123     | Nombre de usuario invalido    |
      | Mariangela | Nombre de usuario valido      |
      | JuanP      | Nombre de usuario inactivo    |


  Scenario Outline:  Spotify Email validations
    Given estoy en la pagina de registro de spotify
    When completo el campo email con <email>
    Then se muestra el mensaje <mensaje>

    Examples:
      | email         | mensaje                                                                                              |
      | test@test.com | Este correo electrónico ya está conectado a una cuenta                                               |
      | @@@@.com      | Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com |
      |               | Es necesario que introduzcas tu correo electrónico.                                                  |
      |