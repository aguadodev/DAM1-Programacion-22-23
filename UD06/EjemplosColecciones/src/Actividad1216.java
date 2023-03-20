import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Actividad1216 {
    public static void main(String[] args) {
        // Declaración del mapa de la academia
        Map<Character, Academico> academia = new TreeMap<>();;
        // Creación del mapa con ordenación por clave

        // Inserción de nuevos académicos
        Academico.nuevoAcademico(academia, new Academico("Juan", 2015), 'V');
        Academico.nuevoAcademico(academia, new Academico("María", 2007), 'c');
        Academico.nuevoAcademico(academia, new Academico("Pedro", 2010), 'Ñ');
        Academico.nuevoAcademico(academia, new Academico("Lola", 2013), 'A');
        Academico.nuevoAcademico(academia, new Academico("Alba", 1999), 'm');
    
        
        System.out.println("ACADÉMICOS ORDENADOS POR NOMBRE:");
        List<Academico> v = new ArrayList<>(academia.values());
        Comparator<Academico> cNombre = new Comparator<>(){
            @Override
            public int compare(Academico o1, Academico o2) {
                return o1.nombre.compareTo(o2.nombre);
            }            
        };

        v.sort(cNombre);
        System.out.println(v);

        System.out.println("ACADÉMICOS ORDENADOS POR ANHO DE INGRESO:");
        Comparator<Academico> cAnho = new Comparator<>(){
            @Override
            public int compare(Academico o1, Academico o2) {
                return o1.anhoIngreso.compareTo(o2.anhoIngreso);
            }            
        };

        v.sort(cAnho.reversed());
        System.out.println(v);        


        System.out.println("ACADÉMICOS ORDENADOS POR LETRA DE SILLÓN:");
        Set<Map.Entry<Character,Academico>> entradas = academia.entrySet();
        for(Map.Entry<Character,Academico> e : entradas)
            System.out.println(" - " + e);

        //System.out.println("Academia: " + academia);
    }
}


class Academico implements Comparable<Academico>{
    String nombre;
    Integer anhoIngreso;

    public Academico(String nombre, int anhoIngreso) {
        this.nombre = nombre;
        this.anhoIngreso = anhoIngreso;
    }

    @Override
    public String toString() {
        return nombre + " (" + anhoIngreso + ')';
    }
    
    static boolean nuevoAcademico(
                                    Map<Character, Academico> academia, 
                                    Academico nuevo, 
                                    Character letra){
        boolean resultado = true;
        if ((letra >= 'a' && letra <= 'z') || (letra >= 'A' && letra <= 'Z') || letra == 'ñ' || letra == 'Ñ'){
            academia.put(letra, nuevo);
        } else 
            resultado = false;
        
        return resultado;
    }

    @Override
    public int compareTo(Academico o) {
        return nombre.compareTo(o.nombre);
    }    
}

