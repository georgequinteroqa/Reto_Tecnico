/*
 * @(#) EntrarAlMarcoDeLaDemostracion.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.com.sqasa.datepicker.models.EjemploDatepicker;

import java.time.Duration;

import static co.com.sqasa.datepicker.utils.ConstantesDatepicker.SEGUNDOS_ESPERA_MARCO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Espera a que el marco del ejemplo esté disponible y cambia el contexto del navegador a ese marco.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class EntrarAlMarcoDeLaDemostracion implements Interaction {

    private static final String SELECTOR_MARCO = "iframe.demo-frame[src*='%s']";
    private final EjemploDatepicker ejemplo;

    public EntrarAlMarcoDeLaDemostracion(EjemploDatepicker ejemplo) {
        this.ejemplo = ejemplo;
    }

    /**
     * Crea la interacción para entrar al marco de un ejemplo.
     *
     * @param ejemplo ejemplo cuyo marco se espera
     * @return la interacción instrumentada para el reporte
     */
    public static EntrarAlMarcoDeLaDemostracion delEjemplo(EjemploDatepicker ejemplo) {
        return instrumented(EntrarAlMarcoDeLaDemostracion.class, ejemplo);
    }

    @Override
    @Step("{0} entra al marco del ejemplo #ejemplo")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.switchTo().defaultContent();
        // La página reemplaza el marco al cambiar de ejemplo: se espera el marco que carga este ejemplo y se entra en él.
        By marcoDelEjemplo = By.cssSelector(String.format(SELECTOR_MARCO, ejemplo.getArchivoDemostracion()));
        new WebDriverWait(driver, Duration.ofSeconds(SEGUNDOS_ESPERA_MARCO))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(marcoDelEjemplo));
    }
}
