/*
 * @(#) RangoDeFechasStepDefinitions.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import co.com.sqasa.datepicker.exceptions.FechaIncorrectaException;
import co.com.sqasa.datepicker.questions.DisponibilidadDeLaFecha;
import co.com.sqasa.datepicker.questions.ValorDelCampoFecha;
import co.com.sqasa.datepicker.tasks.AbrirElDatepicker;
import co.com.sqasa.datepicker.tasks.IntentarSeleccionarLaFecha;
import co.com.sqasa.datepicker.tasks.SeleccionarLaFecha;

import java.time.LocalDate;

import static co.com.sqasa.datepicker.models.EjemploDatepicker.RANGO_RESTRINGIDO;
import static co.com.sqasa.datepicker.utils.ConstantesDatepicker.FECHA_SELECCIONADA;
import static co.com.sqasa.datepicker.utils.ConstantesDatepicker.NOMBRE_ACTOR;
import static co.com.sqasa.datepicker.utils.FechaRelativa.aDiasDeHoy;
import static co.com.sqasa.datepicker.utils.FormatoFecha.formatearParaCampo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Pasos del feature rango_de_fechas: fechas dentro y fuera de un rango restringido.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class RangoDeFechasStepDefinitions {

    @Dado("que el usuario abre el formulario con un rango de fechas restringido")
    public void abrirElFormularioConRangoRestringido() {
        theActorCalled(NOMBRE_ACTOR).wasAbleTo(AbrirElDatepicker.enElEjemplo(RANGO_RESTRINGIDO));
    }

    @Cuando("selecciona la fecha que está a {int} días de hoy")
    public void seleccionarLaFechaADiasDeHoy(int intDias) {
        LocalDate dteFecha = aDiasDeHoy(intDias);
        theActorInTheSpotlight().remember(FECHA_SELECCIONADA, dteFecha);
        theActorInTheSpotlight().attemptsTo(SeleccionarLaFecha.del(dteFecha));
    }

    @Cuando("intenta seleccionar la fecha que está a {int} días de hoy")
    public void intentarSeleccionarLaFechaADiasDeHoy(int intDias) {
        LocalDate dteFecha = aDiasDeHoy(intDias);
        theActorInTheSpotlight().remember(FECHA_SELECCIONADA, dteFecha);
        theActorInTheSpotlight().attemptsTo(IntentarSeleccionarLaFecha.del(dteFecha));
    }

    @Entonces("la fecha queda registrada en el campo")
    public void verificarLaFechaRegistrada() {
        LocalDate dteFecha = theActorInTheSpotlight().recall(FECHA_SELECCIONADA);
        theActorInTheSpotlight().should(seeThat("el valor del campo de fecha", ValorDelCampoFecha.actual(),
                equalTo(formatearParaCampo(dteFecha)))
                .orComplainWith(FechaIncorrectaException.class, FechaIncorrectaException.FECHA_DENTRO_DE_RANGO_NO_SELECCIONABLE));
    }

    @Entonces("la fecha no está disponible para selección")
    public void verificarQueLaFechaNoEstaDisponible() {
        LocalDate dteFecha = theActorInTheSpotlight().recall(FECHA_SELECCIONADA);
        theActorInTheSpotlight().should(seeThat("la fecha se puede seleccionar", DisponibilidadDeLaFecha.de(dteFecha), is(false))
                .orComplainWith(FechaIncorrectaException.class, FechaIncorrectaException.FECHA_FUERA_DE_RANGO_SELECCIONABLE));
    }

    @Entonces("el campo de fecha permanece vacío")
    public void verificarQueElCampoSigueVacio() {
        theActorInTheSpotlight().should(seeThat("el valor del campo de fecha", ValorDelCampoFecha.actual(), is(emptyOrNullString()))
                .orComplainWith(FechaIncorrectaException.class, FechaIncorrectaException.CAMPO_MODIFICADO));
    }
}
