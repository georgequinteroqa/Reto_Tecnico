/*
 * @(#) PulsarDia.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import java.time.LocalDate;

import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.CELDA_DIA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Pulsa el día de una fecha en el calendario, esté habilitado o no, para comprobar cómo responde.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class PulsarDia implements Interaction {

    private final LocalDate dteFecha;

    public PulsarDia(LocalDate dteFecha) {
        this.dteFecha = dteFecha;
    }

    /**
     * Crea la interacción para pulsar el día de una fecha del mes visible.
     *
     * @param dteFecha fecha cuyo día se pulsa
     * @return la interacción instrumentada para el reporte
     */
    public static PulsarDia de(LocalDate dteFecha) {
        return instrumented(PulsarDia.class, dteFecha);
    }

    @Override
    @Step("{0} pulsa el día #dteFecha en el calendario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CELDA_DIA.of(String.valueOf(dteFecha.getDayOfMonth()))));
    }
}
