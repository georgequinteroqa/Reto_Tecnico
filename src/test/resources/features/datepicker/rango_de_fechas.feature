# language: es
@regresion @HU-001
Característica: Rango de fechas restringido en el calendario
  Como usuario de la aplicación
  quiero que el calendario solo me deje elegir fechas del rango permitido
  para no registrar fechas que el sistema no acepta

  Antecedentes:
    Dado que el usuario abre el formulario con un rango de fechas restringido

  @fechaDentroDelRango
  Esquema del escenario: Seleccionar una fecha dentro del rango permitido
    Cuando selecciona la fecha que está a <dias> días de hoy
    Entonces la fecha queda registrada en el campo

    Ejemplos:
      | dias |
      | -20  |
      | 0    |
      | 30   |

  @fechaFueraDelRango
  Esquema del escenario: Una fecha fuera del rango permitido no se puede seleccionar
    Cuando intenta seleccionar la fecha que está a <dias> días de hoy
    Entonces la fecha no está disponible para selección
    Y el campo de fecha permanece vacío

    Ejemplos:
      | dias |
      | -21  |
      | 45   |
