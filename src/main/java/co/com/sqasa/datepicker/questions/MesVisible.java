/*
 * @(#) MesVisible.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.LocalDate;
import java.time.YearMonth;

import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.ANIO_VISIBLE;
import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.MES_VISIBLE;
import static co.com.sqasa.datepicker.utils.FormatoFecha.leerMesVisible;

/**
 * Pregunta qué mes y año muestra el calendario emergente.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class MesVisible implements Question<YearMonth> {

    /**
     * Crea la pregunta por el mes visible.
     *
     * @return la pregunta
     */
    public static MesVisible enElCalendario() {
        return new MesVisible();
    }

    /**
     * Crea la pregunta de si el calendario muestra el mes de una fecha.
     *
     * @param dteFecha fecha cuyo mes se busca
     * @return la pregunta
     */
    public static Question<Boolean> esElDe(LocalDate dteFecha) {
        return Question.about("el calendario muestra el mes de " + dteFecha)
                .answeredBy(actor -> enElCalendario().answeredBy(actor).equals(YearMonth.from(dteFecha)));
    }

    @Override
    public YearMonth answeredBy(Actor actor) {
        return leerMesVisible(MES_VISIBLE.resolveFor(actor).getText(), ANIO_VISIBLE.resolveFor(actor).getText());
    }
}
