package presentacion;

import logicaNegocio.Juego;
import logicaNegocio.Tablero;

/**
 * Clase Principal
 */
public class Principal {
    /**
     * Primer método en ser ejecutado
     * @param args Argumentos que recibe por consola
     *
     * Complejidad Temporal: O(1) Complejidad Constante
     */
    public static void main(String[] args) {
        /**
         * Objeto de la clase Tablero con un tamaño de 7x7
         * Objeto de la clase Juego donde el tablero es argumento al constructor, es decir que el juego inicia con ese tablero
         */
        Tablero tablero = new Tablero(7);
        Juego juego = new Juego(tablero);

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(juego);
        ventanaPrincipal.inicializarVentana();
    }
}




