# 
numPersonas = int(input("Número de personas: "))
importe = float(input("Importe total de la comida (€): "))

print("Cantidad a pagar por comensal:", round(importe / numPersonas, 2), "€")