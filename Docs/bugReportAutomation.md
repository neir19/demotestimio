# Bugs Detectados por Automatización

## Resumen de Ejecución de Pruebas Automatizadas

| Feature | Escenarios | Pass | Fail | Skip |
|---|---|---|---|---|
| Reserva de viaje | 3 (2 examples + 1) | 0 | 2 | 1 |
| Inicio de sesión | 2 | 2 | 0 | 0 |
| Filtrar destinos por precio | 3 | 3 | 0 | 0 |
| Cálculo de tarifas | 3 | 3 | 0 | 0 |
**Total: 4 features, 10 escenarios — 8 pasaron, 2 fallaron, 0 omitidos**

---

## Bug 1: Botón "PAY NOW" deshabilitado en el flujo de checkout

- **Feature**: `reserva_viaje.feature` — Escenario: `Reservar un viaje exitosamente`
- **Error reportado por Serenity**:
  ```
  Expected: an element that is enabled
       but: the element identified by xpath: //button[contains(@class,'OrderSummary__pay-button')] [PAY NOW] was not enabled
  ```
- **Tipo**: `java.lang.AssertionError`
- **Origen**: `RealizarPago.java:20` → `ReservaViajeStepDefinitions.java:82`
- **Estado**: Falló en el Example #1.1 (datos: Juan Perez). El Example #1.2 no alcanzó este paso por un error previo de validación de teléfono.
- **Causa**: El botón "PAY NOW" permanece deshabilitado incluso después de completar todos los campos del formulario y aceptar términos, lo que bloquea la finalización de la compra.
- **Correlación**: Coincide con el **Bug 4** (Pay Now) documentado en `ReporteDeBugs.md`.

---

## Bug 2: Validación de formato de teléfono rechaza número válido

- **Feature**: `reserva_viaje.feature` — Escenario: `Reservar un viaje exitosamente` (Example #1.2)
- **Error reportado por Serenity**:
  ```
  java.lang.IllegalArgumentException: Teléfono inválido: +7877654321
  ```
- **Tipo**: `java.lang.IllegalArgumentException`
- **Origen**: `CompletarFormulario.java:30` → `ReservaViajeStepDefinitions.java:61`
- **Datos del ejemplo**: nombre "Maria Gomez", email "maria@email.com", ssn "987-65-4321", teléfono "+7877654321"
- **Causa**: La validación interna del campo teléfono rechazó el número `+7877654321` como inválido, posiblemente por esperar un formato específico (ej. `+1787XXXXXXX` con 7 dígitos después del prefijo). El número `+7877654321` tiene solo 7 dígitos después de `+`, sin el prefijo `1`.
- **Impacto**: Bloquea el flujo completo de reserva para este conjunto de datos; los pasos posteriores (adjuntar archivo, código promocional, términos, pago) se omiten automáticamente.
- **Correlación**: No hay un bug equivalente documentado en `ReporteDeBugs.md`. Es un hallazgo nuevo de la automatización.

---

## Bugs No Detectados por Automatización Actual

Los siguientes bugs documentados en `ReporteDeBugs.md` no tienen cobertura en las pruebas automatizadas existentes y son candidatos para nuevos escenarios:

### Bug 3: Autenticación permite acceso con cualquier credencial
- **Descripción**: El sistema permite iniciar sesión con cualquier combinación de usuario/contraseña.
- **Resultado en automatización**: En el último ciclo se ejecutaron 2 ejemplos: credenciales válidas (`Név123`/`password123`) y credenciales inválidas (`3543`/`232`). **Ambos pasaron**, confirmando que el sistema no rechaza credenciales incorrectas.
- **Feature requerida**: La validación ya está cubierta en `inicio_sesion.feature` (2 escenarios), pero ambas pasan porque la aplicación no tiene validación real. Se requiere corrección en el backend de la aplicación.

### Bug 4: Alteración silenciosa de fecha de ida
- **Descripción**: Al seleccionar una fecha de regreso anterior a la fecha de ida, el sistema sobrescribe la fecha de ida con la fecha actual sin notificar.
- **Feature requerida**: Agregar escenario en `reserva_viaje.feature` con fecha de regreso < fecha de ida.

### Bug 5: Ausencia de botón "Limpiar" en filtros
- **Descripción**: No hay forma de limpiar los filtros "Launch" y "Planet Color" sin recargar la página.
- **Feature requerida**: Nueva feature o escenario en `filtrar_precio.feature` para validar limpieza de filtros.

---

## Features sin Errores (Pruebas Pasaron Correctamente)

| Feature | Escenarios | Resultado |
|---|---|---|
| Filtrar destinos por precio (`filtrar_precio.feature`) | 3 (precios: 500, 1200, 250) | ✅ Todos pasaron |
| Cálculo de tarifas (`calculo_tarifas.feature`) | 3 (pasajeros: 4+1, 2+2, 3+3) | ✅ Todos pasaron |

Las validaciones de filtro por precio y cálculo de tarifas funcionan correctamente en la aplicación.

---

## Recomendaciones

1. **Revisar validación de formato de teléfono** en `CompletarFormulario.java`: El número `+7877654321` fue rechazado como inválido. Verificar si la validación es correcta o si el formato aceptado debe ser más flexible.
2. **Revisar el flujo de pago**: El botón "PAY NOW" nunca se habilita, lo que sugiere un problema en las validaciones previas del formulario de checkout.
3. **Corregir validación de autenticación** en el backend: el escenario con credenciales inválidas (`3543`/`232`) ya fue agregado y pasa, confirmando que la app no valida credenciales.
4. **Agregar escenario de fechas inválidas** en `reserva_viaje.feature` para detectar la alteración silenciosa de fechas.
5. **Agregar escenario de limpieza de filtros** para cubrir la ausencia del botón "Clear".
