/*
 * @(#) ValorDelCampoFecha.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.CAMPO_FECHA;

/**
 * Pregunta qué texto tiene el campo de fecha.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class ValorDelCampoFecha implements Question<String> {

    /**
     * Crea la pregunta por el valor del campo de fecha.
     *
     * @return la pregunta
     */
    public static ValorDelCampoFecha actual() {
        return new ValorDelCampoFecha();
    }

    @Override
    public String answeredBy(Actor actor) {
        return CAMPO_FECHA.resolveFor(actor).getValue();
    }
}
