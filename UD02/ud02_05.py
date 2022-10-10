nota = int(input("Escribe una nota:"))

# Método 1: Usando rangos de valores
if nota >= 0 and nota <= 4:
    print("Insuficiente")
elif nota == 5:
    print("Suficiente")
elif nota == 6:
    print("Bien")
elif nota >= 7 and nota <= 8:
    print("Notable")
elif nota >= 9 and nota <= 10:
    print("Sobresaliente")
else:
    print("Nota incorrecta. Debe ser un valor de 0 a 10.")





            
            
            
