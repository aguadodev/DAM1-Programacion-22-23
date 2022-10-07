# 10. Parque acuático
# 1. Entrada
PRECIO_ENTRADA_ADULTO = 25
PRECIO_ENTRADA_INFANTIL = 18.5
UMBRAL_DESCUENTO = 120
PORCENTAJE_DESCUENTO = 8

entradasAdulto = int(input("Número de entradas Adulto: "))
entradasInfantil = int(input("Número de entradas Infantil: "))

# 2. Proceso
importeBase = entradasAdulto * PRECIO_ENTRADA_ADULTO + entradasInfantil * PRECIO_ENTRADA_INFANTIL
importeDescuento = importeBase * PORCENTAJE_DESCUENTO / 100
importeFinal = importeBase - importeDescuento if importeBase >= UMBRAL_DESCUENTO else importeBase

# 3. Salida
print("Importe Base: ", round(importeBase,2), "€")
print("Descuento de " + str(PORCENTAJE_DESCUENTO) +"%" if importeBase >= UMBRAL_DESCUENTO else "Sin descuento aplicable")
print("Importe Final: ", round(importeFinal,2), "€")