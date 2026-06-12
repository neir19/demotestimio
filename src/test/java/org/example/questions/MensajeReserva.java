package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.example.ui.PaginaConfirmacion;

public class MensajeReserva implements Question<Boolean> {
    private final String mensajeEsperado;

    public MensajeReserva(String mensajeEsperado) {
        this.mensajeEsperado = mensajeEsperado;
    }

    public static MensajeReserva esCorrecto(String mensajeEsperado) {
        return new MensajeReserva(mensajeEsperado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensajeActual = Text.of(PaginaConfirmacion.MENSAJE_CONFIRMACION).answeredBy(actor);
        return mensajeActual.equals(mensajeEsperado);
    }
}
