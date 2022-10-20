def liters_100km_to_miles_gallon(liters):
    # litros / 100 km
    # millas / galones
    METROS_MILLA = 1609.344
    LITROS_GALON = 3.785411784
    galones = liters / LITROS_GALON
    millas = 100 * 1000 / METROS_MILLA
    return millas / galones

def miles_gallon_to_liters_100km(miles):
    METROS_MILLA = 1609.344
    LITROS_GALON = 3.785411784
    km100 = miles * METROS_MILLA / 1000 / 100
    return LITROS_GALON / km100

print(liters_100km_to_miles_gallon(3.9))
print(liters_100km_to_miles_gallon(7.5))
print(liters_100km_to_miles_gallon(10.))
print(miles_gallon_to_liters_100km(60.3))
print(miles_gallon_to_liters_100km(31.4))
print(miles_gallon_to_liters_100km(23.5))