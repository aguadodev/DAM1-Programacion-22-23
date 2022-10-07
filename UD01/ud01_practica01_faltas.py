# Entrada: nombre del módulo y número de horas
MODULO = "Programación"
HORAS = 240
MINUTOS_SESION = 50
PORCENTAJE_APERCIBIMIENTO = 6
PORCENTAJE_PERDIDA = 10

# Proceso: 
# Calcular número de sesiones
sesiones = HORAS * 60 / MINUTOS_SESION

# Calcular 6% Apercibimiento
sesionesApercibimiento = sesiones * PORCENTAJE_APERCIBIMIENTO / 100

# Calcular %10 Pérdida Avaliación
sesionesPerdida = sesiones * PORCENTAJE_PERDIDA / 100

# Salida: Mostrar resultados
print("Sesiones del módulo de", MODULO, ":", int(sesiones))
print("Máximo de Faltas para Apercibimiento:", int(sesionesApercibimiento))
print("Máximo de Faltas para Pérdida de Evaluación Continua:", int(sesionesPerdida))

# Entrada: faltas del alumno/a
faltasAlumno = int(input("Introduce las faltas de un alumno/a: "))
apercibimiento = faltasAlumno > sesionesApercibimiento
perdida = faltasAlumno > sesionesPerdida

# Salida: estado
print("Apercibimiento" if apercibimiento else "")
print("Pérdida de Evaluación Continua!!" if perdida else "")