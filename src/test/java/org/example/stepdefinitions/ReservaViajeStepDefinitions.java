package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import org.example.model.DatosPersonales;
import org.example.model.DatosReserva;
import org.example.questions.MensajeReserva;
import org.example.tasks.*;
import net.serenitybdd.screenplay.actions.Open.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actions.Open.browserOn;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReservaViajeStepDefinitions {

    @Dado("el usuario esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio() {
        OnStage.theActorCalled("Usuario").wasAbleTo(
            browserOn().thePageNamed("pages.home")
        );
    }

    @Cuando("el usuario agenda un viaje con fecha ida {string}, fecha regreso {string}, {int} adultos, {int} ninos, destino {string}")
    public void agendarViaje(String fechaIda, String fechaRegreso, int adultos,
                             int ninos, String destino) {
        DatosReserva datos = DatosReserva.deViaje(fechaIda, fechaRegreso, String.valueOf(adultos), String.valueOf(ninos), "", destino);
        theActorInTheSpotlight().attemptsTo(
            AgendarViaje.con(datos)
        );
    }

    @Y("selecciona el destino {string}")
    public void seleccionarDestino(String destino) {
        theActorInTheSpotlight().attemptsTo(
            SeleccionarDestino.llamado(destino)
        );
    }

    @Y("carga mas destinos")
    public void cargarMasDestinos() {
        theActorInTheSpotlight().attemptsTo(
            CargarMasDestinos.ahora()
        );
    }

    @Y("filtra por precio {string} %")
    public void filtrarPorPrecio(String rangoPrecio) {
        theActorInTheSpotlight().attemptsTo(
            FiltrarPorPrecio.conRango(rangoPrecio)
        );
    }

    @Y("completa el formulario con nombre {string}, email {string}, ssn {string}, telefono {string}")
    public void completarFormulario(String nombre, String email, String ssn, String telefono) {
        DatosPersonales datos = DatosPersonales.delCliente(nombre, email, ssn, telefono);
        theActorInTheSpotlight().attemptsTo(
            CompletarFormulario.con(datos)
        );
    }

    @Y("adjunta el archivo {string}")
    public void adjuntarArchivo(String rutaArchivo) {
        theActorInTheSpotlight().attemptsTo(
            AdjuntarArchivo.desde(rutaArchivo)
        );
    }

    @Y("acepta los terminos")
    public void aceptarTerminos() {
        theActorInTheSpotlight().attemptsTo(
            AceptarTerminos.actuales()
        );
    }

    @Y("realiza el pago")
    public void realizarPago() {
        theActorInTheSpotlight().attemptsTo(
            RealizarPago.ahora()
        );
    }

    @Entonces("deberia ver el mensaje {string}")
    public void validarMensaje(String mensajeEsperado) {
        theActorInTheSpotlight().should(
            seeThat(MensajeReserva.esCorrecto(mensajeEsperado))
        );
    }

    @And("ingresa un codigo {string}")
    public void ingresaUnCodigo(String codigoPromocional)  {
        theActorInTheSpotlight().attemptsTo(IngresarCodigo.con(codigoPromocional));
    }
}
