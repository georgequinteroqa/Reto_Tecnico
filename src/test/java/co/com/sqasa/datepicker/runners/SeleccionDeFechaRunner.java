/*
 * @(#) SeleccionDeFechaRunner.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Ejecuta el feature seleccion_de_fecha.feature (un runner por feature, lineamiento 7.3).
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/datepicker/seleccion_de_fecha.feature",
        glue = "co.com.sqasa.datepicker.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SeleccionDeFechaRunner {
}
