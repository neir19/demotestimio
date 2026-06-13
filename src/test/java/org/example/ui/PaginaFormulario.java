package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaFormulario {
    public static final Target CAMPO_NOMBRE = Target.the("Campo de nombre")
            .located(By.xpath("//span[text()='Name']/preceding-sibling::input"));
    public static final Target CAMPO_EMAIL = Target.the("Campo de email")
        .located(By.xpath("//span[text()='Email Address']/preceding-sibling::input"));
    public static final Target CAMPO_SSN = Target.the("Campo de social security number")
            .located(By.xpath("//span[text()='Social Security Number']/preceding-sibling::input"));
    public static final Target CAMPO_TELEFONO = Target.the("Campo de telefono")
            .located(By.xpath("//span[text()='Phone Number']/preceding-sibling::input"));
    public static final Target CAMPO_ARCHIVO = Target.the("Campo de archivo adjunto")
            .located(By.xpath("//input[@type='file']"));
    public static final Target CHECKBOX_TERMINOS = Target.the("Checkbox de terminos y condiciones")
            .located(By.xpath("//input[@type='checkbox']"));
    public static final Target LABEL_TERMINOS = Target.the("Label de terminos y condiciones")
            .located(By.xpath("//span[text()='I agree to the terms and conditions']"));
    public static final Target BOTON_PAGAR = Target.the("Boton de pagar")
            .located(By.xpath("//button[contains(@class,'OrderSummary__pay-button')]"));

    public static final Target CAMPO_CODIGO_PROMOCIONAL = Target.the("Campo de codigo promocional").located(By.xpath("//input[@name= 'promo']"));
    public static final  Target BOTON_APLICAR_CODE= Target.the("botón para apicar promocional").located(By.xpath("//button[text()= 'Apply']"));

    public static final Target TOTAL_PRICE = Target.the("Precio total en el resumen de la orden")
            .located(By.xpath("//strong[contains(text(),'$')]"));
    public static final Target PRICE_PER_PASSENGER = Target.the("Precio por pasajero en el resumen")
            .located(By.xpath("//div[contains(text(),'$')]"));
    public static final Target ORDER_SUMMARY_PASSENGERS = Target.the("Cantidad de pasajeros en el resumen")
            .located(By.xpath("//div[contains(@class,'OrderSummary__item')]//span[contains(@class,'label')]"));
}
