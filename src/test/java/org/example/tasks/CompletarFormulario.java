package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.example.interactions.IngresarValorReact;
import org.example.model.DatosPersonales;
import org.example.ui.PaginaFormulario;

public class CompletarFormulario implements Task {
    private final DatosPersonales datos;

    public CompletarFormulario(DatosPersonales datos) {
        this.datos = datos;
    }

    public static CompletarFormulario con(DatosPersonales datos) {
        return new CompletarFormulario(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            IngresarValorReact.en(PaginaFormulario.CAMPO_NOMBRE, datos.nombre()),
            IngresarValorReact.en(PaginaFormulario.CAMPO_EMAIL, datos.email()),
            IngresarValorReact.en(PaginaFormulario.CAMPO_SSN, datos.socialSecurityNumber()),
            IngresarValorReact.en(PaginaFormulario.CAMPO_TELEFONO, datos.telefono())
        );
    }
}
