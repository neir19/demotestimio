package org.example.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.Wait;
import org.example.questions.UsuarioLogueado;
import org.example.tasks.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InicioSesionStepDefinitions {

    @Dado("que el usuario se encuentra en la página de inicio de sesión")
    public void enLaPaginaDeInicio() {
        theActorCalled("Usuario").wasAbleTo(
                Open.browserOn().thePageNamed("pages.home")
        );
    }

    @Cuando("ingresa {string} y {string}")
    public void iniciarSesion(String usuario, String contrasena) {
        theActorInTheSpotlight().attemptsTo(
                Login.con(usuario, contrasena)
        );
    }

    @Entonces("debe mostrar el usuario logueado")
    public void validarUsuarioLogueado() {
        theActorInTheSpotlight().should(
                seeThat(UsuarioLogueado.enPantalla())
        );
    }
}
