/*
 * @(#) SeleccionarLaFecha.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import co.com.sqasa.datepicker.interactions.NavegarAlMes;
import co.com.sqasa.datepicker.interactions.SeleccionarDia;

import java.time.LocalDate;
import java.time.YearMonth;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Selecciona una fecha con el calendario emergente: lo despliega, navega hasta su mes y elige el día.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class SeleccionarLaFecha implements Task {

    private final LocalDate dteFecha;

    public SeleccionarLaFecha(LocalDate dteFecha) {
        this.dteFecha = dteFecha;
    }

    /**
     * Crea la tarea para seleccionar una fecha.
     *
     * @param dteFecha fecha a seleccionar
     * @return la tarea instrumentada para el reporte
     */
    public static SeleccionarLaFecha del(LocalDate dteFecha) {
        return instrumented(SeleccionarLaFecha.class, dteFecha);
    }

    @Override
    @Step("{0} selecciona la fecha #dteFecha en el calendario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DesplegarElCalendario.delCampoFecha(),
                NavegarAlMes.de(YearMonth.from(dteFecha)),
                SeleccionarDia.de(dteFecha)
        );
    }
}
