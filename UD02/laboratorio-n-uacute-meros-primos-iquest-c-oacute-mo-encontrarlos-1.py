def is_prime(num):
    for i in range(2,num // 2 + 1):
        if num % i == 0:
            return False
    return True

# Función inicial menos eficiente
def is_prime2(num):
    primo = True
    for i in range(2,num):
        if num % i == 0:
            primo = False
    return primo


for i in range(1, 20000):
	if is_prime(i + 1):
			print(i + 1, end=" ")
print()