public class HerenciaEjemplos {
    public static void main(String[] args) {
        Persona p;
        Empleado e;
        Object o1, o2;

        p = new Persona("Marta");

        e = new Empleado("Pepe", "López", 30000);

        e.setTelefono("666666666");

        Persona[] gente = new Persona[5];

        gente[0] = p;
        gente[1] = e;
        gente[2] = new Estudiante("Leire", 7, 8, 6);
        gente[3] = new Estudiante("Leire", 7, 8, 6);

        
        for(int i = 0; i < gente.length; i++){
            if (gente[i] != null)
                System.out.print(gente[i].getClass().getName() + " : ");
            System.out.println(gente[i]); 

        }


        System.out.println(gente[2] == gente[3]);
        System.out.println(gente[2].equals(gente[3]));

        /*
        Estudiante est = (Estudiante) gente[2];
        System.out.println(est.notaMedia());*/
        
    }
}
