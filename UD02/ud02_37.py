n = int(input("Escribe el número de alturas del triángulo:"))

for i in range(1,n + 1):
    print(" " * (n - i), "* " * i)



""" SOLUCIÓN ALTERNATIVA CON BUCLES ANIDADOS

for i in range(1,n + 1):
    for j in range(n-i):
        print(" ", end="")
    for j in range(i):
        print("* ", end="")
    print()

"""