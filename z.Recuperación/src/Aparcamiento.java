import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aparcamiento {
    private int capacidadMaxima;
    private Vehiculo[] plazas;
    private int alturaMaxima;

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

    public int getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(int alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    public boolean aparcarVehiculo(Vehiculo vehiculo) {
        boolean aparcado = false;
        
        // Sólo intentamos aparcar el vehículo si no está ya en el aparcamiento
        if (consultarPlazaVehiculo(vehiculo) == -1) {
            boolean aparcable = true;
            // Si se trata de un VehiculoPesado que supera la altura máxima no es aparcable.
            if (vehiculo.getClass().getCanonicalName().equals("VehiculoPesado")){
                VehiculoPesado vp = (VehiculoPesado) vehiculo;
                if (vp.getAltura() > alturaMaxima){
                    aparcable = false;
                }
            }

            if (aparcable) {
                int i = 0;
                while (i < capacidadMaxima && !aparcado) {
                    if (plazas[i] == null) {
                        plazas[i] = vehiculo;
                        aparcado = true;
                    } else
                        i++;
                }                
            }
        }

        return aparcado;
    }

    public boolean sacarVehiculo(Vehiculo vehiculo) {
        boolean cocheRetirado = false;

        int i = 0;
        while (i < capacidadMaxima && !cocheRetirado) {
            if (plazas[i] != null && plazas[i].equals(vehiculo)) {
                plazas[i] = null;
                cocheRetirado = true;
            } else {
                i++;
            }
        }
        return cocheRetirado;
    }

    public int numPlazasLibres() {
        int contador = 0;
        for (int i = 0; i < plazas.length; i++)
            if (plazas[i] == null)
                contador++;
        return contador;
    }

    public boolean estaVacio(){
        return numPlazasLibres() == capacidadMaxima;
    }    

    int[] plazasLibres() {
        int[] plazasLibres = new int[0];

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                // Añado el número de plaza libre al resultado
                plazasLibres = Arrays.copyOf(plazasLibres, plazasLibres.length + 1);
                plazasLibres[plazasLibres.length - 1] = i;
            }
        }

        return plazasLibres;
    }

    public void mostrarEstado() {
        int numPlazasLibres = numPlazasLibres();
        System.out.println("ESTADO DEL APARCAMIENTO:");
        System.out.println("Plazas Libres: " + numPlazasLibres);
        System.out.println("Plazas Ocupadas: " + (plazas.length - numPlazasLibres));
    }

    public void mostrarEstadoDetallado() {
        System.out.println("ESTADO DETALLADO DEL APARCAMIENTO:");
        System.out.println("==================================");
        System.out.println("Plaza\tMatrícula");
        System.out.println("-----\t---------");
        for(int i = 0; i < capacidadMaxima; i++){
            if (plazas[i] != null) 
                System.out.println(i + "\t" + plazas[i].getMatricula());
        }

    }

    Vehiculo consultarPlaza(int numeroPlaza) {
        if (numeroPlaza < 0 || numeroPlaza >= capacidadMaxima)
            return null;
        else
            return plazas[numeroPlaza];
    }

    int consultarPlazaVehiculo(Vehiculo vehiculo) {
        int numPlaza = -1;

        int i = 0;
        while (i < capacidadMaxima && numPlaza == -1) {
            if (plazas[i] != null && plazas[i].equals(vehiculo)) {
                numPlaza = i;
            }
            i++;
        }
        return numPlaza;
    }

    boolean aparcarGrupoVehiculos(List<Vehiculo> vehiculos) {
        boolean aparcados = false;

        // Verifica si hay suficiente capacidad en el aparcamiento para aparcar el grupo
        // completo.
        if (numPlazasLibres() >= vehiculos.size()) {
            // Verifica si algún vehículo de la lista ya se encuentra en el aparcamiento.
            int i = 0;
            while (i < vehiculos.size() && consultarPlazaVehiculo(vehiculos.get(i)) == -1) {
                i++;
            }

            // Si no encontró ningún vehículo ya aparcado ccontinúa para aparcarlos.
            if (i == vehiculos.size()) {
                for (Vehiculo v : vehiculos)
                    aparcarVehiculo(v);
                aparcados = true;
            }
        }

        return aparcados;
    }

    boolean sacarGrupoVehiculos(List<Vehiculo> vehiculos){
        boolean cochesSacados = true;

        for (Vehiculo v : vehiculos){
            if (!sacarVehiculo(v))
                cochesSacados = false;
        }

        return cochesSacados;
    }


    List<Vehiculo> vehiculosAparcados() {
        List<Vehiculo> lista = null;
        if (!estaVacio()){  // Es menos eficiente, obliga a recorrer 2 veces el array
            lista = new ArrayList<>();
            for(Vehiculo v : plazas){
                if (v != null)
                    lista.add(v);
            }
            lista.sort(Comparator.naturalOrder());
        }
        return lista;
    }

    Map<Integer, Vehiculo> plazasVehiculos() {
        Map<Integer, Vehiculo> mapa = null;
        
        mapa = new HashMap<>();
        for(int i = 0; i < capacidadMaxima; i++){            
            if (plazas[i] != null)
                mapa.put(i, plazas[i]);
        }

        if (mapa.isEmpty())
            return null;
        else
            return mapa;
    }

    public static void main(String[] args) {
        System.out.println("PARKING VACÍO");
        Aparcamiento p1 = new Aparcamiento(10);
        p1.mostrarEstado();

        System.out.println("APARCO VEHICULOS");
        p1.aparcarVehiculo(new Vehiculo("1234AAA"));
        p1.aparcarVehiculo(new Vehiculo("1234AAA")); // Éste ya está aparcado, no lo aparcará
        p1.aparcarVehiculo(new Vehiculo("1234BBB"));
        p1.aparcarVehiculo(new Vehiculo("1234CCC"));
        p1.mostrarEstado();
        System.out.println(p1.consultarPlazaVehiculo(new Vehiculo("1234AAA")));

        System.out.println("SACO UN VEHICULO");
        p1.sacarVehiculo(new Vehiculo("1234BBB"));
        p1.mostrarEstado();
        System.out.println(p1.consultarPlazaVehiculo(new Vehiculo("1234BBB")));
        System.out.println(Arrays.toString(p1.plazasLibres()));

        List<Vehiculo> listaCoches = new ArrayList<>();
        listaCoches.add(new Vehiculo("1234DDD"));
        listaCoches.add(new VehiculoPesado("1234EEE", 200));
        listaCoches.add(new Vehiculo("1234FFF"));
        listaCoches.add(new Vehiculo("1234GGG"));
        listaCoches.add(new Vehiculo("1234HHH"));
        //listaCoches.add(new Vehiculo("1234AAA"));

        System.out.println(p1.aparcarGrupoVehiculos(listaCoches));
        System.out.println(Arrays.toString(p1.plazasLibres()));
        p1.mostrarEstadoDetallado();
        List<Vehiculo> l = p1.vehiculosAparcados();
        l.sort(Comparator.reverseOrder());
        System.out.println("Lista ordenada de vehículos: " + l);


        // Sacar Grupo de Vehículos
        List<Vehiculo> listaCoches2 = new ArrayList<>();
        listaCoches2.add(new Vehiculo("1234DDD"));
        listaCoches2.add(new Vehiculo("1234EEE"));
        listaCoches2.add(new Vehiculo("1234FFF"));
        System.out.println(p1.sacarGrupoVehiculos(listaCoches2));
        p1.mostrarEstadoDetallado();
        System.out.println(Arrays.toString(p1.plazasLibres()));           
    }

}

class Vehiculo implements Comparable<Vehiculo>{
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

    @Override
    public int compareTo(Vehiculo o) {
        return matricula.compareTo(o.matricula);
    }

    @Override
    public String toString() {
        return matricula;
    }

}

class VehiculoPesado extends Vehiculo {
    private int peso; // kilos
    private int altura; // altura

    public VehiculoPesado(String matricula, int altura) {
        super(matricula);
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}