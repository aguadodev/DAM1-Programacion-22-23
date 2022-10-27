import time

print("INICIO DEL PROGRAMA:")
print("time.asctime()\t\t",time.asctime())
print("time.ctime()\t\t",time.ctime())
print("time.time()\t\t",time.time())
print("time.time_ns()\t\t",time.time_ns())
print("time.process_time()\t",time.process_time())

seg_inicio = time.time()
time.sleep(2)

print("FIN DEL PROGRAMA:")
print("time.asctime()\t\t",time.asctime())
seg_final = time.time()

print("Segundos transcurridos:\t", round(seg_final - seg_inicio))
