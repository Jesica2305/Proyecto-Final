package logicaNegocio;

public class Juego {
    private Tablero tablero;

    public Juego(Tablero tablero) {
        this.tablero = tablero;
    }

    private int[] tiposBarcos = {0, 0, 1, 1, 2, 3}; // Tipos de barcos a colocar
    private int tamBarcos; // Tamaño del barco actual a colocar

    public int[] getTiposBarcos() {
        return tiposBarcos;
    }

    public int getTamBarcos() {
        return tamBarcos;
    }

    public boolean colocarBarco(int fila, int columna, int i) {
        int tamBarcos = getTiposBarcos()[i];
        return tablero.adicionarBarco(fila, columna, tamBarcos);
    }

    public char realizarDisparo(int fila, int columna) {
        return tablero.realizarDisparo(fila, columna);
    }
}