import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViajesCompartidos {
    private List<Viaje> viajes;

    public ViajesCompartidos() {
        this.viajes = new ArrayList<>();
    }

    public void agregarViaje(Viaje viaje) {
        this.viajes.add(viaje);
    }

    public void eliminarViaje(Viaje viaje) {
        viajes.remove(viaje);
    }


    public List<Pasajero> obtenerPasajeros(Viaje viaje) {
        return List.of(viaje.getPasajeros());
    }

    public int calcularAsientosDisponibles() {
        int asientosDisponibles = 0;
        for (Viaje viaje : viajes) {
            asientosDisponibles += viaje.getPlazasLibres();
        }
        return asientosDisponibles;
    }

    public List<Viaje> getViajesPorOrigenYFecha(PuntoEncuentro origen, LocalDate fecha) {
        List<Viaje> viajesFiltrados = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if (viaje.puntoSalida.equals(origen) && viaje.fechaHoraSalida.toLocalDate().equals(fecha)) {
                viajesFiltrados.add(viaje);
            }
        }
        Collections.sort(viajesFiltrados, new Comparator<Viaje>() {
            @Override
            public int compare(Viaje v1, Viaje v2) {
                return v1.fechaHoraSalida.compareTo(v2.fechaHoraSalida);
            }
        });
        return viajesFiltrados;
    } 

    public Map<PuntoEncuentro, List<Viaje>> obtenerViajesPorDestino() {
        Map<PuntoEncuentro, List<Viaje>> viajesPorDestino = new HashMap<>();
        for (Viaje viaje : viajes) {
            PuntoEncuentro destino = viaje.getPuntoLlegada();
            if (!viajesPorDestino.containsKey(destino)) {
                viajesPorDestino.put(destino, new ArrayList<>());
            }
            viajesPorDestino.get(destino).add(viaje);
        }
        return viajesPorDestino;
    }    

public Map<PuntoEncuentro, Integer> obtenerCantidadViajesPorDestino() {
    Map<PuntoEncuentro, Integer> cantidadViajesPorDestino = new HashMap<>();
    for (Viaje viaje : viajes) {
        PuntoEncuentro destino = viaje.getPuntoLlegada();
        if (!cantidadViajesPorDestino.containsKey(destino)) {
            cantidadViajesPorDestino.put(destino, 0);
        }
        cantidadViajesPorDestino.put(destino, cantidadViajesPorDestino.get(destino) + 1);
    }
    return cantidadViajesPorDestino;
}

/** Un método que calcule la cantidad total de asientos disponibles en todos los viajes que van hacia un destino dado en una fecha dada. Este método debe tomar como parámetro el destino y la fecha y devolver la suma de la capacidad de todos los coches de los viajes que van hacia ese destino. */

}
