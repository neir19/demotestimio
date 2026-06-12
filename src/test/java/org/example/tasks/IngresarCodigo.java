package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.ui.PaginaFormulario;
import org.example.ui.PaginaInicio;

public class IngresarCodigo implements Task {
    private String code;

    public IngresarCodigo(String code) {
        this.code = code;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(code).into(PaginaFormulario.CAMPO_CODIGO_PROMOCIONAL));
        actor.attemptsTo(Click.on(PaginaFormulario.BOTON_APLICAR_CODE));

    }

    public static Performable con(String code){
        return Tasks.instrumented(IngresarCodigo.class,code);
    }
}
