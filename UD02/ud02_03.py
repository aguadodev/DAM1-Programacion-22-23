print("Resolución de ecuaciones de segundo grado:")
a = int(input("Coeficiente \"a\":"))
b = int(input("Coeficiente \"b\":"))
c = int(input("Coeficiente \"c\":"))

discriminante = b ** 2 - 4 * a * c

if discriminante < 0:
    print("La ecuación no tiene solución")
else:
    x1 = (-b + discriminante ** 0.5) / (2 * a)
    x2 = (-b - discriminante ** 0.5) / (2 * a)
    print("Las soluciones son",x1,"y",x2)