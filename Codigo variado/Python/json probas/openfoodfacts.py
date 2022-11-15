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
