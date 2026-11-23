/*
 * @(#) AbrirElDatepicker.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import co.com.sqasa.datepicker.interactions.EntrarAlMarcoDeLaDemostracion;
import co.com.sqasa.datepicker.models.EjemploDatepicker;

import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.CAMPO_FECHA;
import static co.com.sqasa.datepicker.userinterfaces.PaginaDatepicker.ENLACE_EJEMPLO;
import static co.com.sqasa.datepicker.utils.ConstantesDatepicker.RUTA_DATEPICKER;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Abre la página del datepicker, elige el ejemplo y entra a su marco.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class AbrirElDatepicker implements Task {

    private final EjemploDatepicker ejemplo;

    public AbrirElDatepicker(EjemploDatepicker ejemplo) {
        this.ejemplo = ejemplo;
    }

    /**
     * Crea la tarea para abrir un ejemplo del datepicker.
     *
     * @param ejemplo ejemplo de la página que se quiere usar
     * @return la tarea instrumentada para el reporte
     */
    public static AbrirElDatepicker enElEjemplo(EjemploDatepicker ejemplo) {
        return instrumented(AbrirElDatepicker.class, ejemplo);
    }

    @Override
    @Step("{0} abre el datepicker en el ejemplo #ejemplo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.relativeUrl(RUTA_DATEPICKER),
                Click.on(ENLACE_EJEMPLO.of(ejemplo.getNombreEnlace())),
                EntrarAlMarcoDeLaDemostracion.delEjemplo(ejemplo),
                WaitUntil.the(CAMPO_FECHA, isVisible())
        );
    }
}
