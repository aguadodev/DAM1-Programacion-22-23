# Función leer_entero: imprime un mensaje y 
# devuelve un número entero leído por teclado
def leer_entero():
    print("Ingresa un valor: ")
    return int(input()) 

def suma(num1, num2, num3):
    return num1 + num2 + num3

def saludo():
    print("Hola!")

# Programa principal
print(saludo())

a = leer_entero()
b = leer_entero()
c = leer_entero()

print("Sumando números: ", suma(a,b,c))
print("Adding numbers: ", suma(3,5,8))

suma(4,123,45)
