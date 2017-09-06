# language: es

   Característica: Login a la aplicacion bancaria fallido


     Antecedentes:
     Dado que me conecte a la aplicacion

     Esquema del escenario: entramos a la aplicacion con usuario y contraseña incorrectas

     Cuando introduzco el Usuario <login> y la Contrasena <pass>

     Entonces saldra mensaje de error y no entraremos en la aplicacion

Ejemplos:
      |login|pass|
      |"64026203E"|"Pepepotamo"|
      |""|""|
      |""|"Pepepotamo"|
      |"64026203E"|""|