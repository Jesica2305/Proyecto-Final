    package logicaNegocio;

    public class Tablero {
        private char[][] matriz;
        private char[][] ubicacionBarcos;
        private char[][] matrizDisparos;
        private int TAMANO;

        public Tablero(int TAMANO) {
            this.TAMANO = TAMANO;
            matriz = new char[TAMANO][TAMANO];
            ubicacionBarcos = new char[TAMANO][TAMANO];
            matrizDisparos = new char[TAMANO][TAMANO];
            inicializarMatrices();
        }

        public char[][] getMatriz() {
            return matriz;
        }


        public int getTAMANO() {
            return TAMANO;
        }
        public char[][] getUbicacionBarcos() {
            return ubicacionBarcos;
        }

        public void inicializarMatrices() {
            for (int i = 0; i < TAMANO; i++) {
                for (int j = 0; j < TAMANO; j++) {
                    matriz[i][j] = '*';
                    ubicacionBarcos[i][j]= '*';
                    matrizDisparos [i][j]= '*';
                }
            }
        }

        public void actualizarUbicacionBarcos(int fila, int columna, char tipoBarco) {
            ubicacionBarcos[fila][columna] = tipoBarco;
        }
        public void cambiarEstadoVisualizacionBarcos(boolean mostrar) {
            if (mostrar) {
                matriz = ubicacionBarcos.clone(); // Muestra la ubicación de los barcos
            } else {
                matriz = new char[TAMANO][TAMANO]; // Oculta la ubicación de los barcos
                for (int i = 0; i < TAMANO; i++) {
                    for (int j = 0; j < TAMANO; j++) {
                        matriz[i][j] = ubicacionBarcos[i][j] == '*' ? '*' : '.'; // Mantiene los disparos
                    }
                }
            }
        }
        public int adicionarBarco(int fila, int columna, int tipoBarco) {
            switch (tipoBarco) {
                case 0:
                    return colocarBarco1(fila, columna); // Indica que se colocó un barco tipo 0
                case 1:
                        return colocarBarco2(fila, columna); // Indica que se colocó un barco tipo 1
                case 2:
                        return (colocarBarco3(fila, columna)); // Indica que se colocó un barco tipo 2
                case 3:
                        return colocarBarco4(fila, columna); // Indica que se colocó un barco tipo 3
                default:
                    System.out.println("Barco inválido");
                    return -1; // Indica un valor no válido
            }
        }

        private int colocarBarco1(int fila, int columna) {
            if (matriz[fila][columna] == '*') {
                matriz[fila][columna] = 'D';
                return 0;
            } else {
                System.out.println("Casilla ocupada para el barco tipo D.");
                return -1;
            }
        }

        private int colocarBarco2(int fila, int columna) {
            if (fila < getTAMANO() - 1 && matriz[fila][columna] == '*') {
                matriz[fila][columna] = 'A';
                return 1;
            } else {
                System.out.println("Espacio insuficiente o casilla ocupada para el barco tipo A.");
                return -1;
            }
        }
        private int colocarBarco3(int fila, int columna) {
            if (columna < getTAMANO() - 2 && matriz[fila][columna] == '*') {
                matriz[fila][columna] = 'C';
                return 2;
            } else {
                System.out.println("Espacio insuficiente o casilla ocupada para el barco tipo C.");
                return -1;
            }
        }

        private int colocarBarco4(int fila, int columna) {
            if (columna < getTAMANO() - 3 && matriz[fila][columna] == '*' ) {
                matriz[fila][columna] = 'E';

                return 3;
            } else {
                System.out.println("Espacio insuficiente o casilla ocupada para el barco tipo E.");
                return -1;
            }
        }
        public char realizarDisparo(int fila, int columna) {
            if (fila >= 0 && fila < TAMANO && columna >= 0 && columna < TAMANO) {
                char objetoBarcos = matriz[fila][columna];
                char objetoDisparos = matrizDisparos[fila][columna];

                if (objetoBarcos != '*' && objetoBarcos != '/') {
                    objetoDisparos = 'X'; // 'X' para indicar un disparo acertado
                    objetoBarcos = '/'; // Marcar la ubicación del barco como disparada
                } else {
                    objetoDisparos = '%'; // '.' para indicar un disparo fallido
                }

                matrizDisparos[fila][columna] = objetoDisparos; // Actualizar matriz de disparos

                return objetoDisparos != '*' ? objetoDisparos : objetoBarcos; // Devolver el tipo de barco si acertó o el resultado del disparo
            } else {
                System.out.println("Coordenada fuera de rango.");
                return '*'; // Devolver '*' si la coordenada estaba fuera de rango
            }
        }

    }
