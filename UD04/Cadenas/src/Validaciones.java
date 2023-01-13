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

    static boolean esMatriculaValida2(String matricula){
        boolean matriculaOk = true;

        String letrasValidas = "BCDFGHJKLMNPQRSTVWXYZ";
        Character.isDigit(0);

        if (matricula.length() != 7)
            matriculaOk = false;
        else {
            int i = 0;
            while(i < 4 && matriculaOk){
                if (!Character.isDigit(matricula.charAt(i)))
                    matriculaOk = false;
                i++;
            }
            
            i = 4;
            while(i < 7 && matriculaOk){
                if (letrasValidas.indexOf(matricula.toUpperCase().charAt(i)) == -1)
                    matriculaOk = false;
                i++;
            }
        }
        return matriculaOk;
    }

    static boolean esMatriculaValida(String matricula){
        return matricula.toUpperCase().matches("\\d{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}");
    }


    static String siguienteMatricula(String matricula){
        return "";
    }

}
