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



test_years = [1900, 2000, 2016, 1987]
test_months = [2, 2, 1, 11]
test_results = [28, 29, 31, 30]
for i in range(len(test_years)):
	yr = test_years[i]
	mo = test_months[i]
	print(yr, mo, "->", end="")
	result = days_in_month(yr, mo)
	if result == test_results[i]:
		print("OK")
	else:
		print("Fallido")