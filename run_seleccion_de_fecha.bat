@echo off
REM Ejecuta la funcionalidad seleccion_de_fecha (lineamiento 8.13).
cd /d %~dp0
if not exist gradlew.bat (
    echo No se encontro el archivo gradlew.bat en el directorio actual.
    pause
    exit /b 1
)
echo Ejecutando seleccion_de_fecha con Serenity y Gradle...
call gradlew.bat clean test --tests "co.com.sqasa.datepicker.runners.SeleccionDeFechaRunner"
if errorlevel 1 (
    echo La ejecucion de pruebas fallo. Revise target\site\serenity\index.html
) else (
    echo Pruebas ejecutadas correctamente. Reporte: target\site\serenity\index.html
)
pause
