# CASOS DE PRUEBA:
A continuación, presento una matriz de casos de prueba enfocados en flujos alternos, negativos y de borde, diseñados para maximizar la cobertura y detectar fallos críticos que el flujo feliz suele omitir.
## 1. Funcionalidad: Fechas de Viaje
   NOMBRE
   Selección de fecha de viaje en el pasado.

RESUMEN
Validar que el sistema impida la selección de una fecha de viaje anterior a la fecha actual.

PRECONDICIONES
El calendario de selección de fecha está abierto.

ACCIONES
Seleccionar un año anterior al actual en el calendario.
Seleccionar cualquier mes y día.
Observar el estado del calendario.

RESULTADOS ESPERADOS
El sistema deshabilita las fechas pasadas.
No se permite la selección de la fecha.
El sistema muestra un mensaje de error o impide el avance.

## 2. Funcionalidad: Filtro de Precios
   NOMBRE
   Aplicación de filtro de precio máximo inferior al precio mínimo de los destinos.

RESUMEN
Validar el comportamiento del sistema cuando el rango de precio seleccionado excluye todos los resultados disponibles.

PRECONDICIONES
El usuario se encuentra en la pantalla de destinos.

ACCIONES
Mover el slider de precio al valor mínimo posible.
Observar la lista de destinos.

RESULTADOS ESPERADOS
La lista de destinos se actualiza y queda vacía.
Se muestra un mensaje informativo indicando que no hay resultados para el filtro aplicado.
La experiencia de usuario es consistente.

## 3. Funcionalidad: Cantidad de Pasajeros
   NOMBRE
   Selección de cantidad máxima de pasajeros permitida por destino.

RESUMEN
Validar si existe un límite técnico en la cantidad de pasajeros y cómo lo gestiona el dropdown.

PRECONDICIONES
Dropdown de "Adults" abierto.

ACCIONES
Verificar el valor máximo en la lista de opciones.
Intentar forzar una selección mayor a la permitida mediante la consola del navegador.

RESULTADOS ESPERADOS
El dropdown solo ofrece opciones válidas según la capacidad del sistema.
Cualquier intento de inyectar un valor superior vía consola es rechazado por el backend o validación de formulario.

## 4. Funcionalidad: Formulario de Datos Personales (Email)
   NOMBRE
   Ingreso de formato de correo electrónico inválido.

RESUMEN
Validar la robustez del validador de correos electrónicos.

PRECONDICIONES
Formulario de checkout visible.

ACCIONES
Ingresar un texto sin arroba (ej: "testtest.com").
Ingresar un texto con doble arroba (ej: "test@@test.com").
Intentar avanzar al siguiente campo.

RESULTADOS ESPERADOS
El campo marca error de validación inmediato.
El botón "Pay Now" permanece deshabilitado.

## 5. Funcionalidad: Carga de Archivos
   NOMBRE
   Carga de un archivo con extensión no permitida.

RESUMEN
Validar que el sistema solo acepte formatos de archivo válidos.

PRECONDICIONES
Formulario de checkout visible.

ACCIONES
Seleccionar un archivo de sistema con extensión .exe o .bat.
Hacer clic en abrir.

RESULTADOS ESPERADOS
El sistema rechaza la carga del archivo.
Se muestra un mensaje de error claro indicando los formatos permitidos.
El formulario no permite enviar la reserva con un archivo inválido.

## 6. Funcionalidad: Código Promocional
   NOMBRE
   Aplicación de código promocional expirado o inexistente.

RESUMEN
Validar la gestión de errores ante códigos de descuento inválidos.

PRECONDICIONES
Usuario en el formulario de pago.

ACCIONES
Ingresar "EXPIRED2023" en el campo de promo code.
Hacer clic en "Apply".

RESULTADOS ESPERADOS
El sistema muestra un mensaje de "Código inválido o expirado".
El precio total del viaje no sufre modificaciones.

## 7. Funcionalidad: Aceptación de Términos
   NOMBRE
   Intento de pago sin aceptar términos y condiciones.

RESUMEN
Verificar la obligatoriedad del checkbox de términos.

PRECONDICIONES
Formulario de checkout con todos los datos personales llenos.

ACCIONES
Dejar el checkbox de términos sin marcar.
Hacer clic en el botón "PAY NOW".

RESULTADOS ESPERADOS
El sistema bloquea la transacción.
Se resalta el checkbox de términos como campo obligatorio pendiente.

## 8. Funcionalidad: Pago (Validación de robustez)
   NOMBRE
   Doble clic rápido en el botón de pago.

RESUMEN
Validar la prevención de transacciones duplicadas.

PRECONDICIONES
Formulario correctamente diligenciado.

ACCIONES
Hacer doble clic consecutivo y rápido en el botón "PAY NOW".

RESULTADOS ESPERADOS
El sistema deshabilita el botón inmediatamente después del primer clic para evitar envíos múltiples.
Solo se procesa una única reserva.


# PROMPT
Actúa como un Analista de Pruebas Senior especializado en diseño de casos de prueba funcionales, pruebas exploratorias y técnicas ISTQB.

Analiza exhaustivamente la aplicación web https://demo.testim.io/ e identifica todas las funcionalidades, reglas de negocio, validaciones, restricciones y flujos alternos disponibles para el usuario.

Objetivo:
Generar los casos de prueba alternos y negativos necesarios para maximizar la cobertura funcional del sistema, priorizando los escenarios que normalmente no son cubiertos por el flujo feliz.

Aplica las siguientes técnicas de diseño de pruebas cuando correspondan:

* Partición de equivalencia.
* Análisis de valores límite.
* Tabla de decisiones.
* Transición de estados.
* Casos de uso.
* Pruebas exploratorias.
* Pruebas negativas.
* Pruebas de validación de datos.
* Pruebas de experiencia de usuario.
* Pruebas de integridad de formularios.
* Pruebas de navegación.
* Pruebas de recuperación ante errores.
* Pruebas de robustez.
* Análisis basado en riesgos.

Instrucciones:

1. No generar casos de prueba del flujo principal (happy path) salvo que sean necesarios para contextualizar un flujo alterno.
2. Priorizar validaciones, errores de usuario, datos inválidos y combinaciones de negocio.
3. Incluir escenarios de borde para fechas, precios, pasajeros, códigos promocionales y formularios.
4. Identificar posibles defectos potenciales aun cuando no exista una validación visible en la interfaz.
5. Cada acción debe representar una única acción ejecutable y no combinar múltiples acciones en el mismo paso.
6. Los resultados esperados deben ser verificables y medibles.
7. Los casos deben ser independientes entre sí.
8. Generar únicamente casos que aporten valor y aumenten la cobertura funcional.

Formato de salida:

# NOMBRE

[Nombre descriptivo del caso]

## IMPORTANCIA

[Crítica | Alta | Media | Baja]

## RESUMEN

[Descripción breve del objetivo del caso]

## PRECONDICIONES

* Condición 1
* Condición 2

## ACCIONES

1. Acción individual.
2. Acción individual.
3. Acción individual.

## RESULTADOS ESPERADOS

1. Resultado verificable.
2. Resultado verificable.
3. Resultado verificable.

Genera la mayor cantidad posible de casos de prueba alternos y negativos agrupados por funcionalidad:

* Fechas de viaje.
* Selección de destino.
* Cantidad de pasajeros.
* Filtro de precios.
* Código promocional.
* Formulario de datos personales.
* Carga de archivos.
* Aceptación de términos y condiciones.
* Pago y confirmación de reserva.
* Navegación y experiencia de usuario.

Prioriza primero los casos Críticos y Altos antes de los Medios y Bajos.
