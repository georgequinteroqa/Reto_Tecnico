/*
 * @(#) IntentarSeleccionarLaFecha.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import co.com.sqasa.datepicker.interactions.NavegarAlMes;
import co.com.sqasa.datepicker.interactions.PulsarDia;
import co.com.sqasa.datepicker.questions.DisponibilidadDeLaFecha;

import java.time.LocalDate;
import java.time.YearMonth;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Intenta seleccionar una fecha que puede estar fuera del rango: despliega el calendario, navega hasta donde lo deje y pulsa el día solo si el calendario lo ofrece como disponible.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class IntentarSeleccionarLaFecha implements Task {

    private final LocalDate dteFecha;

    public IntentarSeleccionarLaFecha(LocalDate dteFecha) {
        this.dteFecha = dteFecha;
    }

    /**
     * Crea la tarea para intentar seleccionar una fecha.
     *
     * @param dteFecha fecha que se intenta seleccionar
     * @return la tarea instrumentada para el reporte
     */
    public static IntentarSeleccionarLaFecha del(LocalDate dteFecha) {
        return instrumented(IntentarSeleccionarLaFecha.class, dteFecha);
    }

    @Override
    @Step("{0} intenta seleccionar la fecha #dteFecha")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DesplegarElCalendario.delCampoFecha(),
                NavegarAlMes.de(YearMonth.from(dteFecha)),
                Check.whether(DisponibilidadDeLaFecha.de(dteFecha))
                        .andIfSo(PulsarDia.de(dteFecha))
        );
    }
}
