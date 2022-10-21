# Imprime la palabra que se muestra al usuario con guiones 
# o letras según las letras ya utilizadas
def obtienePalabraUsuario(palabra, letras):
    palabraUsuario = ""
    for letra in palabra:
        if letra in letras:
            palabraUsuario += letra
        else:
            palabraUsuario += "-"
    return palabraUsuario

# Imprime el dibujo del ahoracad en función del número de fallos
def imprimeAhorcado(fallos):
    print("Número de Fallos:", fallos)


# Programa principal (main)
palabraOculta = "murcielago"
palabraUsuario = ""
letrasUsuario = ""
numFallos = 0
MAX_FALLOS = 7

palabraUsuario = obtienePalabraUsuario(palabraOculta, letrasUsuario)
print(palabraUsuario)

while numFallos < MAX_FALLOS and palabraOculta != palabraUsuario:
    letraActual = input("Escribe una letra:")
    letrasUsuario += letraActual
    if letraActual in palabraOculta:
        palabraUsuario = obtienePalabraUsuario(palabraOculta, letrasUsuario)
        print(palabraUsuario)
    else:
        numFallos += 1
        imprimeAhorcado(numFallos)


if numFallos == MAX_FALLOS:
    print("HAS PERDIDO!!")
else:
    print("ENHORABUENA!!")



