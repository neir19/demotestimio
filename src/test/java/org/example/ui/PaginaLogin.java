package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaLogin {
    public static final Target BOTON_LOG_IN = Target.the("Botón LOG IN del header")
            .located(By.xpath("//*[text()='Log in']"));

    public static final Target CAMPO_USUARIO = Target.the("Campo de usuario en el formulario de login")
            .located(By.xpath("//span[text()='Username']/preceding-sibling::input"));

    public static final Target CAMPO_CONTRASENA = Target.the("Campo de contraseña en el formulario de login")
            .located(By.xpath("//span[text()='Password']/preceding-sibling::input"));

    public static final Target BOTON_SIGN_IN = Target.the("Botón SIGN IN del formulario de login")
            .located(By.xpath("//*[text()='Cancel']/following-sibling::Button[text()='Log in']"));

    public static final Target MENSAJE_BIENVENIDA = Target.the("Mensaje de bienvenida HELLO, JOHN")
            .located(By.xpath("//Span[contains(text(),'Hello')]"));
}
