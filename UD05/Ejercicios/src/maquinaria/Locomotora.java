package maquinaria;

import personal.Mecanico;

public class Locomotora {
    String matricula;
    int potencia;
    int anhoFabricacion;
    Mecanico mecanico;

    public Locomotora(String matricula, int potencia, int anhoFabricacion, Mecanico mecanico) {
        this.matricula = matricula;
        this.potencia = potencia;
        this.anhoFabricacion = anhoFabricacion;
        this.mecanico = mecanico;

    
    }

    @Override
    public String toString() {
        return "Locomotora [matricula=" + matricula + ", anhoFabricacion=" + anhoFabricacion + "]";
    }

    

}
