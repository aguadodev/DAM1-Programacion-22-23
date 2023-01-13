public class Validaciones {
    public static void main(String[] args) {
        System.out.println(esValidoDNI("23456346F"));
        System.out.println(esValidoDNI("22726985H"));                
        System.out.println(esValidoDNI("22726985H"));                
    }
    
    static boolean esValidoDNI(String dni) {        
        String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(dni.substring(0,8));

        char letra = dni.charAt(8);

        boolean dniOk = letrasDni.charAt(numero % 23) == letra;
    
        return dniOk;
    }

    static boolean esMatriculaValida(String matricula){
        return true;
    }

    static String siguienteMatricula(String matricula){
        return "";
    }

}
