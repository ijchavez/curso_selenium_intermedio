Feature: Spotify Ejercicio Tres

  Scenario Outline: End User Agreement
    Given cuando entro a la pagina de spotify
    When abro una nueva pestaña para entrar a <pagina>
    Then valido que se encuentren los siguientes <textos>

    Examples:
      |pagina                                                | textos                                        |
      | "https://www.spotify.com/uy/legal/end-user-agreement/"| "Disfrutando Spotify"                         |
      | "https://www.spotify.com/uy/legal/end-user-agreement/"| "Pagos, cancelaciones y periodo de reflexión" |
      | "https://www.spotify.com/uy/legal/end-user-agreement/"| "Uso de nuestro servicio"                     |