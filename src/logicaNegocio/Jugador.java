package logicaNegocio;

import java.util.Scanner;

    public class Jugador {
        private String nombre;
        private Tablero tablero;

        public Jugador(String nombre) {
            this.nombre = nombre;
            this.tablero = new Tablero(7);
        }

        public String getNombre() {
            return nombre;
        }

        public void colocarBarcos(Scanner scanner, String nombre) {
            System.out.println("Turno del " + nombre);
            int filaUsuario;
            int columnaUsuario;
            boolean posicionValida;

            for (int i = 0; i < 6; i++) {
                int tipoBarco = i / 2;
                do {
                    System.out.print(String.format("Ingrese la coordenada del barco %d (fila columna): ", i + 1));
                    filaUsuario = scanner.nextInt();
                    columnaUsuario = scanner.nextInt();
                    posicionValida = tablero.adicionarBarco(filaUsuario, columnaUsuario, tipoBarco);
                    tablero.imprimirMatriz();
                } while (!posicionValida);
            }
        }

        public void disparar(Scanner scanner, Jugador oponente, String nombre, int jugador) {
            System.out.println("disparo " + nombre);
            int filaUsuario;
            int columnaUsuario;
            boolean disparoAcertado;
            switch (jugador) {
                case 1:
                    System.out.print("Ingrese una coordenada para disparar (fila columna): ");
                    filaUsuario = scanner.nextInt();
                    columnaUsuario = scanner.nextInt();
                    disparoAcertado = oponente.tablero.disparos(filaUsuario, columnaUsuario);
                    oponente.tablero.imprimirMatriz();
                    break;

                case 2:
                    System.out.print("Ingrese una coordenada para disparar (fila columna): ");
                    filaUsuario = scanner.nextInt();
                    columnaUsuario = scanner.nextInt();
                    oponente.tablero.disparos(filaUsuario, columnaUsuario);
                    oponente.tablero.imprimirMatriz();
                    break;
            }
        }
        public boolean haPerdido() {
            return tablero.todosBarcosDestruidos();
        }
    }
