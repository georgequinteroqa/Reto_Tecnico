# Reto Técnico SQA · HU-001 Selección de fecha en un campo de formulario

Automatización web de la historia de usuario **HU-001** sobre el calendario emergente de
[jQuery UI Datepicker](https://jqueryui.com/datepicker/), con el patrón **Screenplay** de Serenity BDD.

## Priorización

Los casos de prueba se priorizaron con el formato oficial de SQA (hoja «Prioridad de nuevas automatizaciones»): [`docs/matriz-priorizacion`](docs/matriz-priorizacion). Se seleccionaron CP-003 y CP-005 (puntaje 0,82, prioridad Alta).

## Documento de entendimiento

Alcance, enfoque, riesgos, estrategia y estimación (55 horas) en el formato oficial de SQA: [`docs/documento-entendimiento`](docs/documento-entendimiento).

## Escenarios automatizados

| Feature | Escenario | Criterios de aceptación cubiertos |
|---|---|---|
| `seleccion_de_fecha.feature` | Mostrar el calendario emergente al hacer clic en el campo de fecha | CA1 |
| `seleccion_de_fecha.feature` | Selección de una fecha específica en un mes diferente al actual (3 ejemplos: +1, −2 y +14 meses) | CA2, CA3, CA4 |
| `rango_de_fechas.feature` | Seleccionar una fecha dentro del rango permitido (−20, 0 y +30 días) | CA2, CA3, CA6 |
| `rango_de_fechas.feature` | Una fecha fuera del rango permitido no se puede seleccionar (−21 y +45 días) | CA6 |

Las fechas se calculan a partir del día de ejecución, para que los datos de prueba no venzan.

## Tecnologías

| Elemento | Versión |
|---|---|
| Java | 21 |
| Gradle (wrapper) | 8.11.1 |
| Serenity BDD (core, screenplay, cucumber) | 4.2.34 |
| Cucumber | 7.22.2 (Gherkin en español) |
| Selenium | 4.33 (driver de Chrome gestionado por Selenium Manager) |
| JUnit | 4.13.2 |
| Navegador | Google Chrome |

## Estructura

```
src
├── main/java/co/com/sqasa/datepicker
│   ├── exceptions       Fallas de negocio y técnicas con mensajes claros
│   ├── interactions     Acciones de bajo nivel (entrar al marco, navegar meses, seleccionar/pulsar día)
│   ├── models           Ejemplos de la página que usa la automatización
│   ├── questions        Preguntas sobre el estado (valor del campo, mes visible, disponibilidad de una fecha)
│   ├── tasks            Acciones de negocio (abrir el datepicker, desplegar el calendario, seleccionar una fecha)
│   ├── userinterfaces   Localizadores de la página y del calendario
│   └── utils            Constantes y cálculo/formato de fechas
└── test
    ├── java/co/com/sqasa/datepicker
    │   ├── runners          Un runner por feature
    │   └── stepdefinitions  Pasos de cada feature y Hooks (preparación del escenario)
    └── resources
        ├── features/datepicker   Escenarios en Gherkin (español)
        └── serenity.conf         Configuración de Serenity y de ambientes
```

## Requisitos

- JDK 21 o superior en el `PATH` (`java -version`).
- Google Chrome instalado. No hace falta descargar el chromedriver.
- Acceso a internet para descargar las dependencias y abrir la página.

## Ejecución

Todas las pruebas:

```bat
gradlew.bat clean test
```

Por funcionalidad, con doble clic o desde la consola:

```bat
run_seleccion_de_fecha.bat
run_rango_de_fechas.bat
```

Opciones útiles:

```bat
gradlew.bat clean test -Dheadless.mode=true                  :: sin abrir la ventana de Chrome
gradlew.bat clean test -Dcucumber.filter.tags="@fechaOtroMes"   :: solo un grupo de escenarios
gradlew.bat clean test -Denvironment=qa                         :: otro ambiente de serenity.conf
```

## Evidencias y reportes

- Reporte de Serenity con captura por acción: `target/site/serenity/index.html`.
- Reporte compacto de una sola página: `target/site/serenity/serenity-summary.html`.
- Empaquetar el reporte: `gradlew.bat zipSerenityReport` → `target/site/serenity-report.zip`.
- Verificar que exista el reporte: `gradlew.bat verificarReporteSerenity`.

## Análisis estático (SonarQube)

El informe del análisis está en [`docs/sonarqube`](docs/sonarqube): puerta de calidad aprobada, sin incidencias. La cobertura no se mide porque el proyecto es en sí una automatización de pruebas (`sonar.coverage.exclusions`). Para repetirlo con un servidor SonarQube:

```bat
gradlew.bat sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.token=<token>
```

## Etiquetas

| Etiqueta | Uso |
|---|---|
| `@regresion` | Todos los escenarios (tipo de flujo) |
| `@HU-001` | Historia de usuario |
| `@calendarioEmergente`, `@fechaOtroMes`, `@fechaDentroDelRango`, `@fechaFueraDelRango` | Grupo de escenarios |
