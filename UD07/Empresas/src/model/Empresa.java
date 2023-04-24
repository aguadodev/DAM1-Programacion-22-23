package model;
public class Empresa {
    int id;
    String nombre;
    String web;
    
    public Empresa(int id, String nombre, String web) {
        this.id = id;
        this.nombre = nombre;
        this.web = web;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }


    
}
