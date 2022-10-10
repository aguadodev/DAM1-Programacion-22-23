num1 = int(input("Escribe un número:"))
num2 = int(input("Escribe otro número:"))
num3 = int(input("Escribe un último número:"))

print("Los números ordenados de mayor a menor:")

if num1 > num2:
    if num1 > num3:
        if num2 > num3:
            print(num1, num2, num3)
        else:
            print(num1, num3, num2)
    else:
        print(num3, num1, num2)
else:
    if num2 > num3:
        if num1 > num3:
            print(num2, num1, num3)
        else:
            print(num2, num3, num1)
    else:
        print(num3, num2, num1)

        