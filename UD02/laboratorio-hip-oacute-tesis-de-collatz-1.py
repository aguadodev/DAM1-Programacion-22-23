c0 = int(input("Introduce un valor entero positivo para c0:"))

pasos = 0

while c0 != 1:
    if c0 % 2 == 0:
        c0 //= 2
    else:
        c0 = 3 * c0 + 1
    pasos += 1
    print(c0)

print("pasos =",pasos)

