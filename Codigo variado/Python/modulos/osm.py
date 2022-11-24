#!/usr/bin/env python3 

""" mod_osm.py - Un módulo Python para usar Open Street Maps """

import urllib.request, json

def distanciaCoche(latitud_inicio, longitud_inicio, latitud_fin, longitud_fin):
    tipo_ruta = 'driving'
    url_json = 'https://router.project-osrm.org/route/v1/'+tipo_ruta+'/'
    url_json += str(longitud_inicio)+','+str(latitud_inicio)+';'
    url_json += str(longitud_fin)+','+str(latitud_fin)+'?overview=false'

    resp = urllib.request.urlopen(url_json)
    data = json.loads(resp.read())

    return data['routes'][0]['distance']



if __name__ == "__main__":
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

    
