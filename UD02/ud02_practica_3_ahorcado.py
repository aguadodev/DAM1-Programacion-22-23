import random

# Devuelve una palabra oculta para jugar elegida aleatoriamente de 
# un listado de palabras implementado en la propia función.
def obtienePalabraOculta():
    # 1. Definir listado de palabras, preferiblemente relacionadas con programación
    # 2. Elegir aleatoriamente una de esas palabras y devolverla con return
    # Implementación de Daniel T.
    palabras = ["java", "python", "array", "funcion", "variable", "constante", "bucle"]
    randomNumber = random.randint(0, len(palabras) - 1)

    return palabras[randomNumber]

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
    if numFallos == 0:
        message = """
            ___
            |   |
                |
                |
                |
                |
                |
            ____|
        """
    elif numFallos == 1:
        message = """
            ___
            |   |
            O   |
                |
                |
                |
                |
            ____|
        """
    elif numFallos == 2:
        message = """
            ___
            |   |
            O   |
            |   |
                |
                |
                |
            ____|
        """
    elif numFallos == 3:
        message = """
            ___
            |   |
            O   |
           /|   |
                |
                |
                |
            ____|
        """
    elif numFallos == 4:
        message = """
            ___
            |   |
            O   |
           /|\  |
                |
                |
                |
            ____|
        """
    elif numFallos == 5:
        message = """
            ___
            |   |
            O   |
           /|\  |
            |   |
                |
                |
            ____|
        """
    elif numFallos == 6:
        message = """
            ___
            |   |
            O   |
           /|\  |
            |   |
           /    |
                |
            ____|
        """
    elif numFallos == 7:
        message = """
            ___
            |   |
            O   |
           /|\  |
            |   |
           / \  |
                |
            ____|
        """
        
    print(message)



# Programa principal (main)
palabraOculta = obtienePalabraOculta()
if palabraOculta == None:
    palabraOculta = "murcielago"
    
palabraUsuario = ""
letrasUsuario = ""
numFallos = 0
MAX_FALLOS = 7

palabraUsuario = obtienePalabraUsuario(palabraOculta, letrasUsuario)

while numFallos < MAX_FALLOS and palabraOculta != palabraUsuario:
    print(palabraUsuario)
    letraActual = input("Escribe una letra:")
    letrasUsuario += letraActual
    if letraActual in palabraOculta:
        palabraUsuario = obtienePalabraUsuario(palabraOculta, letrasUsuario)
    else:
        numFallos += 1
        imprimeAhorcado(numFallos)

print("\nFIN DEL JUEGO")
if numFallos == MAX_FALLOS:
    print("AHORCADO!!")
    print("HAS PERDIDO!!")
else:
    print("PALABRA OCULTA:", palabraUsuario)
    print("ENHORABUENA!!")



