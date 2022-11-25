import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("\nFIGURAS");
        System.out.println("=======\n");
        
        imprimirMenu();

        int opcion, numAsteriscos;

        do {
            opcion = leerEntero();
        } while (opcion < 0 || opcion > 3);
        
        switch (opcion) {
            case 1: numAsteriscos = dibujarLinea(); break;
            case 2: numAsteriscos = dibujarRecuadro(); break;
            case 3: numAsteriscos = dibujarTriangulo(); break;                        
            default: numAsteriscos = 0;
        }

        System.out.println("Número de asteriscos utilizados = " + numAsteriscos);
        
        System.out.println("\nFIN DEL PROGRAMA");
    }

    static void imprimirMenu(){
        System.out.println("1. Línea");
        System.out.println("2. Recuadro");
        System.out.println("3. Triángulo");        
        System.out.println("0. SALIR \n");
        System.out.print("Elige una opción: ");
    }


    static int leerEntero() {
        int num = 0;
        boolean entradaOk = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                num = sc.nextInt();
                entradaOk = true;
            } catch (Exception e) {
                System.out.print("Por favor introduce un número entero: ");
            }    
        } while (!entradaOk);
        return num;
    }

    static int dibujarLinea() {
        int longitud;

        System.out.print("\nLongitud (1-80):");
        do {
            longitud = leerEntero();
        } while (longitud < 1 || longitud > 80);

        for(int i = 0; i < longitud; i++) {
            System.out.print("*");
        }
        System.out.println();
        return longitud;
    }

    static int dibujarTriangulo() {
        int alto, cont = 0;

        System.out.print("\nAltura del triángulo (1-20):");        
        do {
            alto = leerEntero();
        } while (alto < 1 || alto > 20);

        for(int i = 0; i < alto; i++) {
            for(int j = 0; j < alto - i - 1; j++)
                System.out.print(" ");
            for(int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
                cont++;                
            }

            System.out.println();                
        }

        System.out.println();
        return cont;
    }

    static int dibujarRecuadro() {
        int alto, ancho;

        System.out.print("\nAlto (1-20):");        
        do {
            alto = leerEntero();
        } while (alto < 1 || alto > 20);

        System.out.print("\nAncho (1-80):");
        do {
            ancho = leerEntero();
        } while (ancho < 1 || ancho > 80);

        for(int i = 0; i < alto; i++) {
            for(int j = 0; j < ancho; j++)
            System.out.print("*");
            System.out.println();
        }

        return alto * ancho;
    }    
}
