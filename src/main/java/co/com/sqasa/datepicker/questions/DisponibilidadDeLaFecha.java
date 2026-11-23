/*
 * @(#) DisponibilidadDeLaFecha.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.LocalDate;
import java.time.YearMonth;

import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.CELDA_DIA;

/**
 * Pregunta si una fecha se puede seleccionar en el calendario: su mes está a la vista y el día está habilitado.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class DisponibilidadDeLaFecha implements Question<Boolean> {

    private static final String CLASE_DESHABILITADA = "ui-state-disabled";
    private final LocalDate dteFecha;

    public DisponibilidadDeLaFecha(LocalDate dteFecha) {
        this.dteFecha = dteFecha;
    }

    /**
     * Crea la pregunta por la disponibilidad de una fecha.
     *
     * @param dteFecha fecha a revisar
     * @return la pregunta
     */
    public static DisponibilidadDeLaFecha de(LocalDate dteFecha) {
        return new DisponibilidadDeLaFecha(dteFecha);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Si el calendario no pudo llegar al mes (botón deshabilitado por el rango), la fecha no es seleccionable.
        if (!MesVisible.enElCalendario().answeredBy(actor).equals(YearMonth.from(dteFecha))) {
            return false;
        }
        return !CELDA_DIA.of(String.valueOf(dteFecha.getDayOfMonth())).resolveFor(actor).hasClass(CLASE_DESHABILITADA);
    }
}
