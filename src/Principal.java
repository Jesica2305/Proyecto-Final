import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero(7);
        Barco barco = new Barco(tablero);
        Juego juego = new Juego(tablero, barco);
        int filaUsuario;
        int columnaUsuario;
        /*
       Tenemos un boolean posicionValida
        */
        boolean posicionValida = true;
        /*
       Creamos un ciclo for para hacer un recorrido de tipo barcos
        */
        for (int i = 0; i < juego.getTamBarcos(); i++) {
            int tipoBarco = juego.getTiposBarcos()[i];
            /*
            y dentro del ciclo for creamos un ciclo do-while donde le va a mostar
            al usuario el mensaje para que ingrese la coordenada del barco y después le
            a pintar la matriz con el barco, pero si posicion valida esta fuera de la matriz
            nos va a retornar un falso, y se va arepetir hasta que posicion valida sea verdadero.
             */
            do {
                System.out.print(String.format(juego.getMensajes()[i], i + 1));
                filaUsuario = scanner.nextInt();
                columnaUsuario = scanner.nextInt();
                posicionValida = barco.adicionarBarco(filaUsuario, columnaUsuario, tipoBarco);
                tablero.imprimirMatriz();
            } while (false == posicionValida);
        }


         int barcosRestantes = 13; // Inicialmente hay 6 barcos
            boolean disparoAcertado = true;

        /*
        se crea el siguiente bucle para que el juego continue si los barcos restantes son mayores a 0.
        complejidad temporal: O(N) Tiempo Lineal.
        */
        while (barcosRestantes > 0) {
            System.out.print("Ingrese una coordenada (fila columna): ");
            filaUsuario = scanner.nextInt();
            columnaUsuario = scanner.nextInt();

            /*
            se verifica si le disparo a un barco.
            */
            disparoAcertado = tablero.disparos(filaUsuario, columnaUsuario);
            /*
            si le dispara a un barco se decrementan los barcosRestantes
            */
            if (disparoAcertado == true) {
                barcosRestantes--;

                if (barcosRestantes == 0) {
                    System.out.println("¡Has hundido todos los barcos!");
                    tablero.imprimirMatriz();
                    break;
                }
            }
            tablero.imprimirMatriz();
        }
        /*
        El juego se termina si no queda ningun barco en la matriz
        */
        System.out.println("Fin del juego.");
    }
}

