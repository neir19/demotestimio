# demotestimio

Automatización de pruebas para la aplicación [demo.testim.io](https://demo.testim.io/) utilizando **Serenity BDD**, **Cucumber** y el patrón **Screenplay**.

## 🚀 Requisitos

- **JDK 17** o superior
- Navegador **Google Chrome**

## ▶️ Ejecución

```bash
.\gradlew.bat test
```

Esto ejecutará todos los escenarios en paralelo (2 hilos) y generará el reporte de Serenity en `target/site/serenity/index.html`.

## 📁 Estructura del proyecto

```
src/
└── test/
    ├── java/org/example/
    │   ├── runners/          # TestRunner (Suite JUnit 5)
    │   ├── stepdefinitions/  # Hooks y step definitions
    │   ├── tasks/            # Tareas del patrón Screenplay
    │   ├── questions/        # Preguntas para validaciones
    │   ├── interactions/     # Interacciones de bajo nivel
    │   ├── model/            # Modelos de datos
    │   ├── ui/               # Mapeo de elementos de página
    │   └── Utils/            # Utilidades
    └── resources/
        ├── features/         # Escenarios en Gherkin
        ├── serenity.conf     # Configuración de Serenity
        └── junit-platform.properties  # Configuración de paralelismo
```

## 🧪 Funcionalidades cubiertas

| Feature | Tags | Descripción |
|---|---|---|
| Reserva de viaje | `@reserva` | Flujo completo de reserva (fechas, pasajeros, destino, formulario, pago) |
| Inicio de sesión | `@login` | Login con credenciales válidas |
| Filtrar por precio | `@FiltrarPorPrecio`, `@Regresion` | Filtro de destinos por precio máximo |
| Cálculo de tarifas | `@CalculoTarifas`, `@Regresion` | Validación del precio total vs. cantidad de pasajeros |

## 🛠 Stack tecnológico

| Tecnología | Versión |
|---|---|
| Java | 17 |
| Serenity BDD | 5.3.10 |
| Cucumber | 7.34.2 |
| JUnit Platform | 6.0.3 |
| Gradle | 9.5.0 |
| WebDriverManager | 5.9.2 |
| Selenium | 4.41.0 (gestionado por Serenity) |

## 📚 Documentación adicional

Ver la carpeta [`Docs/`](Docs/) para:
- [Uso de IA](Docs/UsoIA.md)
- [Casos de Prueba](Docs/Casos de Prueba.md)
- [Reporte de Bugs](Docs/Reporte de Bugs.md)
