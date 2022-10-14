blocks = int(input("Ingresa el número de bloques: "))

height = 0

while blocks > height:
    height += 1
    blocks -= height

print("La altura de la pirámide:", height)
if blocks > 0:
    print("Sobraron",blocks,"bloques que no son suficientes para construir otra altura.")