package logicaNegocio;

import presentacion.VentanaPrincipal;

public class Juego {
    private int contadorBarcos;
    private Tablero tablero;
   public Juego (Tablero tablero){
       this.tablero = tablero;
   }

    /*
       Creamos un array de mensajes
       */
    private String[] mensajes = {
            "Ingrese la coordenada del barco %d (fila columna) tenga en cuenta que el barco ocupa 1 casilla",
            "Ingrese la coordenada del barco %d (fila columna) tenga en cuenta que el barco ocupa 1 casilla",
            "Ingrese la coordenada del barco %d (fila columna) tenga en cuenta que el barco ocupa 2 casillas verticalmente",
            "Ingrese la coordenada del barco %d (fila columna) tenga en cuenta que el barco ocupa 2 casillas verticalmente",
            "Ingrese la coordenada del barco %d (fila columna) tenga en cuenta que el barco ocupa 3 casillas horizontalmente",
            "Ingrese la coordenada del barco %d (fila columna) tenga en cuenta que el barco ocupa 4 casillas horizontalmente"
    };
    /*
    Creamos un arreglo de tipoBarcos para que el switch evalue cada caso
     */
    private int[] tiposBarcos = {0, 0, 1, 1, 2, 3};

    private int tamBarcos;

    public int[] getTiposBarcos() {
        return tiposBarcos;
    }

    public int getTamBarcos() {
        return tamBarcos;
    }

    public boolean colocarBarco (int filaUsuario, int columnaUsuario) {
        if (tablero != null) {
            boolean posicionValida = false;
        /*
       Creamos un ciclo for para hacer un recorrido de tipo barcos
        */
            for (int i = 0; i < getTamBarcos(); i++) {

                tamBarcos = getTiposBarcos()[i];
            /*
            y dentro del ciclo for creamos un ciclo do-while donde le va a mostar
            al usuario el mensaje para que ingrese la coordenada del barco y después le
            a pintar la matriz con el barco, pero si posicion valida esta fuera de la matriz
            nos va a retornar un falso, y se va arepetir hasta que posicion valida sea verdadero.**/
                System.out.print(String.format(mensajes[i], i + 1));
                System.out.println("Barco ubicado en la coordenada (" + filaUsuario + "," + columnaUsuario + ")");
                posicionValida = tablero.adicionarBarco(filaUsuario, columnaUsuario, tamBarcos);
                return posicionValida;
            }
        } else {
            System.out.println("El tablero no ha sido inicializado correctamente");
            return false;
        }
        return false;
    }

    public void disparos (int filaUsuario, int columnaUsuario){
        int barcosRestantes = 13; // Inicialmente hay 6 barcos
        boolean disparoAcertado;

            /*
            se crea el siguiente bucle para que el juego continue si los barcos restantes son mayores a 0.
            complejidad temporal: O(N) Tiempo Lineal.
            */
            while (barcosRestantes > 0) {
                    System.out.print("Ingrese una coordenada (fila columna): ");
                    System.out.println("Ha disparado en la coordenada ("+filaUsuario+","+columnaUsuario+")");
                /*
                se verifica si le disparo a un barco.
                */
                    disparoAcertado = tablero.disparos(filaUsuario, columnaUsuario);
                /*
                si le dispara a un barco se decrementan los barcosRestantes
                */
                if (disparoAcertado==true) {
                    barcosRestantes--;

                    if (barcosRestantes == 0) {
                        System.out.println("¡Has hundido todos los barcos!");
                        break;
                    }
                }
            }
            /*
            El juego se termina si no queda ningun barco en la matriz
            */
                    System.out.println("Fin del juego.");
        }
}


