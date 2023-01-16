public class Validaciones {
    public static void main(String[] args) {
        siguienteMatricula("1234BbB");
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
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";
        boolean incrementar = true; // Si hay que incrementas un carácter
        char[] aux = matricula.toUpperCase().toCharArray(); // Resultado

        // PROCESA LOS NÚMEROS DE DERECHA A IZQUIERDA
        int i = 3;
        while (incrementar && i >= 0){
            if (aux[i] == '9'){
                // Da una vuelta y sigue habiendo que incrementar otro carácter
                aux[i] = '0';
            } else {
                aux[i] =  (char)(aux[i] + 1);
                incrementar = false; // No hay que incrementar más números de la matrícula
            }
            i--;
        }

        // PROCESA LAS LETRAS DE DERECHA A IZQUIERDA
        i = 6;
        while (incrementar && i >= 4){
            if (aux[i] == 'Z'){
                aux[i] = 'B';
            } else {
                aux[i] = letras.charAt(letras.indexOf(aux[i]) + 1);
                incrementar = false;
            }
            i--;
        }        
        
        return String.valueOf(aux);
    }
    static int comparaMatriculas(String m1, String m2){
        int res = m1.substring(4).compareToIgnoreCase(m2.substring(4));

        if (res == 0)
            res = m1.substring(0,4).compareTo(m2.substring(0,4));

        return res;
    }


    static int comparaMatriculas2(String m1, String m2){
        int res;
        int cl = m1.substring(4).compareToIgnoreCase(m2.substring(4));

        if (cl > 0){
            // m1 es más nueva
            res = 1;
        } else if (cl < 0) {
            // m1 es más vieja
            res = -1;
        } else {
            // Comparamos números 
            int cn = m1.substring(0,4).compareTo(m2.substring(0,4));   
            if (cn > 0){
                // m1 es más nueva
                res = 1;
                } else if (cn < 0) {
                    // m1 es más vieja
                    res = -1;
                } else {
                    // Son iguales
                    res = 0;
                }                            
        }

        return res;
    }

}
