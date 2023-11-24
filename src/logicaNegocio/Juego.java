package logicaNegocio;

public class Juego {
    private Tablero tablero;

    public Juego(Tablero tablero) {
        this.tablero = tablero;
    }

    public Tablero getTablero() {
        return tablero;
    }

    private int[] tiposBarcos = {0,  0,  1,1,  1,1, 2,2,2, 3,3,3,3}; // Tipos de barcos a colocar

    public int[] getTiposBarcos() {
        return tiposBarcos;
    }

    public int colocarBarco(int fila, int columna, int i) {
        int tamBarcos = getTiposBarcos()[i];
        return tablero.adicionarBarco(fila, columna, tamBarcos);
    }


    public char realizarDisparo(int fila, int columna) {
        return tablero.realizarDisparo(fila, columna);
    }
}
