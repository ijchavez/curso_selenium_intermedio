Feature: Spotify Ejercicio Dos

  Scenario Outline: Mails en spotify
    Given Dentro de la pagina de spotify
    When Me registro con un <mail>
    Then valido los mensajes de <error>

    Examples:
      | mail             | error                                                                                                  |
      | ""               | "Es necesario que introduzcas tu correo electrónico."                                                  |
      | "ffff"           | "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com" |
      | "test@test.com"  | "Este correo electrónico ya está conectado a una cuenta. Inicia sesión."                               |