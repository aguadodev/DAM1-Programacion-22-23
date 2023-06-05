public class Aparcamiento {
    private int capacidadMaxima;
    private Vehiculo[] plazas;

    public Aparcamiento(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        plazas = new Vehiculo[capacidadMaxima];
    }

    public Aparcamiento() {
        this(100);
    }    

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public boolean aparcarVehiculo(Vehiculo vehiculo){
        boolean aparcado = false;
        int i = 0;
        while (i < capacidadMaxima && !aparcado){
            if (plazas[i] == null){
                plazas[i] = vehiculo;
                aparcado = true;
            } else
                i++;
        }
        return aparcado;
    }
    
    public boolean sacarVehiculo(Vehiculo vehiculo){
        boolean cocheRetirado = false;

        int i = 0;
        while (i < capacidadMaxima && !cocheRetirado){
            if (plazas[i].equals(vehiculo)){
                plazas[i] = null;
                cocheRetirado = true;
            } else {
                i++;
            }                
        }
        return cocheRetirado;
    }

    public int numPlazasLibres(){
        int contador = 0;
        for (int i = 0; i < plazas.length; i++)
            if (plazas[i] == null)
                contador++;
        return contador;
    }

    public void mostrarEstado(){
        int numPlazasLibres = numPlazasLibres();
        System.out.println("Plazas Libres: " + numPlazasLibres);
        System.out.println("Plazas Ocupadas: " + (plazas.length - numPlazasLibres));
    }

public static void main(String[] args) {
    Aparcamiento p1 = new Aparcamiento();
    System.out.println("PARKING VACÍO");
    p1.mostrarEstado();
    p1.aparcarVehiculo(new Vehiculo("1234AAA"));
    System.out.println("APARCO UN VEHICULO");
    p1.mostrarEstado();
    p1.sacarVehiculo(new Vehiculo("1234AAA"));
    System.out.println("SACO UN VEHICULO");
    p1.mostrarEstado();
}

}


class Vehiculo {
    private String matricula;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
        Vehiculo other = (Vehiculo) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }    

    

}