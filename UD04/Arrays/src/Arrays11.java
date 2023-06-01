import java.util.Scanner;
/*
 * Escribe un programa en Java que implemente un juego de tres en raya. 
 * El programa debe permitir a dos jugadores jugar al juego turnándose para colocar fichas en un tablero de 3x3. 
 * El juego termina cuando un jugador consigue tres fichas en raya (horizontal, vertical o diagonal)
 */
public class Arrays11 {
    final static int TAM = 3; // Tamaño de Tablero
    static char[][] tablero = new char[TAM][TAM];

    public static void main(String[] args) {
        inicializarTablero();
        int turnos = 9;
        char turno = 'X'; // 'O'
        char ganador = ' ';
        mostrarTablero();
        while (turnos > 0 && ganador == ' '){
            leerMovimiento(turno);
            if (victoria(turno))
                ganador = turno;  
            mostrarTablero();
            turno = turno == 'X'? 'O':'X';
        }
        
        if (turnos == 0)
            System.out.println("TABLAS");
        else
            System.out.println("GANADOR: " + ganador);
    }   

    static void leerMovimiento(char turno){
        // TODO: comprobar que la entrada es correcta:
        // - Rangos, caracteres válidos, casilla no ocupada
        Scanner sc = new Scanner(System.in);
        int f, c;
        do {
            System.out.println("Coloca una casilla (" + turno + ") en el tablero: ");
            System.out.print("Fila: ");
            f = sc.nextInt();
            System.out.print("Columna: ");
            c = sc.nextInt();  

        } while (f < 0 || f >= TAM || c < 0 || c >= TAM);


        tablero[f][c] = turno;
    }    

    static boolean victoria(char turno){
        boolean f = false; // victoria por filas
        for(int i = 0; i < TAM; i++){
            int num = 0; 
            for(int j = 0; j < TAM; j++){
                if(tablero[i][j] == turno)
                    num++;
            }
            if(num == TAM) 
                f = true;
        }  

        boolean c = false; // victoria por columnas
        for(int i = 0; i < TAM; i++){
            int num = 0; 
            for(int j = 0; j < TAM; j++){
                if(tablero[j][i] == turno)
                    num++;
            }
            if(num == TAM) 
                c = true;
        }  

        boolean d = true; // diagonal
        boolean di = true; // diagonal inversa
        for(int i = 0; i < TAM; i++){            
            if(tablero[i][i] != turno)
                d = false;
            if(tablero[i][TAM - 1 - i] != turno)
                di = false;                                       
        }

        return f || c || d || di;
    }

    static void mostrarTablero(){
        for(int i = 0; i < TAM; i++){
            for(int j = 0; j < TAM; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void inicializarTablero(){
        for(int i = 0; i < TAM; i++)
            for(int j = 0; j < TAM; j++)
                tablero[i][j] = '-';

    }

}
