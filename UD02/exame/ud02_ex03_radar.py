

def excesoVelocidade(distancia, tempo, limite):
    velocidadeMedia = distancia / (tempo / 3600)
    return 0 if velocidadeMedia <= limite else velocidadeMedia - limite

def puntosInfraccion(limite, excesoVelocidade):
    if limite <= 50:
        if excesoVelocidade <= 20:
            return 0
        elif excesoVelocidade <= 30:
            return 2
        elif excesoVelocidade <= 40:
            return 4
        else:
            return 6
    else:
        if excesoVelocidade <= 30:
            return 0
        elif excesoVelocidade <= 50:
            return 2
        elif excesoVelocidade <= 60:
            return 4
        else:
            return 6

def multaInfraccion(limite, excesoVelocidade):
    if excesoVelocidade <= 0:
        return 0
    elif limite <= 50:
        if excesoVelocidade <= 20:
            return 100
        elif excesoVelocidade <= 30:
            return 300
        elif excesoVelocidade <= 40:
            return 400
        elif excesoVelocidade <= 50:
            return 500
        else:
            return 600
    else:
        if excesoVelocidade <= 30:
            return 100
        elif excesoVelocidade <= 50:
            return 300
        elif excesoVelocidade <= 60:
            return 400
        elif excesoVelocidade <= 70:
            return 500
        else:
            return 600

# PROBAS 
assert excesoVelocidade(10, 600, 60) == 0
assert excesoVelocidade(10, 600, 50) == 10
assert excesoVelocidade(10, 600, 30) == 30
assert excesoVelocidade(15, 300, 120) == 60
assert excesoVelocidade(15, 300, 90) == 90
assert excesoVelocidade(10, 300, 120) == 0
assert excesoVelocidade(10, 300, 90) == 30

assert multaInfraccion(20, 0) == 0
assert multaInfraccion(20, 15) == 100
assert multaInfraccion(30, 21) == 300
assert multaInfraccion(40, 31) == 400
assert multaInfraccion(50, 50) == 500
assert multaInfraccion(50, 51) == 600

assert multaInfraccion(60, 0) == 0
assert multaInfraccion(70, 30) == 100
assert multaInfraccion(80, 31) == 300
assert multaInfraccion(90, 51) == 400
assert multaInfraccion(100, 61) == 500
assert multaInfraccion(110, 71) == 600
assert multaInfraccion(120, 1) == 100

