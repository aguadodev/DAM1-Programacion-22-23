import java.time.LocalDate;

public class Alumno {
    int num;
    String nombre;
    LocalDate fnac;
    double media;
    String curso;











    
    @Override
    public String toString() {
        return "Alumno [num=" + num + ", nombre=" + nombre + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + num;
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
        Alumno other = (Alumno) obj;
        if (num != other.num)
            return false;
        return true;
    }

    public Alumno(int num, String nombre, LocalDate fnac, double media, String curso) {
        this.num = num;
        this.nombre = nombre;
        this.fnac = fnac;
        this.media = media;
        this.curso = curso;
    }

    public Alumno() {
    }
    
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFnac() {
        return fnac;
    }
    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;
    }
    public double getMedia() {
        return media;
    }
    public void setMedia(double media) {
        this.media = media;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    

}
