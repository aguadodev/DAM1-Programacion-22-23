import random

num1 = random.randint(1,99)
num2 = random.randint(1,99)

print("EL JUEGO DE LA SUMA")
print("Cuánto es",num1,"+",num2,"?")
resultado = int(input())

if resultado == num1 + num2:
    print("Correcto!")
else:
    print("ERROR!!!")