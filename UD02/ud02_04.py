num = int(input("Escribe un número entre 0 y 99999:"))

# Método 2: Usando la división
if num // 10000 > 0:
    print("Tiene 5 cifras")
elif num // 1000 > 0:
    print("Tiene 4 cifras")
elif num // 100 > 0:
    print("Tiene 3 cifras")
elif num // 10 > 0:
    print("Tiene 2 cifras")
else:
    print("Tiene 1 cifras")

# Método 1: Usando rangos de valores
if num >= 0 and num <= 9:
    print("Tiene una cifra")
elif num >= 10 and num <= 99:
    print("Tiene 2 cifras")
elif num >= 100 and num <= 999:
    print("Tiene 3 cifras")
elif num >= 1000 and num <= 9999:
    print("Tiene 4 cifras")
else:
    print("Tiene 5 cifras")
            
            
            
