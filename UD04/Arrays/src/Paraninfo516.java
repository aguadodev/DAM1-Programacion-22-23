public class Paraninfo516 {
    public static void main(String[] args) {
        int mapa[][] = {
            {0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
        };

        System.out.println(hayCamino(mapa, 2, 4));

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
                    return hayCamino(t, i, d);
            }
        }
               

        return hayCamino;
    }

}
