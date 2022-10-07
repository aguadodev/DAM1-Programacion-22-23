i = 8
j = 5
x = 0.005
y = -0.01

print("A", i <= j) # F
print("C", j != 6) # T
print("D", not(i <= j)) # T
print("F", -j == i - 13) # T
print("G", 2 * x + y == 0) # T        
print("H", 2 * x + (y == 0)) # 0.01
print("J", - (i + j) != -i + j) # T
print("K", i <= j and i >= c) # F
print("N", x > y and i > 0 or j < 5) # T
print("P", i <= j and i >= c or True) # T
