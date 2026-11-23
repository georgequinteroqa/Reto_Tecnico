/*
 * @(#) SeleccionarDia.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import java.time.LocalDate;

import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.DIA_SELECCIONABLE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Selecciona un día habilitado del mes visible en el calendario.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class SeleccionarDia implements Interaction {

    private final LocalDate dteFecha;

    public SeleccionarDia(LocalDate dteFecha) {
        this.dteFecha = dteFecha;
    }

    /**
     * Crea la interacción para seleccionar el día de una fecha.
     *
     * @param dteFecha fecha a seleccionar
     * @return la interacción instrumentada para el reporte
     */
    public static SeleccionarDia de(LocalDate dteFecha) {
        return instrumented(SeleccionarDia.class, dteFecha);
    }

    @Override
    @Step("{0} selecciona el día #dteFecha")
    public <T extends Actor> void performAs(T actor) {
        // jQuery UI numera los meses de 0 a 11 en el atributo data-month.
        actor.attemptsTo(Click.on(DIA_SELECCIONABLE.of(
                String.valueOf(dteFecha.getMonthValue() - 1),
                String.valueOf(dteFecha.getYear()),
                String.valueOf(dteFecha.getDayOfMonth()))));
    }
}
