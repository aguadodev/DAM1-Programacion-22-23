package maquinaria;

import java.util.Arrays;

import personal.Maquinista;

public class Tren {
    public Locomotora locomotora;
    Vagon[] vagones = new Vagon[5];
    Maquinista maquinista;
    @Override
    public String toString() {
        return "Tren:" +
                "\nlocomotora=" + locomotora + 
                "\nvagones=" + Arrays.toString(vagones) + 
                "\nmaquinista=" + maquinista;
    }

    

}
