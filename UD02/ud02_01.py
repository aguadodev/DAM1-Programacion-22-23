IVA = 21
UMBRAL_DESCUENTO = 100
DESCUENTO = 5

precio = float(input("Precio del producto (€.€€):"))
numUnidades = int(input("Número de unidades:"))

precioFinal = precio * numUnidades * (1 + IVA / 100)

print("El precio final es de", round(precioFinal, 2), "€")

if precioFinal > UMBRAL_DESCUENTO:
    precioFinal -= precioFinal * DESCUENTO / 100
    print("Se aplica un descuento del",DESCUENTO,"%")
    print("El precio final queda reducido a",round(precioFinal,2),"€")




