package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaLogin;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UsuarioLogueado implements Question<Boolean> {

    public static UsuarioLogueado enPantalla() {

        return new UsuarioLogueado();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(WaitUntil.the(PaginaLogin.MENSAJE_BIENVENIDA,isVisible()).forNoMoreThan(5).seconds());
        System.out.println("fin");
        return Visibility.of(PaginaLogin.MENSAJE_BIENVENIDA).answeredBy(actor);

    }
}
