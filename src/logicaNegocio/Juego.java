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

    public char realizarDisparo(int fila, int columna) {
        return tablero.realizarDisparo(fila, columna);
    }
}

