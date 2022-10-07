# Entrada
HECT_CAMPO_FUTBOL = 105 * 70 / 10000
HECT_CANCHA_BALONCESTO = 28 * 15 / 10000
HECT_PISTA_TENIS = 23.77 * 10.97 / 10000
HECT_PARQUE_RETIRO = 125

hectareas = int(input("Número de hectáreas: "))

# Proceso
camposFutbol = hectareas / HECT_CAMPO_FUTBOL
canchasBaloncesto = hectareas / HECT_CANCHA_BALONCESTO
pistasTenis = hectareas / HECT_PISTA_TENIS
parquesRetiro = hectareas / HECT_PARQUE_RETIRO

# Salida
print("Nº de campos de fútbol:", round(camposFutbol))
print("Nº de canchas de baloncesto:", round(canchasBaloncesto))
print("Nº de pistas de tenis:", round(pistasTenis))
print("Nº de parques del Retiro:", round(parquesRetiro,2))
