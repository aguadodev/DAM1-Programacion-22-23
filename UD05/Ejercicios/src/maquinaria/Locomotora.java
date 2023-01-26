package maquinaria;

import personal.Mecanico;

public class Locomotora {
    private String matricula;
    private int potencia;
    private int anhoFabricacion;
    private Mecanico mecanico;

    public Locomotora(String matricula, int potencia, int anhoFabricacion, Mecanico mecanico) {
        this.matricula = matricula;
        this.potencia = potencia;
        this.anhoFabricacion = anhoFabricacion;
        this.mecanico = mecanico;
    }



    @Override
    public String toString() {
        String str = "Locomotora:" +
                "\nMatrícula = " + matricula +
                "\nPotencia = " + potencia +
                "\nAño Fabricación = " + anhoFabricacion +
                "\nMecánico = " + mecanico;        
        
        return str;
    }



    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getAnhoFabricacion() {
        return anhoFabricacion;
    }

    public void setAnhoFabricacion(int anhoFabricacion) {
        this.anhoFabricacion = anhoFabricacion;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    
    

}
