# break - ejemplo

print("La instrucción break:")
for i in range(1, 3):
    print("Dentro del bucle.", i)
print("Fuera del bucle.")


# continue - ejemplo

print("\nLa instrucción continue:")
for i in range(1, 6):
    if i != 3:
        print("Dentro del bucle.", i)
    
print("Fuera del bucle.")







"""
num = int(input("Número de repeticiones del saludo:"))

while num > 0:
     print("Hola")
     num -= 1
"""