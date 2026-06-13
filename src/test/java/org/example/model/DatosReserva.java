package org.example.model;

import org.example.questions.TextoAleatorio;
import org.example.ui.PaginaDestinos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public record DatosReserva(
    String fechaIda,
    String fechaRegreso,
    String adultos,
    String ninos,
    String rangoPrecio,
    String destino
) {
    public static DatosReserva deViaje(String fechaIda, String fechaRegreso, String adultos,
                                        String ninos, String rangoPrecio, String destino
                                        ) {
        return new DatosReserva(fechaIda, fechaRegreso, adultos, ninos, rangoPrecio, destino);
    }

    public static DatosReserva valor(String adultos,String ninos){
        String fechaIda = LocalDate.now()
                .plusDays(1)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String fechaRegreso = LocalDate.now()
                .plusDays(2)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String rangoPrecio="100";
        String destino= theActorInTheSpotlight().asksFor(TextoAleatorio.de(PaginaDestinos.CAMPO_TITULO_DESTINO));
        return new DatosReserva(fechaIda, fechaRegreso, adultos, ninos, rangoPrecio, destino);
    }
}
