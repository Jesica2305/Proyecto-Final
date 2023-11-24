package logicaNegocio;

/**
 * Clase Juego
 */
public class Juego {
    /**
     * Atributo el cual representa el tablero donde se colocaran los barcos
     */
    private Tablero tablero;

    public Juego(Tablero tablero) {
        this.tablero = tablero;
    }

    private int[] tiposBarcos = {0, 0, 1, 1, 2, 3}; // Tipos de barcos a colocar
    private int tamBarcos; // Tamaño del barco actual a colocar

    /**
     * Método que devuelve los tamaños de los barcos disponibles
     * @return tiposBarcos
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
    public int[] getTiposBarcos() {
        return tiposBarcos;
    }

    /**
     * Almacena el tamaño del barco actual a colocar
     * @return tamBarcos
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
    public int getTamBarcos() {
        return tamBarcos;
    }

    /**
     * Intenta colocar un barco en la posición dada del tablero
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     * @param i índice del tipo de barco
     */
    public boolean colocarBarco(int fila, int columna,int i) {
        boolean posicionValida = false;

            tamBarcos = getTiposBarcos()[i];


            posicionValida = tablero.adicionarBarco(fila, columna, tamBarcos);


            if (posicionValida) {
                return true;
            } else {
             System.out.println("No se pudo colocar el barco en esta posición.");
            return false;
    }
    }

    /**
     * realiza un disparo en la coordenada indicada
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     * @return tablero.realizarDisparos
     */
    public char realizarDisparo(int fila, int columna) {
        return tablero.realizarDisparo(fila, columna);
    }
}

