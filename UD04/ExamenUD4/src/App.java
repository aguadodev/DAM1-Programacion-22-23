public class App {


    static int rango(int t[]){       
        if (t == null || t.length < 1)
            return 0;
        else {
            int min = t[0], max = t[0];

            for(int i = 1; i < t.length; i++){
                if (t[i] > max)
                    max = t[i];
                    
                if (t[i] < min)
                    min = t[i];
            }
            return max - min;            
        }
    }


    static boolean cambiarColor(int[][] img, int colorViejo, int colorNuevo){
        boolean hayCambio = false;

        for(int i = 0; i < img.length; i++)
            for(int j = 0; j < img[0].length; j++)
                if (img[i][j] == colorViejo){
                    img[i][j] = colorNuevo;
                    hayCambio = true;
                }

        return hayCambio;
    }



    static boolean caminoValido(String[] mapa, String camino){
        boolean caminoOk = true;

        int x, y;
        int i = 0;
        while(mapa[i].indexOf('S') == -1 && i < mapa.length){
            i++;
        }

        x = mapa[i].indexOf('S');
        y = i;

        i = 0;
        while (caminoOk && i < camino.length()){
            char mov = camino.charAt(i);
            switch (mov){
                case 'N': y--; break;
                case 'S': y++; break;
                case 'E': x++; break;
                case 'O': x--; break;
            }
            if (y < 0 || x < 0 || y >= mapa.length || x >= mapa[0].length() || mapa[y].charAt(x) == '*')
                caminoOk = false;
            i++;
        }

        if(caminoOk && mapa[y].charAt(x) != 'X'){
            caminoOk = false;
        }

        return caminoOk;
    }
}
