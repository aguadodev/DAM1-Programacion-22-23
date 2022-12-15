public class Paraninfo516 {
    public static void main(String[] args) {
        /*
         * PENDIENTE DE RESOLVER CUANDO DOS CASILLAS ESTÁN COMUNICADAS ENTRE SÍ 
         * Y SE GENERA UN BUCLE EN LA PILA DE LLMADAS RECURSIVAS 
         */
        int mapa[][] = {
            {0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
        };

        int mapa2[][] = {
        //   0  1  2  3  4  5
            {0, 1, 1, 0, 0, 0}, //0
            {0, 0, 0, 1, 0, 0}, //1
            {0, 0, 0, 0, 1, 0}, //2
            {0, 1, 0, 0, 0, 0}, //3
            {0, 0, 0, 0, 0, 1}, //4
            {0, 0, 0, 0, 0, 0}, //5
        };        

        System.out.println(hayCamino(mapa2, 0, 5));
    }
    
    static boolean hayCaminoDirecto(int[][] t, int o, int d){          
        return t[o][d] == 1;
    }

    static boolean hayCamino(int[][] t, int o, int d){
        boolean hayCamino = false;

        if (hayCaminoDirecto(t, o, d))
            hayCamino = true;
        else {
            for(int i = 0; i < t.length; i++){
                if(hayCaminoDirecto(t, o, i))
                    hayCamino = hayCamino(t, i, d);
            }
        }               

        return hayCamino;
    }

}
