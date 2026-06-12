package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicio {
    public static final Target CAMPO_FECHA_IDA = Target.the("Campo de fecha de ida").located(By.xpath("//label[contains(.,'Departing')]/preceding-sibling::input"));

    public static final Target CAMPO_FECHA_REGRESO = Target.the("Campo de fecha de regreso").located(By.xpath("//*[contains(text(),'Returning')]/preceding-sibling::input"));

    public static final Target CAMPO_ADULTOS = Target.the("Campo de cantidad de adultos").located(By.xpath("//*[contains(@value,'Adults (18+)')]"));

    public static final Target CAMPO_NINOS = Target.the("Campo de cantidad de ninos").located(By.xpath("//*[contains(@value,'Children (0-7)')]"));

        public static final Target ADULT_OPTION= Target.the("Opción de adulto ")
                .locatedBy("(//li[text()='{0}'])[1]");

    public static final Target NINO_OPTION= Target.the("Opción de niño ")
            .locatedBy("(//li[text()='{0}'])[2]");


    public static final Target CAMPO_DESTINO = Target.the("Campo de destino").located(By.xpath(""));


    public static final Target BOTON_DESTINATION = Target.the("Boton de buscar").located(By.xpath("//*[contains(text(),'Select Destination')]"));


    //Componente de las fechas
    public static final  Target ITEM_LIST_CALENDARIO_ANO= Target.the("lista de años").locatedBy("//li[@id='{0}']");
    public static final  Target CAMPO_ANO_CALENDARIO= Target.the("campo año del calendario").located(By.id("years"));
    public static final Target CAMPO_MES_ANIO = Target.the("Mes ").locatedBy("//span[contains(text(),'{0}')]");
    public static final Target BOTON_PREV = Target.the("boton de mes anterior").located(By.id("left"));
    public static final Target BOTON_NEXT=Target.the("botón de siguiente mes").located(By.id("right"));
    public static final  Target BOTON_DIA= Target.the("campo día").locatedBy("//span[ text()='{0}']/ancestor::div[contains(@class,'theme__day___3cb3g')]");
    public static final Target BOTON_OK= Target.the("botón okey calendario").located(By.xpath("//button[text()='Ok']"));

}
