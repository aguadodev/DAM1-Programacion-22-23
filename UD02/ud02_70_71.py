# Funciones
def leerEntero():
    while True:
        try:
            num = int(input("Número entero?:"))
            return num
        except:
            print("Ha habido un error. Prueba otra vez...")

def leerFlotante():
    while True:
        try:
            num = float(input("Número punto flotante?:"))
            return num
        except:
            print("Ha habido un error. Prueba otra vez...")

# Programa Principal
numeroFlotante = leerFlotante()
print("Has introducido el número flotante", numeroFlotante)

numero2 = leerEntero()
print("Has introducido este otro número entero", numero2)