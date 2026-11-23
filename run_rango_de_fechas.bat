@echo off
REM Ejecuta la funcionalidad rango_de_fechas (lineamiento 8.13).
cd /d %~dp0
if not exist gradlew.bat (
    echo No se encontro el archivo gradlew.bat en el directorio actual.
    pause
    exit /b 1
)
echo Ejecutando rango_de_fechas con Serenity y Gradle...
call gradlew.bat clean test --tests "co.com.sqasa.datepicker.runners.RangoDeFechasRunner"
if errorlevel 1 (
    echo La ejecucion de pruebas fallo. Revise target\site\serenity\index.html
) else (
    echo Pruebas ejecutadas correctamente. Reporte: target\site\serenity\index.html
)
pause
