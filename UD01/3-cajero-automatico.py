#
importe = int(input("Importe en efectivo que desea retirar (€): "))

billetes50 = importe // 50
resto = importe % 50
billetes20 = resto // 20
resto %= 20 
billetes10 = resto // 10
resto %= 10 
billetes5 = resto // 5
resto %= 5

print("Se retirarán ", importe - resto ,"€")
print(billetes50, "billetes de 50€: ")
print(billetes20, "billetes de 20€: ")
print(billetes10, "billetes de 10€: ")
print(billetes5, "billetes de 5€: ")
print(str(resto) + " € no se retirarán por no haber billetes tan pequeños" if resto else "")
