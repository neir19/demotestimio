package org.example.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.example.model.DatosPasajero;
import org.example.questions.PrecioPorPasajero;
import org.example.questions.ValorTotalActualizado;
import org.example.tasks.AgregarPasajeros;
import org.example.tasks.CargarMasDestinos;
import org.example.tasks.SeleccionarVuelo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CalculoTarifasStepDefinitions {

    private int pasajerosEsperados;

    @Dado("que el usuario selecciono un vuelo disponible")
    public void queElUsuarioSeleccionoUnVueloDisponible() {
        theActorCalled("Usuario").wasAbleTo(
            Open.browserOn().thePageNamed("pages.home")
        );
    }

    @Cuando("agrega {int} pasajeros a la reserva")
    public void agregaPasajerosALaReserva(int cantidadPasajeros) {
        this.pasajerosEsperados = cantidadPasajeros;
        DatosPasajero dato = DatosPasajero.deReserva(cantidadPasajeros);
        theActorInTheSpotlight().attemptsTo(
            AgregarPasajeros.aLaReserva(dato),
            CargarMasDestinos.ahora()
        );
    }

    @Entonces("el sistema debe actualizar el valor total")
    public void elSistemaDebeActualizarElValorTotal() {
        theActorInTheSpotlight().should(
            seeThat(ValorTotalActualizado.enPantalla())
        );
    }

    @Entonces("el precio debe corresponder a la cantidad de pasajeros seleccionados")
    public void elPrecioDebeCorresponderALaCantidadDePasajerosSeleccionados() {
        theActorInTheSpotlight().should(
            seeThat(PrecioPorPasajero.correspondeA(pasajerosEsperados))
        );
    }
}
