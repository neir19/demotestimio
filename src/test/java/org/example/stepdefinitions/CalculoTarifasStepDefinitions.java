package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.example.model.DatosPasajero;
import org.example.model.DatosReserva;
import org.example.questions.PrecioPorPasajero;
import org.example.questions.TextoAleatorio;
import org.example.questions.ValorTotalActualizado;
import org.example.tasks.*;
import org.example.ui.PaginaDestinos;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class CalculoTarifasStepDefinitions {

    

    @Dado("que el usuario selecciono un vuelo disponible")
    public void queElUsuarioSeleccionoUnVueloDisponible() {
        theActorCalled("Usuario").wasAbleTo(
            Open.browserOn().thePageNamed("pages.home")
        );
    }



    @Entonces("el sistema debe actualizar el valor total")
    public void elSistemaDebeActualizarElValorTotal() {
        theActorInTheSpotlight().should(
            seeThat(ValorTotalActualizado.enPantalla())
        );
    }




    @Cuando("agrega {} pasajeros y {} ninos a la reserva")
    public void agregaPasajerosYNinosALaReserva(String arg0, String arg1) {
        DatosReserva datos = DatosReserva.valor( String.valueOf(arg0), String.valueOf(arg1));
        theActorInTheSpotlight().attemptsTo(
                AgendarViaje.con(datos));
        String destino= theActorInTheSpotlight().asksFor(TextoAleatorio.de(PaginaDestinos.CAMPO_TITULO_DESTINO));
        theActorInTheSpotlight().attemptsTo(
                SeleccionarDestino.llamado(destino));
    }

    @Y("el precio debe corresponder a la cantidad de pasajeros  {} pasajeros y {} ninos seleccionados")
    public void elPrecioDebeCorresponderALaCantidadDePasajerosPasajerosYNinosSeleccionados(int arg0, int arg1) {
        theActorInTheSpotlight().should(
                seeThat(PrecioPorPasajero.correspondeA(arg0+arg1))
        );

    }
}
