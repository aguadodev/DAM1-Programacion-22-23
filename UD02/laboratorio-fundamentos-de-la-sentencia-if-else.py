income = float(input("Introduce el ingreso anual:"))

UMBRAL_IMPUESTO = 85528
EXENCION_FISCAL = 556.02

if income <= UMBRAL_IMPUESTO:
    tax = income * 18 / 100 - EXENCION_FISCAL
else:
    tax = 14839.02 + (income - UMBRAL_IMPUESTO) * 32 / 100

if tax < 0:
    tax = 0

tax = round(tax, 0)
print("El impuesto es:", tax, "euros")