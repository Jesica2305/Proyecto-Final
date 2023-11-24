package presentacion;

import logicaNegocio.Juego;
import logicaNegocio.Tablero;

public class Principal {
    // Creacion de la ventana principal del juego 
    public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(new Juego(new Tablero(7)));

        //Inicializacion de la ventana principal
        ventanaPrincipal.inicializarVentana();
    }
}



