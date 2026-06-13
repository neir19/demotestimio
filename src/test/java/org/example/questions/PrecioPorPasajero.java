package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.example.ui.PaginaFormulario;

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

    private double extraerValorNumerico(String texto) {
        if (texto == null || texto.isBlank()) {
            return 0;
        }
        return Double.parseDouble(texto.replaceAll("[^\\d.]", ""));
    }
}
