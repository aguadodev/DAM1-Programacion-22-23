# módulo mis_funciones.py

def dibujaTriangulo(altura):
    for i in range(1,altura + 1):
        print(" " * (altura - i), "* " * i)