package org.example.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import org.example.interactions.IngresarValorPrecio;
import org.example.interactions.ValidarValores;
import org.example.questions.PreciosFiltrados;
import org.example.tasks.CargarMasDestinos;
import org.example.tasks.FiltrarPorPrecio;
import org.example.ui.PaginaDestinos;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class FiltrarPorPrecioStepDefinitions {

    @Dado("que el usuario se encuentra en la seccion de seleccion de destinos")
    public void enLaSeccionDeDestinos() {
        theActorCalled("Usuario").wasAbleTo(
            Open.browserOn().thePageNamed("pages.home")
        );
        theActorInTheSpotlight().attemptsTo(
            CargarMasDestinos.ahora()
        );
        System.out.println(
                "Thread: " +
                        Thread.currentThread().getName()
        );
    }

    @Cuando("el usuario ajusta el filtro de precio maximo a {string} dolares")
    public void ajustarFiltroPrecio(String precioMaximo) {
        theActorInTheSpotlight().attemptsTo(
                IngresarValorPrecio.con(precioMaximo)
        );
    }

    @Entonces("todos los resultados de viajes mostrados deben tener un costo menor o igual a {string} dolares")
    public void validarPreciosFiltrados(String precioMaximo) {
            theActorInTheSpotlight().attemptsTo(ValidarValores.de(precioMaximo));
    }
}
