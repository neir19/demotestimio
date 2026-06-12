package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaFormulario;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class RealizarPago implements Task {

    public static RealizarPago ahora() {
        return new RealizarPago();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Scroll.to(PaginaFormulario.BOTON_PAGAR),
            WaitUntil.the(PaginaFormulario.BOTON_PAGAR, isEnabled()).forNoMoreThan(30).seconds(),
            Click.on(PaginaFormulario.BOTON_PAGAR)
        );
    }
}
