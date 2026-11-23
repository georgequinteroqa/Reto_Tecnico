/*
 * @(#) NavegarAlMes.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import co.com.sqasa.datepicker.exceptions.NavegacionCalendarioException;
import co.com.sqasa.datepicker.questions.MesVisible;

import java.time.YearMonth;

import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.BOTON_MES_ANTERIOR;
import static co.com.sqasa.datepicker.userinterfaces.CalendarioEmergente.BOTON_MES_SIGUIENTE;
import static co.com.sqasa.datepicker.utils.ConstantesDatepicker.MAXIMO_CLICS_NAVEGACION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Avanza o retrocede el calendario mes a mes hasta el mes pedido. Se detiene si el rango de fechas no deja seguir.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class NavegarAlMes implements Interaction {

    private static final String CLASE_DESHABILITADA = "ui-state-disabled";
    private final YearMonth ymMesObjetivo;

    public NavegarAlMes(YearMonth ymMesObjetivo) {
        this.ymMesObjetivo = ymMesObjetivo;
    }

    /**
     * Crea la interacción para llegar a un mes.
     *
     * @param ymMesObjetivo mes y año al que se quiere llegar
     * @return la interacción instrumentada para el reporte
     */
    public static NavegarAlMes de(YearMonth ymMesObjetivo) {
        return instrumented(NavegarAlMes.class, ymMesObjetivo);
    }

    @Override
    @Step("{0} navega en el calendario hasta #ymMesObjetivo")
    public <T extends Actor> void performAs(T actor) {
        int intClics = 0;
        YearMonth ymMesActual = MesVisible.enElCalendario().answeredBy(actor);
        while (!ymMesActual.equals(ymMesObjetivo)) {
            Target botonDireccion = ymMesActual.isBefore(ymMesObjetivo) ? BOTON_MES_SIGUIENTE : BOTON_MES_ANTERIOR;
            WebElementFacade boton = botonDireccion.resolveFor(actor);
            if (boton.hasClass(CLASE_DESHABILITADA)) {
                return;
            }
            intClics++;
            if (intClics > MAXIMO_CLICS_NAVEGACION) {
                throw new NavegacionCalendarioException("El calendario no llegó a " + ymMesObjetivo
                        + " después de " + MAXIMO_CLICS_NAVEGACION + " clics");
            }
            boton.click();
            ymMesActual = MesVisible.enElCalendario().answeredBy(actor);
        }
    }
}
