package presentacion;

import logicaNegocio.Juego;
import logicaNegocio.Tablero;
/**
*Clase Pricipal 
*/
public class Principal {
    /**
    *Creacion de la ventana principal del juego 
    *Primer método en ser ejecutado
    *@param args Argumentos que recibe por consola
    *Complejidad temporal:O(1) complejidad constante
    */
    public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(new Juego(new Tablero(7)));

        //Inicializacion de la ventana principal
        ventanaPrincipal.inicializarVentana();
    }
}



