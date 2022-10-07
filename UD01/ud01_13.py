# Ejercicio 13: Interés compuesto
# P x (1 + r/n)nt, 
# donde P es la cantidad de la inversión inicial, 
# r es la tasa de interés, 
# n el número de periodos de devengo de intereses y 
# t es la duración total de la inversión en años.

# Entrada
importe = float(input("Importe inicial: "))
interes = float(input("Interés anual (Ej. 4.2%): "))
anhos = int(input("Número de años: "))

# Proceso
importeFinal = importe * (1 + interes / 100) ** anhos
print("Importe Final:", round(importeFinal, 2))
