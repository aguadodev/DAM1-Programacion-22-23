import java.util.Scanner;

public class Arrays11 {
    
    static char[][] tablero = new char[3][3];

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
        System.out.print("Fila: ");
        int f = sc.nextInt();
        System.out.print("Columna: ");
        int c = sc.nextInt();

        tablero[f][c] = turno;
    }    

    static boolean victoria(char turno){
        boolean f = false; // victoria por filas
        for(int i = 0; i < 3; i++){
            int num = 0; 
            for(int j = 0; j < 3; j++){
                if(tablero[i][j] == turno)
                    num++;
            }
            if(num == 3) 
                f = true;
        }  

        boolean c = false; // victoria por columnas
        for(int i = 0; i < 3; i++){
            int num = 0; 
            for(int j = 0; j < 3; j++){
                if(tablero[j][i] == turno)
                    num++;
            }
            if(num == 3) 
                c = true;
        }  

        boolean d = true; // diagonal
        boolean di = true; // diagonal inversa
        for(int i = 0; i < 3; i++){            
            if(tablero[i][i] != turno)
                d = false;
            if(tablero[i][3 - 1 - i] != turno)
                di = false;                                       
        }

        return f || c || d || di;
    }

    static void mostrarTablero(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void inicializarTablero(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                tablero[i][j] = '-';

    }

}
