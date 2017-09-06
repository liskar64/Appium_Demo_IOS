# language: es

   Característica: Consulta del saldo bancario


     Antecedentes:
     Dado que me conecte a la aplicacion

     Esquema del escenario: una vez logados correctamente consultamos el saldo de las cuentas

     Cuando introduzco el Usuario <login> y la Contrasena <pass>

     Y pulso en cuenta

     Entonces veremos el saldo de la cuenta

Ejemplos:
      |login|pass|
      |"64026203E"|"Ibermatica"|
