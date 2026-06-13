# Casos de prueba

## Feature: Reserva de viaje (`@reserva`)

Flujo completo de reserva de un viaje en la plataforma Testim.io.

| # | Escenario | Datos | Pasos | Validación |
|---|---|---|---|---|
| 1 | Reservar viaje a Tongli | 2026-07-15 → 2026-07-22, 2 adultos, 1 niño, PROMO2026 | Navegar → agendar → cargar más → filtrar por $1400 → seleccionar Tongli → formulario → adjuntar archivo → código → términos → pagar | Mensaje "Destination Booked" |
| 2 | Reservar viaje a Bahamas | 2026-08-01 → 2026-08-17, 1 adulto, 2 niños, BIENVENIDO | Navegar → agendar → cargar más → filtrar por $1300 → seleccionar Bahamas → formulario → adjuntar archivo → código → términos → pagar | Mensaje "Destination Booked" |

## Feature: Inicio de sesión (`@login`)

| # | Escenario | Datos | Pasos | Validación |
|---|---|---|---|---|
| 1 | Login exitoso | Név123 / password123 | Navegar → click Log in → ingresar credenciales → Sign in | Mensaje de bienvenida visible |

## Feature: Filtrar por precio (`@FiltrarPorPrecio`)

| # | Escenario | Precio máximo | Validación |
|---|---|---|---|
| 1 | Filtrar por $500 | 500 | Todos los resultados ≤ $500 |
| 2 | Filtrar por $1200 | 1200 | Todos los resultados ≤ $1200 |
| 3 | Filtrar por $250 | 250 | Todos los resultados ≤ $250 |

## Feature: Cálculo de tarifas (`@CalculoTarifas`)

| # | Escenario | Pasajeros | Niños | Total esperado | Validación |
|---|---|---|---|---|---|
| 1 | 4 adultos + 1 niño | 4 | 1 | 5 pasajeros | Precio total = precio unitario × 5 |
| 2 | 2 adultos + 2 niños | 2 | 2 | 4 pasajeros | Precio total = precio unitario × 4 |
| 3 | 3 adultos + 3 niños | 3 | 3 | 6 pasajeros | Precio total = precio unitario × 6 |

## Resumen

| Feature | Escenarios | Estado |
|---|---|---|
| Reserva de viaje | 2 | ❌ 2 fallos por aserción (pre-existentes) |
| Inicio de sesión | 1 | ✅ OK |
| Filtrar por precio | 3 | ✅ OK |
| Cálculo de tarifas | 3 | ✅ OK |
| **Total** | **9** | **7 pasan, 2 fallan** |
