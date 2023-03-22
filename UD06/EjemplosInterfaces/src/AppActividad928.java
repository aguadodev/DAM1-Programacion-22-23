/**
 * AppActividad928
 */
public class AppActividad928 {
    public static void main(String[] args) {
        Jornada[] jornadas = {
            new Jornada("33333333C", "22/03/2023", "8:10", "14:30"),
            new Jornada("33333333C", "18/02/2023", "10:10", "14:30"),
            new Jornada("22222222B", "22/01/2023", "9:10", "14:30"),
            new Jornada("11111111A", "22/03/2023", "8:10", "14:30"),
            new Jornada("22222222B", "10/01/2023", "15:00", "20:30"),
        };

        // Ordena las jornadas por el criterio de orden natural
        jornadas.sort();

        // Imprime las jornadas
        for (int i = 0; i < jornadas.length; i++){
            System.out.println(jornadas[i]);
        }

        // Completa a continuación el código necesario para 
        // ordenar las jornadas por fecha, hora de inicio y hora de fin
        // y mostrar las jornadas en el formato: "Fecha - HoraInicio - Hora Fin - DNI"
    }
}