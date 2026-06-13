# Implementación con IA

Este proyecto fue desarrollado con asistencia de **opencode** utilizando el modelo **big-pickle** para agilizar el desarrollo, depuración y migración del framework de automatización.

## Herramientas utilizadas

- **opencode** (CLI interactivo): Asistente de codificación para tareas de ingeniería de software.
- **Modelo**: `big-pickle` — modelo especializado en tareas de programación y automatización.
- **Gradle 9.5.0** como sistema de construcción.

## Tareas asistidas por IA

### 1. Corrección de errores

- **Error `junit-platform-suite`**: El engine de cucumber fallaba al parsear el archivo `calculo_tarifas.feature` por una tabla con celdas inconsistentes. La IA identificó la causa raíz mediante el stacktrace y corrigió la sintaxis del archivo `.feature`.

### 2. Configuración de ejecución en paralelo

- Se configuró `cucumber.execution.parallel.enabled=true` en `junit-platform.properties` y se ajustó la estrategia a `fixed` con 2 hilos.
- Se identificó que Serenity 4.x no manejaba correctamente el paralelismo con JUnit 5, por lo que se migró a Serenity 5.3.10.

### 3. Migración de Serenity 4.x a 5.x

- Actualización de todas las dependencias de Serenity 4.2.14 → 5.3.10.
- Actualización de Cucumber 7.21.1 → 7.34.2.
- Migración de JUnit 5.x → 6.0.3.
- Cambio del plugin path de `io.cucumber.core.plugin.SerenityReporterParallel` a `net.serenitybdd.cucumber.core.plugin.SerenityReporterParallel`.
- Eliminación de dependencia `serenity-junit` (deprecada en Serenity 5.x).
- Corrección de import obsoleto de DevTools en `PrecioPorPasajero.java`.

### 4. Configuración del entorno

- Creación de `gradle.properties` con `org.gradle.java.home` para apuntar al JDK 17 automáticamente.

## Beneficios

- **Velocidad**: Reducción significativa del tiempo de desarrollo y depuración.
- **Precisión**: Identificación exacta de causas raíz mediante análisis de stacktraces.
- **Consistencia**: Aplicación de mejores prácticas recomendadas por la documentación oficial de Serenity.
