/*
 * @(#) CalendarioVisible.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.CALENDARIO;

/**
 * Pregunta si el calendario emergente está a la vista.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class CalendarioVisible implements Question<Boolean> {

    /**
     * Crea la pregunta por la visibilidad del calendario.
     *
     * @return la pregunta
     */
    public static CalendarioVisible enPantalla() {
        return new CalendarioVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CALENDARIO.resolveFor(actor).isCurrentlyVisible();
    }
}
