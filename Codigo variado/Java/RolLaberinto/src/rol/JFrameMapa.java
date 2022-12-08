package rol;

import entidad.Monstruo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class JFrameMapa extends JFrame {

    static final int FILAS = 10;
    static final int COLS = 20;

    /**
     * Matriz que representa el mapa base con los siguientes códigos: 0: Casilla
     * vacía 1: Muro 6: Casilla de salida 8: Fuente de curación 9: Casilla de
     * Llegada
     */
    static int[][] mapaTerreno = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {6, 0, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 1},
        {0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 9},
        {0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};

    // Mapa de monstruos: Cada casilla contiene un monstruo o el valor null
    static Monstruo[][] mapaMonstruos = new Monstruo[FILAS][COLS];

    // Posición del personaje inicializada a la salida. Podría obtenerse de mapaTerreno
    static int posCol = 0;
    static int posFila = 1;

    // Array de JLabel para pintar las casillas en el mapa
    static JLabel[][] mapa = new JLabel[FILAS][COLS];
    // Dimensiones de alto y ancho en píxeles de las casillas
    final int ALTO_CASILLA = 40;
    final int ANCHO_CASILLA = 40;

    public JFrameMapa() {
        super("Escapa del laberinto");
        setLayout(new GridLayout(FILAS, COLS, 1, 1));
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLS; j++) {
                mapa[i][j] = new JLabel("", JLabel.CENTER);
                mapa[i][j].setFont(new Font("Tahoma", Font.PLAIN, 10));
                mapa[i][j].setOpaque(true);

                pintarCasilla(i, j);

                // Pinta la casilla inicial de rojo
                if (posFila == i && posCol == j) {
                    mapa[i][j].setBackground(Color.RED);
                }

                add(mapa[i][j]);
            }
        }

        // Distribuye los monstruos del array por el mapa       
        colocaMonstruos();

        setSize(COLS * ANCHO_CASILLA, FILAS * ALTO_CASILLA);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
    }

    /**
     * Pinta la casilla (JLabel) en función del código de Terreno
     *
     * @param i
     * @param j
     */
    static private void pintarCasilla(int i, int j) {
        switch (mapaTerreno[i][j]) {
            case 0: // Espacio libre
                mapa[i][j].setBackground(Color.WHITE);
                break;
            case 1: // Muro
                mapa[i][j].setBackground(Color.BLACK);
                break;
            case 6: // Casilla de Salida
                mapa[i][j].setBackground(Color.PINK);
                break;
            case 8: // // Fuente de Curación
                mapa[i][j].setBackground(Color.CYAN);
                break;
            case 9: // Casille de Llegada
                mapa[i][j].setBackground(Color.GREEN);
                break;
        }
    }

    /**
     * Distribuye los monstruos por el tablero en casillas vacías
     */
    private void colocaMonstruos() {
        for (int i = 0; i < Juego.monstruos.length; i++) {
            int fila, col;
            do { // Genera una coordenada aleatoria mientras no encuentre una vacía
                // y que no contenga ya un monstruo.
                fila = random(FILAS);
                col = random(COLS);
            } while (mapaTerreno[fila][col] != 0 || mapaMonstruos[fila][col] != null);
            mapaMonstruos[fila][col] = Juego.monstruos[i];
        }
    }

    /**
     * Intenta mover el personaje a la casilla de destino indicada en los
     * parámetros
     *
     * @param fila
     * @param col
     */
    private void mover(int fila, int col) {
        // Si la casilla es un destino válido
        if (casillaDestinoValida(fila, col)) {
            // Si hay un monstruo en la casilla de destino
            if (mapaMonstruos[fila][col] != null) {
                combatir(fila, col);
            } else {
                actualizarPosicion(fila, col);
            }

            // Si la casilla de destino es una casilla especial
            switch (mapaTerreno[fila][col]) {
                case 8: // Fuente de Curación                    
                    Juego.pj.curar();           // El jugador recupera sus puntos de vida
                    mapaTerreno[fila][col] = 0; // La fuente desaparece
                    JOptionPane.showMessageDialog(this, "Bebes de la fuente y recuperas todos los puntos de vida!! ("
                            + Juego.pj.getPuntosVida() + ") \nPero la fuente desaparece... ",
                            "Te has curado!!", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 9: // Salida
                    JOptionPane.showMessageDialog(this, "Has conseguido salir del laberinto con un total de "
                            + Juego.pj.getExperiencia() + " puntos de experiencia!!! \n Enhorabuena!!!",
                            "Enhorabuena!!! (Fin del juego)", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    break;
            }
        }
    }

    
    static private boolean casillaDestinoValida(int fila, int col){
        // Comprueba que la casilla de destino no se sale del borde ni es un muro        
        return (fila >= 0 && col >= 0 && fila < FILAS && col < COLS )
                && mapaTerreno[fila][col] != 1;
    }
    
    
    /**
     * Gestiona el combate en la casilla indicada
     *
     * @param fila
     * @param col
     */
    private void combatir(int fila, int col) {
        Monstruo m = mapaMonstruos[fila][col];
        mapa[fila][col].setBackground(Color.orange);
        mapa[fila][col].setText(m.getNombre());
        JOptionPane.showMessageDialog(this, "Has encontrado un " + m, "Monstruo!!!", JOptionPane.WARNING_MESSAGE);

        // Inicia el Combate con una pantalla modal!!
        new JDialogCombate(fila, col);

        // Terminado el combate 
        if (!mapaMonstruos[fila][col].estaVivo()) {
            // 1. Si el jugador gana se mueve a la casilla de destino,
            // Elimina el monstruo del mapa
            mapaMonstruos[fila][col] = null;
            mapa[fila][col].setText("");

            actualizarPosicion(fila, col);

        } else if (!Juego.pj.estaVivo()) {
            // 2. Si el personaje muere se acaba el juego
            JOptionPane.showMessageDialog(this, "Has muerto!!!", "Fin del juego", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            // 3. Si consigue huir se queda en la casilla actual, no pasa nada
            //...
        }
    }

    
    /**
     * Actualiza la posición del jugador en el mapa
     *
     * @param fila
     * @param col
     */
    static public void actualizarPosicion(int fila, int col) {
        // Vuelve a pintar la casilla que deja el jugador del "color" que corresponda.
        pintarCasilla(posFila, posCol);
        // Actualiza la casilla actual del usuario y la "pinta" el color del jugador.
        posFila = fila;
        posCol = col;
        mapa[posFila][posCol].setBackground(Color.RED);
    }

    
    /**
     * Maneja el evento KeyPressed
     *
     * @param evt
     */
    private void formKeyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_W:
                mover(posFila - 1, posCol);
                break;
            case KeyEvent.VK_S:
                mover(posFila + 1, posCol);
                break;
            case KeyEvent.VK_A:
                mover(posFila, posCol - 1);
                break;
            case KeyEvent.VK_D:
                mover(posFila, posCol + 1);
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("espacio");
                break;
        }
    }

    // OTROS MÉTODOS
    private static int random(int n) {
        return (int) (Math.random() * n);
    }

}
