package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaFormulario;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValorTotalActualizado implements Question<Boolean> {

    public static ValorTotalActualizado enPantalla() {
        return new ValorTotalActualizado();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
            WaitUntil.the(PaginaFormulario.TOTAL_PRICE, isVisible()).forNoMoreThan(10).seconds()
        );
        return Visibility.of(PaginaFormulario.TOTAL_PRICE).answeredBy(actor);
    }
}
