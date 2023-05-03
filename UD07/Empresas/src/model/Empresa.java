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

    public String toCsv(){
        return id + "," + nombre + "," + web;
    }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empresa other = (Empresa) obj;
        if (id != other.id)
            return false;
        return true;
    }


    
}
