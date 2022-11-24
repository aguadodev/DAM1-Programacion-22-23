import urllib.request, json

print("# METEOGALICIA")



url_json = "https://servizos.meteogalicia.gal/mgrss/predicion/jsonCPrazo.action?dia=-1&request_locale=es"

resp = urllib.request.urlopen(url_json)
data = json.loads(resp.read())

print("Predicción meteorológica: ", data['listaPredicions'][0]['comentario'])


