# language: es
@regresion @HU-001
Característica: Selección de fecha en un campo de formulario
  Como usuario de la aplicación
  quiero seleccionar una fecha desde un calendario emergente en el campo de entrada
  para evitar errores al ingresar fechas manualmente

  Antecedentes:
    Dado que el usuario abre el formulario con el campo de fecha

  @calendarioEmergente
  Escenario: Mostrar el calendario emergente al hacer clic en el campo de fecha
    Cuando hace clic en el campo de fecha
    Entonces se muestra el calendario emergente

  @fechaOtroMes
  Esquema del escenario: Selección de una fecha específica en un mes diferente al actual
    Cuando selecciona el día <dia> del mes que está a <meses> meses del actual
    Entonces el campo de fecha muestra la fecha seleccionada en formato mes, día y año

    Ejemplos:
      | meses | dia |
      | 1     | 15  |
      | -2    | 10  |
      | 14    | 28  |
