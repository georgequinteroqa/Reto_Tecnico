/*
 * @(#) SeleccionDeFechaStepDefinitions.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import co.com.sqasa.datepicker.exceptions.FechaIncorrectaException;
import co.com.sqasa.datepicker.questions.CalendarioVisible;
import co.com.sqasa.datepicker.questions.ValorDelCampoFecha;
import co.com.sqasa.datepicker.tasks.AbrirElDatepicker;
import co.com.sqasa.datepicker.tasks.DesplegarElCalendario;
import co.com.sqasa.datepicker.tasks.SeleccionarLaFecha;

import java.time.LocalDate;

import static co.com.sqasa.datepicker.models.EjemploDatepicker.FUNCIONALIDAD_BASICA;
import static co.com.sqasa.datepicker.utils.ConstantesDatepicker.FECHA_SELECCIONADA;
import static co.com.sqasa.datepicker.utils.ConstantesDatepicker.NOMBRE_ACTOR;
import static co.com.sqasa.datepicker.utils.FechaRelativa.delMesRelativo;
import static co.com.sqasa.datepicker.utils.FormatoFecha.formatearParaCampo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Pasos del feature seleccion_de_fecha: calendario emergente y fecha en un mes diferente al actual.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class SeleccionDeFechaStepDefinitions {

    @Dado("que el usuario abre el formulario con el campo de fecha")
    public void abrirElFormularioConElCampoDeFecha() {
        theActorCalled(NOMBRE_ACTOR).wasAbleTo(AbrirElDatepicker.enElEjemplo(FUNCIONALIDAD_BASICA));
    }

    @Cuando("hace clic en el campo de fecha")
    public void hacerClicEnElCampoDeFecha() {
        theActorInTheSpotlight().attemptsTo(DesplegarElCalendario.delCampoFecha());
    }

    @Entonces("se muestra el calendario emergente")
    public void verificarElCalendarioEmergente() {
        theActorInTheSpotlight().should(seeThat("el calendario emergente está visible", CalendarioVisible.enPantalla(), is(true))
                .orComplainWith(FechaIncorrectaException.class, FechaIncorrectaException.CALENDARIO_NO_VISIBLE));
    }

    @Cuando("selecciona el día {int} del mes que está a {int} meses del actual")
    public void seleccionarElDiaDelMesRelativo(int intDia, int intMeses) {
        LocalDate dteFecha = delMesRelativo(intMeses, intDia);
        theActorInTheSpotlight().remember(FECHA_SELECCIONADA, dteFecha);
        theActorInTheSpotlight().attemptsTo(SeleccionarLaFecha.del(dteFecha));
    }

    @Entonces("el campo de fecha muestra la fecha seleccionada en formato mes, día y año")
    public void verificarLaFechaEnElCampo() {
        LocalDate dteFecha = theActorInTheSpotlight().recall(FECHA_SELECCIONADA);
        theActorInTheSpotlight().should(seeThat("el valor del campo de fecha", ValorDelCampoFecha.actual(),
                equalTo(formatearParaCampo(dteFecha)))
                .orComplainWith(FechaIncorrectaException.class, FechaIncorrectaException.FECHA_NO_REFLEJADA));
    }
}
