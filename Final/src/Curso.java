import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Curso {
    private int id;
    private String nombre;
    private String descripcion;
    private int duracion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ArrayList<Alumno> alumnosMatriculados;

    public Curso(int id, String nombre, String descripcion, int duracion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.alumnosMatriculados = new ArrayList<>();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ArrayList<Alumno> getAlumnosMatriculados() {
        return alumnosMatriculados;
    }

    public void matricularAlumno(Alumno alumno) {
        if (LocalDate.now().isBefore(fechaInicio)) {
            alumnosMatriculados.add(alumno);
        } else {
            System.out.println("No se permiten matrículas una vez iniciado el curso.");
        }
    }

    public int numAlumnosMatriculados() {
        return alumnosMatriculados.size();
    }

    public void listarAlumnos() {
        System.out.println("Alumnos matriculados en el curso " + nombre + " (" + numAlumnosMatriculados() +"):");
        for (Alumno alumno : alumnosMatriculados) {
            System.out.println("- " + alumno.getNombre());
        }
    }


public static void main1(String[] args) {
// Crear alumnos
Alumno alumno1 = new Alumno(1, "Juan");
Alumno alumno2 = new Alumno(2, "María");
Alumno alumno3 = new Alumno(3, "Pedro");
Alumno alumno4 = new Alumno(4, "Laura");
Alumno alumno5 = new Alumno(5, "Carlos");
Alumno alumno6 = new Alumno(6, "Ana");
Alumno alumno7 = new Alumno(7, "Pablo");
Alumno alumno8 = new Alumno(8, "Sofía");
Alumno alumno9 = new Alumno(9, "Marta");
Alumno alumno10 = new Alumno(10, "Alejandro");

    // Crear cursos
    CursoDistancia curso1 = new CursoDistancia(1, "Programación en Java", "Aprende a programar en Java", 40,
            LocalDate.of(2023, 7, 1), LocalDate.of(2023, 8, 15), "Moodle");
    CursoPresencial curso2 = new CursoPresencial(2, "Introducción a la Fotografía", "Descubre el mundo de la fotografía", 20,
            LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), "Aula 101");
    CursoPresencial curso3 = new CursoPresencial(3, "Diseño Gráfico Avanzado", "Aprende a utilizar herramientas de diseño", 30,
            LocalDate.of(2023, 9, 1), LocalDate.of(2023, 10, 15), "Aula 202");
    CursoDistancia curso4 = new CursoDistancia(4, "Inglés Intermedio", "Mejora tus habilidades en el idioma inglés", 50,
            LocalDate.of(2023, 7, 1), LocalDate.of(2023, 9, 30), "Plataforma Online");
    CursoPresencial curso5 = new CursoPresencial(5, "Marketing Digital", "Estrategias de marketing en el entorno digital", 25,
            LocalDate.of(2023, 9, 15), LocalDate.of(2023, 10, 31), "Aula 303");
    CursoDistancia curso6 = new CursoDistancia(6, "Programación Web", "Desarrollo de aplicaciones web", 60,
            LocalDate.of(2023, 8, 15), LocalDate.of(2023, 10, 30), "Plataforma Online");

    // Matricular alumnos en los cursos
    curso1.matricularAlumno(alumno1);
    curso1.matricularAlumno(alumno2);
    curso1.matricularAlumno(alumno3);

    curso2.matricularAlumno(alumno4);
    curso2.matricularAlumno(alumno5);
    curso2.matricularAlumno(alumno6);
    curso2.matricularAlumno(alumno7);

    curso3.matricularAlumno(alumno8);
    curso3.matricularAlumno(alumno9);
    curso3.matricularAlumno(alumno10);

    curso4.matricularAlumno(alumno1);
    curso4.matricularAlumno(alumno2);
    curso4.matricularAlumno(alumno6);
    curso4.matricularAlumno(alumno8);
    curso4.matricularAlumno(alumno10);

    curso5.matricularAlumno(alumno1);
    curso5.matricularAlumno(alumno3);
    curso5.matricularAlumno(alumno5);
    curso5.matricularAlumno(alumno7);
    curso5.matricularAlumno(alumno9);

    curso6.matricularAlumno(alumno2);
    curso6.matricularAlumno(alumno4);
    curso6.matricularAlumno(alumno6);
    curso6.matricularAlumno(alumno8);
    curso6.matricularAlumno(alumno10);

    // Listar alumnos matriculados en los cursos
    curso1.listarAlumnos();
    curso2.listarAlumnos();
    curso3.listarAlumnos();
    curso4.listarAlumnos();
    curso5.listarAlumnos();
    curso6.listarAlumnos();
}





public static void main(String[] args) {
    List<Curso> cursos = new ArrayList<>();


    // Crear alumnos
    Alumno alumno1 = new Alumno(1, "Juan");
    Alumno alumno2 = new Alumno(2, "María");
    Alumno alumno3 = new Alumno(3, "Pedro");
    Alumno alumno4 = new Alumno(4, "Laura");
    Alumno alumno5 = new Alumno(5, "Carlos");
    Alumno alumno6 = new Alumno(6, "Ana");
    Alumno alumno7 = new Alumno(7, "Pablo");
    Alumno alumno8 = new Alumno(8, "Sofía");
    Alumno alumno9 = new Alumno(9, "Marta");
    Alumno alumno10 = new Alumno(10, "Alejandro");
    
        // Crear cursos
        CursoDistancia curso1 = new CursoDistancia(1, "Programación en Java", "Aprende a programar en Java", 40,
                LocalDate.of(2023, 7, 1), LocalDate.of(2023, 8, 15), "Moodle");
        CursoPresencial curso2 = new CursoPresencial(2, "Introducción a la Fotografía", "Descubre el mundo de la fotografía", 20,
                LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), "Aula 101");
        CursoPresencial curso3 = new CursoPresencial(3, "Diseño Gráfico Avanzado", "Aprende a utilizar herramientas de diseño", 30,
                LocalDate.of(2023, 9, 1), LocalDate.of(2023, 10, 15), "Aula 202");
        CursoDistancia curso4 = new CursoDistancia(4, "Inglés Intermedio", "Mejora tus habilidades en el idioma inglés", 50,
                LocalDate.of(2023, 7, 1), LocalDate.of(2023, 9, 30), "Plataforma Online");
        CursoPresencial curso5 = new CursoPresencial(5, "Marketing Digital", "Estrategias de marketing en el entorno digital", 25,
                LocalDate.of(2023, 9, 15), LocalDate.of(2023, 10, 31), "Aula 303");
        CursoDistancia curso6 = new CursoDistancia(6, "Programación Web", "Desarrollo de aplicaciones web", 60,
                LocalDate.of(2023, 8, 15), LocalDate.of(2023, 10, 30), "Plataforma Online");
    
        // Matricular alumnos en los cursos
        curso1.matricularAlumno(alumno1);
        curso1.matricularAlumno(alumno2);
        curso1.matricularAlumno(alumno3);
    
        curso2.matricularAlumno(alumno4);
        curso2.matricularAlumno(alumno5);
        curso2.matricularAlumno(alumno6);
        curso2.matricularAlumno(alumno7);
    
        curso3.matricularAlumno(alumno8);
        curso3.matricularAlumno(alumno9);
        curso3.matricularAlumno(alumno10);
    
        curso4.matricularAlumno(alumno1);
        curso4.matricularAlumno(alumno2);
        curso4.matricularAlumno(alumno6);
        curso4.matricularAlumno(alumno8);
        curso4.matricularAlumno(alumno10);
    
        curso5.matricularAlumno(alumno1);
        curso5.matricularAlumno(alumno3);
        curso5.matricularAlumno(alumno5);
        curso5.matricularAlumno(alumno7);
        curso5.matricularAlumno(alumno9);
    
        curso6.matricularAlumno(alumno2);
        curso6.matricularAlumno(alumno4);
        curso6.matricularAlumno(alumno6);
        curso6.matricularAlumno(alumno8);
        curso6.matricularAlumno(alumno10);
    
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);
        cursos.add(curso6);

        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n----- MENÚ DE OPCIONES -----");
            System.out.println("1. Próximos cursos");
            System.out.println("2. Cursos por Alumnado");
            System.out.println("3. Cursos Finalizados");
            System.out.println("4. Detalle de cursos");
            System.out.println("0. SALIR");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    mostrarProximosCursos(cursos);
                    break;
                case 2:
                    mostrarCursosPorAlumnado(cursos);
                    break;
                case 3:
                    mostrarCursosFinalizados(cursos);
                    break;
                case 4:
                    mostrarDetalleCursos(cursos);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);
        
        scanner.close();
    }
    
    public static void mostrarProximosCursos(List<Curso> cursos) {
        List<Curso> cursosNoIniciados = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now();
        
        for (Curso curso : cursos) {
            if (curso.getFechaInicio().isAfter(fechaActual)) {
                cursosNoIniciados.add(curso);
            }
        }
        
        Collections.sort(cursosNoIniciados, Comparator.comparing(Curso::getFechaInicio));
        
        System.out.println("\n----- PRÓXIMOS CURSOS -----");
        for (Curso curso : cursosNoIniciados) {
            System.out.println("ID: " + curso.getId() + " - Título: " + curso.getNombre() + " - Fecha de inicio: " + curso.getFechaInicio());
        }
    }
    
    public static void mostrarCursosPorAlumnado(List<Curso> cursos) {
        List<Curso> cursosOrdenados = new ArrayList<>(cursos);
        
        Collections.sort(cursosOrdenados, Comparator.comparing(Curso::numAlumnosMatriculados).reversed());
        
        System.out.println("\n----- CURSOS POR ALUMNADO -----");
        for (Curso curso : cursosOrdenados) {
            System.out.println("ID: " + curso.getId() + " - Título: " + curso.getNombre());
            System.out.println("Cantidad de Alumnado: " + curso.numAlumnosMatriculados());
        }
    }

    public static void mostrarCursosFinalizados(List<Curso> cursos) {
        LocalDate fechaActual = LocalDate.now();
        List<Curso> cursosFinalizados = new ArrayList<>();

        for (Curso curso : cursos) {
            if (curso.getFechaFin().isBefore(fechaActual)) {
                cursosFinalizados.add(curso);
            }
        }

        System.out.println("\n----- CURSOS FINALIZADOS -----");
        for (Curso curso : cursosFinalizados) {
            System.out.println("ID: " + curso.getId() + " - Título: " + curso.getNombre());
        }
    }

    public static void mostrarDetalleCursos(List<Curso> cursos) {
        System.out.println("\n----- DETALLE DE CURSOS -----");
        for (Curso curso : cursos) {
            curso.listarAlumnos();
        }
    }

}

class Alumno {
    private int id;
    private String nombre;

    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}

class CursoDistancia extends Curso {
    private String plataforma;

    public CursoDistancia(int id, String nombre, String descripcion, int duracion, LocalDate fechaInicio, LocalDate fechaFin, String plataforma) {
        super(id, nombre, descripcion, duracion, fechaInicio, fechaFin);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}

class CursoPresencial extends Curso {
    private String aula;

    public CursoPresencial(int id, String nombre, String descripcion, int duracion, LocalDate fechaInicio, LocalDate fechaFin, String aula) {
        super(id, nombre,descripcion, duracion, fechaInicio, fechaFin);
this.aula = aula;
}

public String getAula() {
    return aula;
}

public void setAula(String aula) {
    this.aula = aula;
}

}




