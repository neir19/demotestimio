package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaDestinos {
    public static final Target LINK_DESTINO = Target.the("Enlace de destino '{0}'")
        .locatedBy("//h5[text()='{0}']/ancestor::div[contains(@class, 'GalleryItem')]//button");
    public static final Target BOTON_LOAD_MORE = Target.the("Boton cargar mas destinos")
            .located(By.xpath("//button[text()='Load more']"));
    public static final Target FILTRO_PRECIO_MAX = Target.the("Filtro de precio")
        .locatedBy("//div[contains(@class,'PurpleSlider')]//input");
    public static final Target PRICE_SLIDER_HANDLE = Target.the("Control de la barra de precios")
            .located(By.xpath("//div[contains(@class, 'theme__progress___xkm0P PurpleSlider__progress___5_ybD')]"));
    public static final Target CAMPO_VALOR= Target.the("campo valor de los card").located(By.xpath("//span[contains(text(),'$')]"));
}
