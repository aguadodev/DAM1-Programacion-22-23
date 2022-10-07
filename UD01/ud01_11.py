# Ejercicio 11: Temperaturas
print("Conversión de temperaturas")
print("1. Celsius a Farenheit")
print("2. Farenheit a Celsius")
opcion = input("Opción? ")
temp = float(input("Temperatura: "))

tempFinal = temp * 9 / 5 + 32 if opcion == "1" else (temp -32) * 5 / 9
print("Temperatura convertida",round(tempFinal,4),"grados","Farenheit" if opcion == 1 else "Celsius")