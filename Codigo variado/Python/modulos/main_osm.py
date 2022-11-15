import osm

latitud_inicio = 42.428181
longitud_inicio = -8.634701
latitud_fin = 42.389456
longitud_fin = -8.710098

distancia = osm.distanciaCoche(latitud_inicio, longitud_inicio, latitud_fin, longitud_fin)

print("Distancia:", round(distancia / 1000,3),"km")