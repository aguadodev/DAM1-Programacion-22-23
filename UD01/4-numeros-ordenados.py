# 
print("Introduce 3 números (pulsa ENTER después de cada uno): ")
num1 = float(input())
num2 = float(input())
num3 = float(input())

# ordenAsc = num1 <= num2 <= num3 # Sintaxis exclusiva de Python
ordenAsc = num1 <= num2 and num2 <= num3
ordenDesc = num3 <= num2 <= num1

print ("Números desordenados" if not(ordenAsc or ordenDesc) else "")
print ("Ordenados de menor a mayor" if ordenAsc else "")
print ("Ordenados de mayor a menor" if ordenDesc else "")
