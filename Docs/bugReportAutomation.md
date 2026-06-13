# Bugs Detectados por Automatización

## Resumen de Ejecución de Pruebas Automatizadas

| Feature | Escenarios | Pass | Fail | Skip |
|---|---|---|---|---|
| Reserva de viaje | 3 (2 examples + 1) | 0 | 2 | 1 |
| Inicio de sesión | 1 | 1 | 0 | 0 |
| Filtrar destinos por precio | 3 | 3 | 0 | 0 |
| Cálculo de tarifas | 3 | 3 | 0 | 0 |

**Total: 4 features, 10 escenarios — 7 pasaron, 2 fallaron, 1 omitido**

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
- **Estado**: Falló en ambos sets de datos del Scenario Outline
- **Causa**: El botón "PAY NOW" permanece deshabilitado incluso después de completar todos los campos del formulario y aceptar términos, lo que bloquea la finalización de la compra.
- **Correlación**: Coincide con el **Bug 4** documentado en `ReporteDeBugs.md`.

---

## Bug 2: Autenticación permite acceso con cualquier credencial

- **Feature**: `inicio_sesion.feature` — Escenario: `Login exitoso con credenciales válidas`
- **Resultado**: PASÓ (1/1)
- **Observación**: La prueba solo cubre el caso con credenciales `Név123` / `password123`. Dado que el bug reportado indica que **cualquier** usuario/contraseña permite el acceso, la prueba existente no es suficiente para detectar esta falla. Se requiere un escenario adicional con credenciales inválidas para validar el rechazo.
- **Correlación**: Coincide con el **Bug 3** documentado en `ReporteDeBugs.md`.

---

## Bugs No Detectados por Automatización Actual

Los siguientes bugs documentados en `ReporteDeBugs.md` no tienen cobertura en las pruebas automatizadas existentes y son candidatos para nuevos escenarios:

### Bug 3: Alteración silenciosa de fecha de ida
- **Descripción**: Al seleccionar una fecha de regreso anterior a la fecha de ida, el sistema sobrescribe la fecha de ida con la fecha actual sin notificar.
- **Feature requerida**: Agregar escenario en `reserva_viaje.feature` con fecha de regreso < fecha de ida.

### Bug 4: Ausencia de botón "Limpiar" en filtros
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

1. **Agregar escenario de login inválido** en `inicio_sesion.feature` para detectar el bug de autenticación.
2. **Agregar escenario de fechas inválidas** en `reserva_viaje.feature` para detectar la alteración silenciosa de fechas.
3. **Agregar escenario de limpieza de filtros** para cubrir la ausencia del botón "Clear".
4. **Revisar el flujo de pago**: El botón "PAY NOW" nunca se habilita, lo que sugiere un problema en las validaciones previas del formulario de checkout.
