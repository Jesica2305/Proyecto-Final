package presentacion;

import logicaNegocio.Jugador;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        jugador1.colocarBarcos(scanner, "Jugador 1");
        jugador2.colocarBarcos(scanner, "Jugador 2");

        while (!jugador1.haPerdido() && !jugador2.haPerdido()) {
            jugador1.disparar(scanner, jugador2, "jugador 1", 1);
            if (jugador2.haPerdido()) {
                System.out.println("¡" + jugador1.getNombre() + " ha ganado!");
                break;
            }

            jugador2.disparar(scanner, jugador1, "jugador 2",2);
            if (jugador1.haPerdido()) {
                System.out.println("¡" + jugador2.getNombre() + " ha ganado!");
                break;
            }
        }

        System.out.println("Fin del juego.");
    }
}
