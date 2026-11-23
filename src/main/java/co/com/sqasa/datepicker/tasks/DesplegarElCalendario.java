/*
 * @(#) DesplegarElCalendario.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.CALENDARIO;
import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.CAMPO_FECHA;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Hace clic en el campo de fecha y espera el calendario emergente.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class DesplegarElCalendario implements Task {

    /**
     * Crea la tarea para desplegar el calendario del campo de fecha.
     *
     * @return la tarea instrumentada para el reporte
     */
    public static DesplegarElCalendario delCampoFecha() {
        return instrumented(DesplegarElCalendario.class);
    }

    @Override
    @Step("{0} despliega el calendario del campo de fecha")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CAMPO_FECHA),
                WaitUntil.the(CALENDARIO, isVisible())
        );
    }
}
