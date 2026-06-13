package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import org.example.Utils.Utils;
import org.example.ui.PaginaFormulario;
import static org.example.Utils.Utils.extraerValorNumerico;

public class PrecioPorPasajero implements Question<Boolean> {
    private final int pasajerosEsperados;

    public PrecioPorPasajero(int pasajerosEsperados) {
        this.pasajerosEsperados = pasajerosEsperados;
    }

    public static PrecioPorPasajero correspondeA(int pasajerosEsperados) {
        return new PrecioPorPasajero(pasajerosEsperados);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(Scroll.to(PaginaFormulario.PRICE_PER_PASSENGER));
        String totalTexto = Text.of(PaginaFormulario.TOTAL_PRICE).answeredBy(actor);
        String unitarioTexto = Text.of(PaginaFormulario.PRICE_PER_PASSENGER).answeredBy(actor);

        double total = extraerValorNumerico(totalTexto);
        double unitario = extraerValorNumerico(unitarioTexto);

        if (total <= 0 || unitario <= 0) {
            return false;
        }

        double esperado = unitario * pasajerosEsperados;
        return Math.abs(total - esperado) < 0.01;
    }


}
