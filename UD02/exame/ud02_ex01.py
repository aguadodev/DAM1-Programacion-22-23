import random

NUM_LANZAMIENTOS = 1000
cara1 = cara2 = cara3 = cara4 = cara5 = cara6 = 0

print()
print("LANZANDO UN DADO",NUM_LANZAMIENTOS,"VECES")

for i in range(NUM_LANZAMIENTOS):
    valorDado = random.randint(1,6)
    if valorDado == 1:
        cara1 += 1
    elif valorDado == 2:
        cara2 += 1
    elif valorDado == 3:
        cara3 += 1
    elif valorDado == 4:
        cara4 += 1
    elif valorDado == 5:
        cara5 += 1
    elif valorDado == 6:
        cara6 += 1

print()
print("RESULTADOS:")
print("Ha salido 1:",cara1,"veces (",round(cara1 / NUM_LANZAMIENTOS * 100,2),"%)")
print("Ha salido 2:",cara2,"veces (",round(cara2 / NUM_LANZAMIENTOS * 100,2),"%)")
print("Ha salido 3:",cara3,"veces (",round(cara3 / NUM_LANZAMIENTOS * 100,2),"%)")
print("Ha salido 4:",cara4,"veces (",round(cara4 / NUM_LANZAMIENTOS * 100,2),"%)")
print("Ha salido 5:",cara5,"veces (",round(cara5 / NUM_LANZAMIENTOS * 100,2),"%)")
print("Ha salido 6:",cara6,"veces (",round(cara6 / NUM_LANZAMIENTOS * 100,2),"%)")
print()
