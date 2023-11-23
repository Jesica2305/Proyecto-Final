package presentacion;

import logicaNegocio.Juego;
import logicaNegocio.Tablero;

public class Principal {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(7);
        Juego juego = new Juego(tablero);

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(juego);
        ventanaPrincipal.inicializarVentana();
    }
}




