package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.ui.PaginaLogin;

public class Login implements Task {
    private final String usuario;
    private final String contrasena;

    public Login(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static Login con(String usuario, String contrasena) {
        return new Login(usuario, contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaLogin.BOTON_LOG_IN),
                Enter.theValue(usuario).into(PaginaLogin.CAMPO_USUARIO),
                Enter.theValue(contrasena).into(PaginaLogin.CAMPO_CONTRASENA),
                Click.on(PaginaLogin.BOTON_SIGN_IN)
        );
    }
}
