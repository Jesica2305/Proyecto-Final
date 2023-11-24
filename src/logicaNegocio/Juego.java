package logicaNegocio;

public class Juego {
    // Tablero donde se lleva a cabo el juego
    private Tablero tablero; 

    //Constructor que inicializa el juego con un tablero especifico 
    public Juego(Tablero tablero) {
        this.tablero = tablero;
    }

    //Metodo para obtener el tablero actual del juego 
    public Tablero getTablero() {
        return tablero;
    }

    // Array que representa los tipos de barcos disponibles para colocar
    private int[] tiposBarcos = {0,  0,  1,1,  1,1, 2,2,2, 3,3,3,3}; // Tipos de barcos a colocar


    // Metodo para obtner los tipos de barcos disponibles 
    public int[] getTiposBarcos() {
        return tiposBarcos;
    }

    //Metodo para colocar un barco en una posicion especifica del tablero 
    public int colocarBarco(int fila, int columna, int i) {
        int tamBarcos = getTiposBarcos()[i];
        return tablero.adicionarBarco(fila, columna, tamBarcos);
    }


    //Metodo para realizar un disparo en una posicion especifica del tablero 
    public char realizarDisparo(int fila, int columna) {
        return tablero.realizarDisparo(fila, columna);
    }
}
