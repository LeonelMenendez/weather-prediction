# Weather Prediction
### Solar system premises:
* Planet Ferengi moves with an angular velocity of 1 degrees / day clockwise. Its distance from the sun is 500km.
*  Planet Betasoide moves with an angular velocity of 3 degrees / day clockwise. Its distance from the sun is 2000km.
*  Planet Vulcano moves with an angular velocity of 5 degrees / day counterclockwise. Its distance from the sun is 1000Km.
*  All orbits are circular.
* By default the planets begin on day zero with the following positions:
  * Ferengi (500, 0).
  * Betasoide (2000, 0).
  * Vulcano (1000, 0).
* The sun is at the position (0, 0).
* One year has 365 days.

### Weather prediction premises:
* Drought period if the planets are aligned between them and with the sun.
* Optimal pressure and temperature conditions period if the planets are aligned between them and with the sun.
* Rainy period if the planets are not aligned and the sun is inside the triangle formed by the planets.
* Indeterminable if none of the above conditions are met.

### Use examples:
* By day - **GET** https://weather-prediction.cfapps.io/api/clima?dia=0
* By period - **GET** https://weather-prediction.cfapps.io/api/clima/periodo?diaInicio=0&diaFin=3650

***

# Predicción del clima
### Premisas del sistema solar:
* El planeta Ferengi se desplaza con una velocidad angular de 1 grados/día en sentido horario. Su distancia con respecto al sol es de 500Km.
* El planeta Betasoide se desplaza con una velocidad angular de 3 grados/día en sentido horario. Su distancia con respecto al sol es de 2000Km.
* El planeta Vulcano se desplaza con una velocidad angular de 5 grados/día en sentido antihorario, su distancia con respecto al sol es de 1000Km.
* Todas las órbitas son circulares.
* Por defecto, los planetas comienzan el día cero con las siguientes posiciones:
  * Ferengi (500, 0).
  * Betasoide (2000, 0).
  * Vulcano (1000, 0).
* El sol se encuenta en la posición (0, 0).
* Un año tiene 365 días.

### Premisas de la predicción del clima:
* Período de sequía si los planetas están alineados entre ellos y con el sol.
* Período de condiciones óptimas de presión y temperatura si los planetas están alineados entre ellos y con el sol.
* Periodo lluvioso si los planetas no están alineados y el sol está dentro del triángulo formado por los mismos.
* Indeterminable si no se cumple ninguna de las condiciones anteriores.

### Ejemplos de uso:
* Por día - **GET** https://weather-prediction.cfapps.io/api/clima?dia=0
* Por período - **GET** https://weather-prediction.cfapps.io/api/clima/periodo?diaInicio=0&diaFin=3650