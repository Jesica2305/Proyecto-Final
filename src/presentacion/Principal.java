package presentacion;

import logicaNegocio.Juego;
import logicaNegocio.Tablero;

public class Principal {
    public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(new Juego(new Tablero(7)));
        ventanaPrincipal.inicializarVentana();
    }
}



