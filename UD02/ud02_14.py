import random

num1 = random.randint(1,99)
num2 = random.randint(1,99)

operador = random.randint(1,3) # 1 = suma, 2 = resta, 3 = producto

if operador == 1:
    resultado = num1 + num2
    signo = "+"
elif operador == 2:
    resultado = num1 - num2
    signo = "-"
else:
    resultado = num1 * num2
    signo = "*"
  
print("EL JUEGO DE LA SUMA, RESTA O MULTIPLICACIÓN")

print("Cuánto es",num1,signo,num2,"?")

resultadoUsuario = int(input())

if resultadoUsuario == resultado:
    print("Correcto!")
else:
    print("ERROR!!!")