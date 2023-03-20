import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Actividad1215 {
    public static void main(String[] args) {
        Map<String, Integer> productos = new TreeMap<>();
        String producto;
        Integer unidades;

        productos.put("Neumáticos", 20);
        productos.put("Frenos", 5);
        productos.put("Suspensión", 12);

        int opcion = leerMenu();
        while (opcion != 0){
            switch (opcion){
                case 1:
                    producto = leerProducto();
                    if (productos.containsKey(producto))
                        System.out.println("El producto ya existe, no se puede crear");
                    else {
                        unidades = leerUnidades();
                        productos.put(producto,unidades);
                    }
                    break;
                case 2:
                    producto = leerProducto();
                    productos.remove(producto);
                    break;
                case 3:
                    producto = leerProducto();
                    if (productos.containsKey(producto)){
                        unidades = leerUnidades();
                        productos.put(producto,unidades);                         
                    } else
                        System.out.println("El producto no existe");                                
                    break;
                case 4:
                    System.out.println(productos);
                    break;
            }
            opcion = leerMenu();
        }
    }




    private static Integer leerUnidades() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce las unidades: ");        
        return Integer.valueOf(sc.nextLine());
    }

    private static String leerProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el producto: ");        
        return sc.nextLine();
    }




    static int leerMenu(){
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Menú");
        System.out.println("1. Alta");
        System.out.println("2. Baja");
        System.out.println("3. Actualiza existencias");
        System.out.println("4. Listar productos");
        System.out.println("0. SALIR");
        opcion = sc.nextInt();
        return opcion;
    }
}
