# Ejercicio 12: Interés bancario
# Entrada
INTERES = 4
importeInicial = float(input("Importe inicial: "))
 
# Proceso
importeAnho1 = importeInicial + importeInicial * INTERES / 100
importeAnho2 = importeAnho1 + importeAnho1 * INTERES / 100
importeAnho3 = importeAnho2 + importeAnho2 * INTERES / 100
 
# Salida
print("Ahorros Año 1:", round(importeAnho1, 2))
print("Ahorros Año 2:", round(importeAnho2, 2))
print("Ahorros Año 3:", round(importeAnho3, 2))