package maquinaria;

import java.util.Arrays;

import personal.Maquinista;

public class Tren {
    private Locomotora locomotora;
    private Vagon[] vagones;
    private Maquinista maquinista;

    /***** CONTRUCTORES */

    public Tren(Locomotora locomotora, Vagon[] vagones, Maquinista maquinista) {
        this.locomotora = locomotora;
        this.vagones = vagones;
        this.maquinista = maquinista;
    }

    public Tren() {
    }

    public int getCargaActual(){
        int carga = 0;
        
        for(Vagon v: vagones)
            carga += v.getCargaActual();

        return carga;
    }

    public int getCapacidadMaxima(){
        int capacidad = 0;

        for(Vagon v: vagones)
        capacidad += v.getCargaMaxima();
        
        return capacidad;
    }    

    public double getPorcentajeCarga(){
        int capacidad = getCapacidadMaxima();

        if (capacidad > 0)
            return (double)getCargaActual()/getCapacidadMaxima();
        else
            return 0;
    }

    /*****  GETTERS Y SETTERS  */

    public Locomotora getLocomotora() {
        return locomotora;
    }

    public void setLocomotora(Locomotora locomotora) {
        this.locomotora = locomotora;
    }

    public void addVagon(int num, int cargaMaxima, int cargaActual, String tipoMercancia){
        if (vagones == null){
            vagones = new Vagon[0];
        }
        if (vagones.length < 5){
            vagones = Arrays.copyOf(vagones, vagones.length + 1);

            vagones[vagones.length - 1] = new Vagon(num, cargaMaxima, cargaActual, tipoMercancia);
        }
    }

    public Vagon[] getVagones() {
        return vagones;
    }

    public void setVagones(Vagon[] vagones) {
        this.vagones = vagones;
    }


    public Maquinista getMaquinista() {
        return maquinista;
    }



    public void setMaquinista(Maquinista maquinista) {
        this.maquinista = maquinista;
    }



    @Override
    public String toString() {
        String str = "Tren:" +
                "\nMaquinista = " + maquinista +
                "\nLocomotora = " + locomotora +
                "\nVagones = ";
                
        for (int i = 0; i < vagones.length; i++){
            str += "\n" + i + ". " + vagones[i];
        }

        return str;
    }

    

}
