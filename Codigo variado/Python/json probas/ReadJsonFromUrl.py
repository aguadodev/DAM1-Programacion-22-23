import urllib.request, json

# PRODUCTOS OPEN FOOD FACT
print("# PRODUCTOS OPEN FOOD FACT")
codigo_barras = input("Introduce el código de barras [8424523060914]:")
if codigo_barras == "":
    codigo_barras = '8424523060914'

url = 'https://world.openfoodfacts.org/api/v0/product/'+codigo_barras+'.json'
print('url JSON:',url)
url_web = 'https://world.openfoodfacts.org/product/'+codigo_barras
print('url web:',url_web)

resp = urllib.request.urlopen(url)
data = json.loads(resp.read())
print('Producto:',data['product']['generic_name'])
print('Marca:',data['product']['brands'],'\n\n')




# RUTAS OPEN STREET MAP
print("# RUTAS OPEN STREET MAP")
tipo_ruta = 'driving'
latitud_inicio = 42.428181
longitud_inicio = -8.634701
latitud_fin = 42.389456
longitud_fin = -8.710098

url = 'https://router.project-osrm.org/route/v1/'+tipo_ruta+'/'
url += str(longitud_inicio)+','+str(latitud_inicio)+';'
url += str(longitud_fin)+','+str(latitud_fin)+'?overview=false'
print(url)
url_web = 'https://www.openstreetmap.org/directions?engine=fossgis_osrm_bike&route='
url_web += str(latitud_inicio)+','+str(longitud_inicio)+';'
url_web += str(latitud_fin)+','+str(longitud_fin)
print('url web:',url_web)

resp = urllib.request.urlopen(url)
data = json.loads(resp.read())
print(data['code'])
print(data['routes'][0]['distance'])

    
