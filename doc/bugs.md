# Bugs encontrados

| # | Fecha | Feature | Descripción | Estado |
|---|---|---|---|---|
| 1 | 2026-06-13 | Cálculo de tarifas | **Tabla inconsistente**: El archivo `calculo_tarifas.feature` tenía las filas de la tabla de ejemplos sin el pipe `|` de cierre y el nombre de columna `nino` no coincidía con el placeholder `<ninos>` usado en el escenario. Causaba `FeatureParserException: inconsistent cell count within the table`. | ✅ Corregido |
| 2 | 2026-06-13 | General | **Migración Serenity 4.x → 5.x**: Serenity 4.2.14 no gestionaba correctamente la ejecución paralela con JUnit 5. Se requirió migrar a Serenity 5.3.10 con Cucumber 7.34.2 y JUnit 6.0.3. | ✅ Corregido |
| 3 | 2026-06-13 | General | **Plugin path desactualizado**: En Serenity 5.x, el plugin `SerenityReporterParallel` cambió de `io.cucumber.core.plugin` a `net.serenitybdd.cucumber.core.plugin`. | ✅ Corregido |
| 4 | 2026-06-13 | PrecioPorPasajero | **Import obsoleto**: `org.openqa.selenium.devtools.v129` no existe en Selenium 4.41.0 (gestionado por Serenity 5.3.10). El import no era utilizado, se eliminó. | ✅ Corregido |
| 5 | 2026-06-13 | Reserva de viaje | **Assertion error** en `Reservar un viaje exitosamente` (Example #1.1 y #1.2): El escenario de reserva completa falla en la validación final. Posible causa: cambio en el mensaje de confirmación, elemento no encontrado, o cambio en el flujo de la aplicación. | ❌ Pendiente |
