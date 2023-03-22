import java.util.Arrays;
import java.util.Comparator;

/**
 * AppActividad928
 */
public class AppActividad928 {
    public static void main(String[] args) {
        Jornada[] jornadas = {
                new Jornada("33333333C", "22/03/2023", "08:10", "14:30"),
                new Jornada("33333333C", "18/02/2023", "10:10", "14:30"),
                new Jornada("22222222B", "22/01/2023", "09:10", "14:30"),
                new Jornada("11111111A", "22/03/2023", "08:10", "11:30"),
                new Jornada("11111111A", "22/03/2023", "10:00", "14:30"),
                new Jornada("11111111A", "22/03/2023", "08:10", "14:30"),
                new Jornada("22222222B", "10/01/2023", "15:00", "20:30"),
        };

        // Ordena las jornadas por el criterio de orden natural
        Arrays.sort(jornadas);

        // Imprime las jornadas
        for (int i = 0; i < jornadas.length; i++) {
            System.out.println(jornadas[i]);
        }

        // Completa a continuación el código necesario para
        // ordenar las jornadas por fecha, hora de inicio y hora de fin
        // y mostrar las jornadas en el formato: "Fecha - HoraInicio - HoraFin - DNI"

        Comparator<Jornada> compFechaHoras = generaComparatorFechaHoras();

        // Ordena las jornadas por fecha, hora de inicio y hora de fin
        Arrays.sort(jornadas, compFechaHoras);

        // Imprime las jornadas
        for (int i = 0; i < jornadas.length; i++) {
            System.out.println(jornadas[i].fecha + " - " +
                    jornadas[i].horaInicio + " - " +
                    jornadas[i].horaFin + " - " +
                    jornadas[i].dni);
        }

        // Utiliza un método genérico para mostrar la jornada con mayor cantidad de minutos trabajados
        System.out.print("Jornada con mayor número de minutos trabajados: ");
        System.out.println(maximo(jornadas, (j1, j2) -> (j1.minutosTrabajados().compareTo(j2.minutosTrabajados()))));

    }

    private static <T> T maximo(T[] t, Comparator<T> comp) {
        T max = t[0];

        for(T e : t){
            if (comp.compare(e, max) > 0)
                max = e;
        }
        return max;
    }


    private static Comparator<Jornada> generaComparatorFechaHoras() {
        Comparator<Jornada> cFecha, cHoraInicio, cHoraFin;

        // Comparator de Fechas generado con una expresión lambda
        cFecha = (o1, o2) -> o1.fecha.compareTo(o2.fecha);

        // Comparator de HoraInicio generado con una clase anónima
        cHoraInicio = new Comparator<>() {
            @Override
            public int compare(Jornada o1, Jornada o2) {
                return o1.horaInicio.compareTo(o2.horaInicio);
            }
        };

        cHoraFin = new Comparator<>() {
            @Override
            public int compare(Jornada o1, Jornada o2) {
                return o1.horaFin.compareTo(o2.horaFin);
            }
        };
        

        return cFecha.thenComparing(cHoraInicio).thenComparing(cHoraFin);

    }

    private static Comparator<Jornada> generaComparatorFechaHoras2() {
        Comparator<Jornada> compFechaHoras = (o1, o2) -> {
                int compFecha = o1.fecha.compareTo(o2.fecha);

                if (compFecha != 0) {
                    return compFecha;
                } else {
                    int compHoraInicio = o1.horaInicio.compareTo(o2.horaInicio);
                    if (compHoraInicio != 0) {
                        return compHoraInicio;
                    } else {
                        return o1.horaFin.compareTo(o2.horaFin);
                    }
                }            
        };

        return compFechaHoras;
    }

}