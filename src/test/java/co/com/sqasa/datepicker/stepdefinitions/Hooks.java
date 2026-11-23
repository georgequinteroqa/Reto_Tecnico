/*
 * @(#) Hooks.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

/**
 * Prepara el escenario de Screenplay antes de cada escenario (lineamientos 8.9 y 8.12).
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class Hooks {

    /**
     * Crea el elenco de actores con navegador. Orden 0: infraestructura base.
     */
    @Before(order = 0)
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }
}
