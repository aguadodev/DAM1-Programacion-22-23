import java.util.Arrays;

// DANIEL TOURIÑO PIÑEIRO
public class App {
    public static void main(String[] args) throws Exception {
        String[] mapa = {
            "  X       ",
            " *        ",
            "  *  *    ",
            "          ",
            " S        "
        };

        
        System.out.println("CAMINO EENNNNO es: " + caminoValido(mapa, "EENNNNO"));
        System.out.println("CAMINO ENENENENOOO es: " + caminoValido(mapa, "ENENENENOOO"));
        System.out.println("CAMINO EEEEEEEENOOOOOONNEENOOO es: " + caminoValido(mapa, "EEEEEEEENOOOOOONNEENOOO"));       
    }

    static int rango(int t[]) {
        int diferencia = 0;

        if(t != null && t.length >= 2) {
            int mayor = 0, menor = 0;
            boolean inicializados = false;
            
            for (int e : t) {
                if(!inicializados) {
                    mayor = e;
                    menor = e;

                    inicializados = true;
                } else {
                    if(e > mayor) mayor = e;
                    if(e < menor) menor = e;
                }
            }

            diferencia = mayor - menor;
        }

        return diferencia;
    }

    static boolean cambiarColor(int[][] img, int colorViejo, int colorNuevo) {
        boolean colorCambiado = false;

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                if(img[i][j] == colorViejo) {
                    img[i][j] = colorNuevo;
                    colorCambiado = true;
                }
            }
        }

        return colorCambiado;
    }

    static boolean caminoValido(String[] mapa, String camino) {
        boolean caminoValido = false;
        boolean minaEncontrada = false;
        boolean fueraRango = false;

        int[][] posicionPrincipal = new int[1][2];
        int[][] posicionaFinalEsperada = new int[1][2];

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length(); j++) {
                if(mapa[i].charAt(j) == 'S') {
                    posicionPrincipal[0][0] = i;
                    posicionPrincipal[0][1] = j;                    
                }

                if(mapa[i].charAt(j) == 'X') {
                    posicionaFinalEsperada[0][0] = i;
                    posicionaFinalEsperada[0][1] = j;
                }
            }
        }

        for (int i = 0; i < camino.length(); i++) {
            if(camino.charAt(i) == 'N') {
                if((posicionPrincipal[0][0] - 1 >= mapa.length) || (posicionPrincipal[0][0] - 1) < 0) {
                    fueraRango = true;
                } else {
                    if(mapa[posicionPrincipal[0][0] - 1].charAt(posicionPrincipal[0][1]) != '*'){
                        mapa[posicionPrincipal[0][0]] = mapa[posicionPrincipal[0][0]].replaceAll("S", " ");

                        String tempMap = "";
                        for (int j = 0; j < mapa[posicionPrincipal[0][0] - 1].length(); j++) {
                            if(j != posicionPrincipal[0][1]) {
                                tempMap += mapa[posicionPrincipal[0][0] - 1].charAt(j);
                            } else {
                                tempMap += 'S';
                            }
                        }

                        mapa[posicionPrincipal[0][0] - 1] = tempMap;
                        posicionPrincipal[0][0] = posicionPrincipal[0][0] - 1;
                    } else {
                        System.out.println("Has encontrado una mina");
                        minaEncontrada = true;
                        break;
                    }
                }
            }

            if(camino.charAt(i) == 'S') {
                if((posicionPrincipal[0][0] + 1 >= mapa.length) || (posicionPrincipal[0][0] + 1) < 0) {
                    fueraRango = true;
                } else {
                    if(mapa[posicionPrincipal[0][0] + 1].charAt(posicionPrincipal[0][1]) != '*'){
                        mapa[posicionPrincipal[0][0]] = mapa[posicionPrincipal[0][0]].replaceAll("S", " ");
    
                        String tempMap = "";
                        for (int j = 0; j < mapa[posicionPrincipal[0][0] + 1].length(); j++) {
                            if(j != posicionPrincipal[0][1]) {
                                tempMap += mapa[posicionPrincipal[0][0] + 1].charAt(j);
                            } else {
                                tempMap += 'S';
                            }
                        }
    
                        mapa[posicionPrincipal[0][0] + 1] = tempMap;
                        posicionPrincipal[0][0] = posicionPrincipal[0][0] + 1;
                    } else {
                        System.out.println("Has encontrado una mina");
                        minaEncontrada = true;
                        break;
                    }
                }
            }

            if(camino.charAt(i) == 'E') {
                if(posicionPrincipal[0][1] + 1 >= mapa[posicionPrincipal[0][0]].length()) {
                    fueraRango = true;
                } else {
                    if(mapa[posicionPrincipal[0][0]].charAt(posicionPrincipal[0][1] + 1) != '*'){
                        mapa[posicionPrincipal[0][0]] = mapa[posicionPrincipal[0][0]].replaceAll("S", " ");
    
                        String tempMap = "";
                        for (int j = 0; j < mapa[posicionPrincipal[0][0]].length(); j++) {
                            if(j != posicionPrincipal[0][1] + 1) {
                                tempMap += mapa[posicionPrincipal[0][0]].charAt(j);
                            } else {
                                tempMap += 'S';
                            }
                        }
    
                        mapa[posicionPrincipal[0][0]] = tempMap;
                        posicionPrincipal[0][1] = posicionPrincipal[0][1] + 1;
                    } else {
                        System.out.println("Has encontrado una mina");
                        minaEncontrada = true;
                        break;
                    }
                }
            }

            if(camino.charAt(i) == 'O') {
                if(posicionPrincipal[0][1] - 1 < 0) {
                    fueraRango = true;
                } else {
                    if(mapa[posicionPrincipal[0][0]].charAt(posicionPrincipal[0][1] - 1) != '*'){
                        mapa[posicionPrincipal[0][0]] = mapa[posicionPrincipal[0][0]].replace("S", " ");
    
                        String tempMap = "";
                        for (int j = 0; j < mapa[posicionPrincipal[0][0]].length(); j++) {
                            if(j != posicionPrincipal[0][1] - 1) {
                                tempMap += mapa[posicionPrincipal[0][0]].charAt(j);
                            } else {
                                tempMap += 'S';
                            }
                        }
    
                        mapa[posicionPrincipal[0][0]] = tempMap;
                        posicionPrincipal[0][1] = posicionPrincipal[0][1] - 1;
                    } else {
                        System.out.println("Has encontrado una mina");
                        minaEncontrada = true;
                        break;
                    }
                }
            }
        }

        if(!minaEncontrada && !fueraRango) {
            int[][] posicionFinalJugador = new int[1][2];

            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length(); j++) {
                    if(mapa[i].charAt(j) == 'S') {
                        posicionFinalJugador[0][0] = i;
                        posicionFinalJugador[0][1] = j;
                        
                        break;
                    }
                }
            }

            if((posicionFinalJugador[0][0] == posicionaFinalEsperada[0][0]) && (posicionFinalJugador[0][1] == posicionaFinalEsperada[0][1]))
                caminoValido = true;
        }

        return caminoValido;
    }
}