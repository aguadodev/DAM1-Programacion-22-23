from binascii import a2b_base64
from re import A


def is_year_leap(year):
    bisiesto = False
    if year < 1582:
        bisiesto = False
    else:
        if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
            bisiesto = True
    return bisiesto

def days_in_month(year, month):
    if month == 1 or month == 3 or month == 5 or month == 7 or month == 8 or month == 10 or month == 12:
    # if month in [1, 3, 5, 7, 8, 10, 12]:  # Sintaxis usando listas
        # Meses de 31 días
        return 31
    elif month == 4 or month == 6 or month == 9 or month == 11:
        # Meses de 30 días
        return 30
    elif month == 2:
        # Febrero
        if is_year_leap(year):
            return 29
        else:
            return 28
    else:
        # Valores devuelto si el número de mes es inválido
        return None

def day_of_year(year, month, day):
    diasMes = days_in_month(year, month)
    if year > 0 and day > 0 and diasMes != None and day <= diasMes:
        #Calcular número de día

        return "Fecha Correcta. Pendiente calcular número de día"
    else:
        return None

print(day_of_year(1999, 2, 22))