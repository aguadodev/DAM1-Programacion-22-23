def es_bisiesto(year):
    bisiesto = False
    if year < 1582:
        bisiesto = False
    else:
        if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
            bisiesto = True
    return bisiesto

test_data = [1900, 2000, 2016, 1987]
test_results = [False, True, True, False]
for i in range(len(test_data)):
	yr = test_data[i]
	print(yr,"->",end="")
	result = es_bisiesto(yr)
	if result == test_results[i]:
		print("OK")
	else:
		print("Fallido")
