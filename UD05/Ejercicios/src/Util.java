public class Util {
    
    static boolean esNumero(Object ob){
        String clase = ob.getClass().getSimpleName();

        return 
        clase.equals("Byte") ||
        clase.equals("Short") ||
        clase.equals("Integer") ||
        clase.equals("Long") ||
        clase.equals("Float") ||
        clase.equals("Double");
    }

    static boolean sumar(Object a, Object b){
        boolean res = false;

        // Para obtener/comparar la clase de un objeto podemos usar 
        //   - getClass().getSimpleName()
        //   - instance of

        if (a.getClass().getSimpleName().equals("String") && 
            b instanceof String){
            // Imprimir concatenación
   
            System.out.println((String) a + (String) b);
            res = true;
        } else if (esNumero(a) && esNumero(b)){
            // Convertir a Double e imprimir suma
            // Podríamos usar también la clase intermedia Number.
            String stra = a.toString();
            String strb = b.toString();

            System.out.println(Double.valueOf(stra) + Double.valueOf(strb));
            res = true;

        } else {
            System.out.println("No Sumables");
            res = false;
        }
        return res;
    }

    public static void main(String[] args) {
        sumar (3, 4.5);       
        sumar ("Hola y ", "adiós");
       sumar (3.5, 4.5);

       sumar (2, 15);
       sumar ('a', 5);

    }

}
