segundos = int(input("Total de segundos:"))

h = segundos // 3600
m = segundos % 3600 // 60
s = segundos % 60

print(h, m, s, sep=":")