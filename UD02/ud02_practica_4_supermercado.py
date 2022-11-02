

def leerProducto():    
    while True:
        try:
            precio = float(input("Precio del producto (0 para cancelar):"))
            if precio == 0:
                return None
            elif precio < 0:
                print("El precio no puede ser negativo. Vuelve a intentarlo")
            else:
                unidades = int(input("Número de unidades:"))
                if unidades > 0:
                    return precio * unidades
                else:
                    print("El número de unidades debe ser mayor que cero. Vuelve a intentarlo.")
        except:
            print("Error en la introducción de datos. Vuelve a intentarlo")


def pagoConTarjeta():
    if input("Pago con tarjeta [1] o en efectivo [otra tecla]?") == "1":
        return True
    else:
        return False

def leerImporteCliente(importeCompra):
    while True:
        try:
            importeUsuario = float(input("Importe pagado por el cliente:"))
            if importeUsuario >= importeCompra:
                return importeUsuario
            else:
                print("El importe aportado es insuficiente. Vuelve a intentarlo.")
        except:
            print("Error en la introducción de datos. Vuelve a intentarlo")


def devolverCambio(importeTotal, importeCliente):
    cambio = importeCliente - importeTotal

    # Separa los euros y los céntimos de cambio a devolver
    cambioEuros = int(cambio)
    cambioCentimos = int((cambio - cambioEuros) * 100)

    # Desglosa el cambio en euros
    b20 = cambioEuros // 20
    cambioEuros %= 20
    b5 = cambioEuros // 5
    m1 = cambioEuros % 5

    # Desglosa el cambio en céntimos
    m20c = cambioCentimos // 20
    cambioCentimos %= 20
    m5c = cambioCentimos // 5
    m1c = cambioCentimos % 5

    if b20 > 0:
        print(b20,"billetes de 20 euros")
    if b5 > 0:
        print(b5,"billetes de 5 euros")
    if m1 > 0:
        print(m1,"monedas de 1 euro")
    if m20c > 0:
        print(m20c,"monedas de 20 céntimos")
    if m5c > 0:
        print(m5c,"monedas de 5 céntimos")
    if m1c > 0:
        print(m1c,"monedas de 1 céntimo")






# PROGRAMA PRINCIPAL
print("\nCAJA DE SUPERMERCADO:\n")

importeCompra = 0

importeProducto = leerProducto()
while importeProducto != None:
    importeCompra += importeProducto
    print("Importe total acumulado:", importeCompra)
    importeProducto = leerProducto()

if pagoConTarjeta():
    print("COMPRA PAGADA CON TARJETA")
else:
    print("PAGO EN EFECTIVO:")
    importeCliente = leerImporteCliente(importeCompra)
    devolverCambio(importeCompra, importeCliente)
