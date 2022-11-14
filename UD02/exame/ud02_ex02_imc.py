def imc(kg, cm):
    return kg / (cm / 100) ** 2

# PROBAS
assert imc(45, 160) == 17.578124999999996
assert imc(65, 165) == 23.875114784205696
assert imc(80, 170) == 27.68166089965398
assert imc(100, 175) == 32.6530612244898