A = -123
A4 = 4567
precio = 10

print("E", A % 10 / 2) # 1.5
print("F", A % 10 + A % 100 // 10 + A // 100) # 6
print("H", A % 2 == 0 and A % 3 == 0) # 
print("Hb", A % 6 == 0) # porque 6 es el m.c.m. de 2 y 3
print("K", A4 // 1000 % 2 == 0) # 
print("M", precio >= 10 and precio < 50) # 
print("Mb", 10 <= precio < 50) # Sintaxis permitida en Python?

#...

A = 5 if A < 0 else 100
print("JJ", A)