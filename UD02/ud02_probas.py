edad = 65

if edad >= 18:
   print("Mayor de Edad")
   print("Ya puedes conducir un coche")
   if edad >= 40 and edad < 50:
        print("Crisis de los 40!!")
   elif edad >= 18 and edad < 40:
        print("Tienes entre 18 y 39 años. Vive la vida!")
   elif edad >= 50 and edad < 60:
        print("Mayor de 50")   
   else:
        print("Me da igual todo")
   print("Fin del tramo para mayores de edad")
else:
    print("Menor de edad")

print("Fin del programa")
