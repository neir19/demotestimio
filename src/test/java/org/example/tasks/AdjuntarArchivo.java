package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.example.interactions.CargarArchivo;
import org.example.ui.PaginaFormulario;

public class AdjuntarArchivo implements Task {
    private final String rutaArchivo;

    public AdjuntarArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public static AdjuntarArchivo desde(String rutaArchivo) {
        return new AdjuntarArchivo(rutaArchivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            CargarArchivo.en(PaginaFormulario.CAMPO_ARCHIVO,rutaArchivo)
        );
    }
}
