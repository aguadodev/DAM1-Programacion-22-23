palabraOculta = "AHORCADO"
letrasUtilizadas = ""
palabraDescubierta = ""

MAX_FALLOS = 7
numFallos = 0

while palabraDescubierta != palabraOculta and numFallos < MAX_FALLOS:
    letraUsuario = input("Letra:")
    letraUsuario = letraUsuario.upper()

    if letraUsuario in letrasUtilizadas:
        print("Ya has usado esa letra")
    else:
        letrasUtilizadas += letraUsuario
        if letraUsuario not in palabraOculta:
            print("La letra",letraUsuario,"no existe en la palabra oculta.")
            numFallos += 1
            print("Número de fallos:", numFallos)
    
    # Calcula la palabra descubierta
    palabraDescubierta = ""
    for letra in palabraOculta:
        if letra in letrasUtilizadas:
            palabraDescubierta += letra
        else:
            palabraDescubierta += "_"
    
    print("Palabra descubierta:", palabraDescubierta)
    print("Letras utilizadas:", letrasUtilizadas)

if palabraDescubierta == palabraOculta:
    print("ENHORABUENA!! Descubriste la palabra oculta!!")
    print("Número de fallos:", numFallos)
else:
    print("HAS PERDIDO!! Alcanzaste el número máximo de fallos permitido.")
    print("La palabra oculta era:", palabraOculta)
