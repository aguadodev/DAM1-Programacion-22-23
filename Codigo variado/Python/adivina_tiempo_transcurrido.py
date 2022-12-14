import random
import time

MIN_SEGUNDOS = 5
MAX_SEGUNDOS = 10

segundos = random.randint(MIN_SEGUNDOS, MAX_SEGUNDOS)

print ("""
ADIVINA EL TIEMPO TRANSCURRIDO
==============================
¿Qué tal es tu percepción del tiempo?
Pulsa ENTER para comenzar a contar el tiempo
y vuelve a pulsar cuando hayan transcurrido...
""")
input()
print(segundos, "segundos")
inicio = time.time()
input()

fin = time.time()

segundosTranscurridos = round(fin - inicio)

if segundos == segundosTranscurridos:
    print("¡¡Enhorabuena!! ¡Tienes una estupenda percepción del paso del tiempo!")
else:
    print("Han transcurrido",segundosTranscurridos,"segundos. No has acertado...")
