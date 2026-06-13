# Reporte de Bugs

## Alteración silenciosa y no autorizada de fecha de ida al seleccionar una fecha de regreso inválida.

### MÓDULO AFECTADO
Motor de búsqueda de viajes / Componente de calendario de fechas.

### DESCRIPCIÓN
El sistema presenta una inconsistencia lógica al gestionar la selección de fechas. Si un usuario selecciona una fecha de regreso que es anterior a la fecha de ida establecida, el sistema sobrescribe automáticamente la fecha de ida con la fecha actual ("hoy") sin notificar al usuario, ni solicitar confirmación, ni mostrar mensajes de error sobre la invalidez de la selección.

### PRECONDICIONES
El usuario se encuentra en el flujo de búsqueda de destinos.

El calendario para las fechas de ida y regreso está habilitado.

### PASOS PARA REPRODUCIR
Seleccionar una fecha de ida futura en el calendario (ej. 25/06/2026).

Seleccionar una fecha de regreso que sea anterior a la fecha de ida ya elegida (ej. 15/06/2026).

Observar el campo de fecha de ida inmediatamente después de la selección.

### RESULTADO ACTUAL
El campo de fecha de ida se modifica automáticamente a la fecha actual del sistema sin ninguna alerta o mensaje informativo al usuario.

### RESULTADO ESPERADO
El sistema debe validar la coherencia de las fechas. Ante una selección inválida (fecha de regreso < fecha de ida), el sistema debe:

Bloquear la selección o mostrar un mensaje de error claro al usuario.

Mantener la fecha de ida seleccionada originalmente por el usuario.

No realizar cambios automáticos no solicitados en los campos del formulario.

## Ausencia de funcionalidad "Limpiar" en filtros

### MÓDULO AFECTADO
Módulo de Búsqueda / Filtros de destinos.

### DESCRIPCIÓN
La interfaz de usuario carece de una acción, botón o mecanismo de control para limpiar o restablecer los criterios seleccionados en los campos de "Launch" y "Planet Color". Una vez que el usuario aplica filtros, no existe una forma nativa de revertir la selección para ver el listado original, obligando al usuario a realizar una recarga de página completa.

### PRECONDICIONES
El usuario se encuentra en la pantalla de listado de destinos.

Los campos de filtro "Launch" y "Planet Color" están disponibles para interacción.

### PASOS PARA REPRODUCIR
Seleccionar un valor cualquiera en el filtro "Launch".

Seleccionar un valor cualquiera en el filtro "Planet Color".

Observar la interfaz para localizar un botón de "Limpiar" o "Reset".

Intentar quitar los valores seleccionados o volver al estado de búsqueda original sin recargar la página.

### RESULTADO ACTUAL
No existe un mecanismo de limpieza. La única forma de restablecer la búsqueda es actualizando la página desde el navegador.

### RESULTADO ESPERADO
Debe existir un botón de "Limpiar" o "Borrar filtros" visible, o bien la opción de deseleccionar los valores en los campos de filtro, permitiendo al usuario retomar su búsqueda original sin recargar la aplicación.

## Autenticación permite el acceso con cualquier usuario y muestra información incorrecta del perfil

### MÓDULO AFECTADO

Autenticación / Inicio de Sesión

### DESCRIPCIÓN

El sistema permite iniciar sesión utilizando cualquier combinación de usuario y contraseña, independientemente de que las credenciales sean válidas o no. Adicionalmente, una vez autenticado, siempre se muestra el mismo nombre de usuario en la aplicación, sin importar las credenciales ingresadas.

### PRECONDICIONES
El usuario se encuentra en la pantalla de inicio de sesión.
El sistema está disponible para autenticación.
### PASOS PARA REPRODUCIR
Acceder a la pantalla de inicio de sesión.
Ingresar un usuario cualquiera no registrado.
Ingresar una contraseña cualquiera.
Presionar el botón de inicio de sesión.
Verificar el resultado de la autenticación.
Revisar el nombre mostrado en la sesión iniciada.
### RESULTADO ACTUAL
El sistema permite el acceso utilizando cualquier usuario y contraseña.
El nombre mostrado después del inicio de sesión es siempre el mismo, independientemente de las credenciales utilizadas.
### RESULTADO ESPERADO
El sistema debe permitir el acceso únicamente con credenciales válidas.
Las credenciales inválidas deben generar un mensaje de error y bloquear el acceso.
El nombre mostrado en la sesión debe corresponder al usuario autenticado.

## El botón "Pay Now" no responde ante ninguna interacción del usuario durante el checkout.

### MÓDULO AFECTADO
Módulo de Pago / Checkout.

### DESCRIPCIÓN
El componente PAY NOW ubicado en la página de finalización de compra no ejecuta ninguna acción (ni validaciones, ni llamadas a API, ni navegación) al ser presionado. La ausencia de respuesta del elemento impide completar el flujo de reserva, lo que detiene totalmente la conversión de ventas.

### PRECONDICIONES
El usuario ha completado satisfactoriamente los formularios de datos personales.

El formulario se encuentra en estado visualmente "listo" para el pago (todos los campos obligatorios diligenciados).

### PASOS PARA REPRODUCIR
Navegar hasta la sección de pago (Checkout).

Completar todos los campos del formulario requeridos.

Hacer clic sobre el botón "PAY NOW".

Observar la reacción del sistema en el navegador y en la consola de desarrollador (F12).

### RESULTADO ACTUAL
El botón no ejecuta ninguna acción, no hay indicadores de carga (spinners) y no se observa actividad de red (XHR/Fetch) en la consola al interactuar con el elemento.

### RESULTADO ESPERADO
Al hacer clic en "PAY NOW", el sistema debe activar las validaciones de campos (si aún no se han hecho), enviar la solicitud al servicio de pagos, mostrar un indicador de procesamiento y redirigir a la pantalla de confirmación o error según corresponda.



# PROMPT 
Actúa como un QA Senior especializado en análisis y gestión de defectos.
A partir de la descripción del bug suministrada, genera un reporte de defecto profesional en formato Markdown.
Analiza la información proporcionada e identifica automáticamente:

Impacto funcional.
Severidad.
Prioridad sugerida.
Componente afectado.
Utiliza la siguiente estructura:

TÍTULO DEL DEFECTO
Resumen corto y descriptivo del problema.

MÓDULO AFECTADO
Funcionalidad o componente donde ocurre el problema.

DESCRIPCIÓN
Descripción detallada del comportamiento observado.

PRECONDICIONES
Precondición 1
Precondición 2
PASOS PARA REPRODUCIR
Paso individual.
Paso individual.
Paso individual.
RESULTADO ACTUAL
Descripción precisa del comportamiento observado.

RESULTADO ESPERADO
Descripción precisa del comportamiento esperado.
Descripción del bug:
Falta un campo limpiar para  los campos  launch y planet Color, debido a que si ingresa una busqueda y la quiere quitar no existe forma de hacerlo
Descripción del bug:
