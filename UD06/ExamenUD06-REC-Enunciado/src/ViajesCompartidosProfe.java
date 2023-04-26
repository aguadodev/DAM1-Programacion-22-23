import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ViajesCompartidos {
    private List<Viaje> viajes;

    public ViajesCompartidos() {
        this.viajes = new ArrayList<>();
    }


    public List<Viaje> getViajes() {
        return viajes;
    }




    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    
    // 1. agregar un nuevo viaje a la lista.
    public boolean agregarViaje(Viaje viaje) {
        if (!viajes.contains(viaje))
            return this.viajes.add(viaje);            
        else
            return false;
            
    }

    // 2. eliminar un viaje dado de la lista.
    public boolean eliminarViaje(Viaje viaje) {
        return viajes.remove(viaje);
    }

    // 3. obtener la lista de todos los pasajeros que van en un determinado viaje.
    public List<Pasajero> obtenerPasajeros(Viaje viaje) {
        return Arrays.asList(viaje.getPasajeros());
    }

    // 4. calcular la cantidad total de asientos disponibles en todos los viajes de
    // la lista.
    public int calcularAsientosDisponibles() {
        int asientosDisponibles = 0;
        for (Viaje viaje : viajes) {
            asientosDisponibles += viaje.getPlazasLibres();
        }
        return asientosDisponibles;
    }

    // 5. obtener la lista de todos los viajes que van desde un origen dado en una
    // fecha dada, ordenados por ascendentemente por fecha.
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

    // 6. lista de todos puntos de encuentro utilizados como puntos de salida o
    // llegada de todos los viajes, sin repetidos.
    public List<PuntoEncuentro> obtenerPuntosEncuentro() {
        Set<PuntoEncuentro> puntos = new HashSet<>();

        for (Viaje viaje : viajes) {
            puntos.add(viaje.puntoSalida);
            puntos.add(viaje.puntoLlegada);
        }

        return new ArrayList<>(puntos);
    }

    // 7. mapa que relacione cada destino con la lista de los viajes que van hacia
    // ese destino.
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

    // 8. cantidad total de asientos disponibles en todos los viajes que van hacia
    // un destino dado en una fecha dada. Este método debe tomar como parámetro el
    // destino y la fecha y devolver la suma de la capacidad de todos los coches de
    // los viajes que van hacia ese destino.
    public int capacidadDisponible(PuntoEncuentro destino, LocalDate fecha) {
        int capacidadTotal = 0;
        for (Viaje viaje : viajes) {
            if (viaje.getPuntoLlegada().equals(destino)
                    && viaje.getFechaHoraSalida().toLocalDate().equals(fecha)) {
                capacidadTotal += viaje.getPlazasLibres();
            }
        }
        return capacidadTotal;
    }

}
