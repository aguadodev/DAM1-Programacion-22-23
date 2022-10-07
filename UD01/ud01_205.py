X = True
Y = False
Z = True

print("A", (X and Y) or (X and Z))
print("B", (X or not Y) and (not X or Z))
print("C", X or Y and Z)
print("F", not X or not Y or Z and X and not Y)


