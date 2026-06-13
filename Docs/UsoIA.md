# Uso de Inteligencia Artificial en la Solución

## Objetivo

La Inteligencia Artificial fue utilizada como acelerador del desarrollo y apoyo técnico para:

- Generación de la estructura inicial del proyecto.
- Construcción de escenarios Gherkin.
- Identificación de casos de prueba críticos.
- Generación inicial de Tasks, Interactions y Questions.
- Optimización de localizadores.
- Resolución de problemas de configuración de Serenity y Gradle.
- Implementación de ejecución paralela.

Toda la solución fue revisada, ajustada y validada manualmente.

## Estrategia de Trabajo

Durante el desarrollo se evaluaron dos enfoques:

### Enfoque 1
Generar toda la automatización mediante un único prompt.
#### ¿Cómo se hizo?
Una vez evidenciado el caso de prueba principal de la prueba, se generó un prompt básico:
"Actúa como un experto en Java y gradle. Módifica el proyecto para que sea una automatización de  serenity bdd  con gradle  modifica el archivo build.gradle   para que corra el  proyecto con  Screenplay y Cucumber para el jdk 17.0.17 . Incluye las dependencias necesarias para realizar pruebas web (Serenity) y configura  para habilitar la ejecución paralela de escenarios.
Crea un archivo .feature utilizando Gherkin para la funcionalidad de agendar un viaje en https://demo.testim.io/. Incluye un Scenario Outline que parametrize: fecha de partida, fecha de regreso, cantidad de adultos, niños, rango de precio, destino, código promocional y los datos personales (nombre, email, Social Security Number, teléfono(el número de teléfono debe iniciar con +1787 y 7 dígitos más) y cargar un archivo el cual se escoja la ubicación. El flujo debe seguir los pasos: seleccionar destino tomando la  información  ingresada anteriormente, cargar más, filtrar por precio modificando el precio mayor, llenar formulario, adjuntar archivo que yo le daré la ubicación de donde está guardado, aceptar términos y pagar, validando el mensaje 'Destination Booked'
 el patrón  a usar será Screenplay. Basado en el feature anterior, genera la estructura de clases necesaria:

Tasks: Una clase para 'AgendarViaje' que orqueste las interacciones.

Interactions: Clases específicas para 'FiltrarPrecio', 'SeleccionarDestino' y 'CargarArchivo'.

UI/Targets: Define las clases con los Selectors (Target) para los elementos de https://demo.testim.io/.

Questions: Una clase para verificar el mensaje de confirmación 'Destination Booked'".

Este prompt se suministró a la IA para mejorar su sintasis de la siguiente manera: 
"Eres un QA senior con arduo conocimiento en Java, cucumber y prompt. Se te pide la siguiente tarea corrige el siguiente prompt para cuando se le suministra a una herramienta ia lo pueda procesar de la manera más rapida bien estructurada."
Con Este prompt se creó todo el arquetipo y escenario principal del proyecto:

"Actúa como un Arquitecto de Automatización Senior especializado en Serenity BDD, Screenplay, Cucumber, Gradle y Java 17.Genera una solución empresarial siguiendo estrictamente los principios de Clean Code, SOLID, Screenplay Pattern y separación de responsabilidades.CONFIGURACIÓN DEL PROYECTOModifica el proyecto para Serenity BDD con Gradle.Configura Java JDK 17.0.17.Configura Screenplay + Cucumber.Incluye las dependencias necesarias para automatización web.Configura ejecución paralela de escenarios.Configura serenity.conf y build.gradle con las mejores prácticas actuales.Usa únicamente dependencias compatibles entre sí.REGLAS OBLIGATORIAS DE ARQUITECTURALos Step Definitions NO deben contener:lógica de negocio de automatización: localizadores, llamadas Selenium/WebDriveresperasvalidaciones complejasLos Step Definitions únicamente deben:recibir parámetros: llamar Tasksllamar Questions para validacionesToda interacción con la UI debe estar en:TasksInteractionsTodos los selectores deben estar centralizados en clases Page/UI utilizando Target.Todas las validaciones deben implementarse mediante Questions.Las Tasks deben representar acciones de negocio completas.Las Interactions deben representar acciones reutilizables de bajo nivel.No duplicar código.Implementar patrón Screenplay puro.Generar código listo para compilar.CASO DE PRUEBAGenera un archivo feature para https://demo.testim.ioUtiliza Scenario Outline parametrizando:fechaPartida, fechaRegreso, adultos, ninos, rangoPrecio, destino, codigoPromocional, nombre, email,socialSecurityNumber, telefono, rutaArchivo El teléfono debe iniciar con +1787 seguido de 7 dígitos.FLUJOIngresar datos de viaje.Seleccionar destino.Presionar Load More.Filtrar por precio.Seleccionar destino.Completar formulario.Adjuntar archivo usando la ruta recibida.Aceptar términos.Realizar pago.Validar el mensaje "Destination Booked".ESTRUCTURA ESPERADAGenera:build.gradleserenity.conffeatureRunnerStep DefinitionsTasksInteractionsQuestionsUI/TargetsData Model si aplicaIMPORTANTELos Step Definitions deben quedar únicamente así:@Cuando(...)
public void accion(...) {
actor.attemptsTo(
AgendarViaje.con(...)
);
}@Entonces(...)
public void validar() {
actor.should(
seeThat(MensajeReserva.esCorrecto())
);
}Si generas cualquier Click, Enter, WaitUntil, Ensure, WebElementFacade, By o lógica de negocio dentro de los Step Definitions, la respuesta será incorrecta.Toda la automatización debe residir exclusivamente en Tasks, Interactions, Questions y UI.".

### Enfoque 2
Dividir la solución en múltiples prompts especializados por funcionalidad.

Se seleccionó el segundo enfoque debido a:

- Menor consumo de contexto.
- Mayor precisión en las respuestas.
- Mejor capacidad de revisión.
- Correcciones más rápidas.
- Menor generación de código innecesario.

Con este principio se realizó la creación de cada caso escenario crítico individual con el siguiente prompt donde únicamente se cambiaba el feature:
Actúa como un Arquitecto de Automatización Senior especializado en Serenity BDD, Screenplay, Cucumber, Gradle y Java 17.Genera una solución empresarial siguiendo estrictamente los principios de Clean Code, SOLID, Screenplay  y separación de responsabilidades.teniendo el gherkin :
Feature: Inicio de sesión

Scenario: Login exitoso con credenciales válidas
Given que el usuario se encuentra en la página de inicio de sesión
When ingresa un usuario válido
And ingresa una contraseña válida
And presiona el botón Sign In
Then debe acceder exitosamente al sistema
And debe visualizar la página principal
DefinitionsTasksInteractionsQuestionsUI/TargetsData Model si aplicaIMPORTANTELos Step Definitions deben quedar únicamente así:@Cuando(...)
public void accion(...) {
actor.attemptsTo(
Login.con(...)
);
}@Entonces(...)
public void validar() {
actor.should(
seeThat(MensajeReserva.esCorrecto())
);
}Si generas cualquier Click, Enter, WaitUntil, Ensure, WebElementFacade, By o lógica de negocio dentro de los Step Definitions, la respuesta será incorrecta. Toda la automatización debe residir exclusivamente en Tasks, Interactions, Questions y UI.".
