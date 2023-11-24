package logicaNegocio;

/**
 * Clase Tablero
 */
    public class Tablero {

        private char[][] matriz;
        private int TAMANO;

    /**
     * Constructor que inicializa la matriz del tablero con '*' en todas las posiciones
     * @param TAMANO tamaño del tablero
     *
     * Comlpejidad temporal: O(N^2) Complejidad Cuadrática
     */
    public Tablero(int TAMANO) {
            this.TAMANO = TAMANO;
            matriz = new char[TAMANO][TAMANO];
            inicializarMatriz();
        }

    /**
     * Retorna la matriz del tablero
     * @return matriz
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
        public char[][] getMatriz() {
            return matriz;
        }

    /**
     * Retorna el tamaño del tablero
     * @return TAMANO
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
        public int getTAMANO() {
            return TAMANO;
        }

    /**
     * Pinta la matriz con '*'
     *
     * Complejidad temporal: O(N^2) Complejidad Cuadrática
     */
        public void inicializarMatriz() {
            for (int i = 0; i < TAMANO; i++) {
                for (int j = 0; j < TAMANO; j++) {
                    matriz[i][j] = '*';
                }
            }
        }

    /**
     * Intenta colocar un braco especifico en la posición dada
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     * @param tipoBarco Tipo del barco
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
        public boolean adicionarBarco(int fila, int columna, int tipoBarco) {
            switch (tipoBarco) {
                case 0:
                    return colocarBarco1(fila, columna);
                case 1:
                    return colocarBarco2(fila, columna);
                case 2:
                    return colocarBarco3(fila, columna);
                case 3:
                    return colocarBarco4(fila, columna);
                default:
                    System.out.println("Barco inválido");
                    return false;
            }
        }

    /**
     * Se Ubica el barco 1 en posiciones especificas
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
        private boolean colocarBarco1(int fila, int columna) {
            if (matriz[fila][columna] != '*') {
                System.out.println("Casilla ocupada");
                return false;
            }

            char barco = 'D';
            matriz[fila][columna] = barco;
            return true;
        }

    /**
     * Se Ubica el barco 2 en posiciones especificas
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
        private boolean colocarBarco2(int fila, int columna) {
            if (fila > TAMANO - 2 || matriz[fila][columna] != '*' || matriz[fila + 1][columna] != '*') {
                System.out.println("Espacio insuficiente o casilla ocupada");
                return false;
            }

            char barco = 'A';
            matriz[fila][columna] = barco;
            matriz[fila + 1][columna] = barco;
            return true;
        }

    /**
     * Se Ubica el barco 3 en posiciones especificas
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
        private boolean colocarBarco3(int fila, int columna) {
            if (columna > TAMANO - 3 || matriz[fila][columna] != '*' || matriz[fila][columna + 1] != '*' || matriz[fila][columna + 2] != '*') {
                System.out.println("Espacio insuficiente o casilla ocupada");
                return false;
            }

            char barco = 'C';
            matriz[fila][columna] = barco;
            matriz[fila][columna + 1] = barco;
            matriz[fila][columna + 2] = barco;
            return true;
        }

    /**
     * Se Ubica el barco 4 en posiciones especificas
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
        private boolean colocarBarco4(int fila, int columna) {
            if (columna > TAMANO - 4 || matriz[fila][columna] != '*' || matriz[fila][columna + 1] != '*' || matriz[fila][columna + 2] != '*' || matriz[fila][columna + 3] != '*') {
                System.out.println("Espacio insuficiente o casilla ocupada");
                return false;
            }

            char barco = 'F';
            matriz[fila][columna] = barco;
            matriz[fila][columna + 1] = barco;
            matriz[fila][columna + 2] = barco;
            matriz[fila][columna + 3] = barco;
            return true;
        }

    /**
     * Realiza un disparo en la coordenada dada y devuelve el resultado ya sea '/' o '*'
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     */
        public char realizarDisparo(int fila, int columna) {
            if (fila >= 0 && fila < TAMANO && columna >= 0 && columna < TAMANO) {
                char objeto = matriz[fila][columna];
                if (objeto != '*' && objeto != '/') {
                    matriz[fila][columna] = '/'; // Marcamos el disparo en la matriz

                    return objeto; // Devuelve el tipo de barco si acertó
                } else if (objeto == '/') {
                    System.out.println("Ya disparaste aquí.");
                } else {
                    matriz[fila][columna] = '.'; // Marcamos el disparo en la matriz

                    return '*'; // No hay barco en esa posición
                }
            } else {
                System.out.println("Coordenada fuera de rango.");
            }
            return '*'; // Devuelve '*' si la coordenada estaba fuera de rango o si ya se disparó en esa posición
        }
    }

