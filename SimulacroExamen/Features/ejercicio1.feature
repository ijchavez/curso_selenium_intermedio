Feature: Ejercicio uno

  Scenario Outline:  Viajes Airbnb 2personas distintos destinos
    Given estoy en la pagina de airbnb
    When busco alojamiento para <adultos> personas para <lugar>
    Then valido que <lugar> sea el lugar elegido y sea para <adultos> personas

    Examples:
      | adultos   | lugar   |
      | 2         | "París"   |
      | 2         | "Londres" |
      | 2         | "Lisboa"  |