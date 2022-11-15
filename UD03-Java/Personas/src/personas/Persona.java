/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personas;

/**
 *
 * @author oaguado
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private double peso;  // en kg
    private int estatura; // en cm
    
    public void setPeso(double kg){
        if (kg < 0) 
            peso = 0;
        else
            peso = kg;
    }
    
    public double getPeso(){
        return peso;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        if (estatura < 0)
            this.estatura = 0;
        else
            this.estatura = estatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public double imc(){
        return peso / Math.pow((estatura / 100.0),2);
    }
    
    
    
    
}
