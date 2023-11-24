package logicaNegocio;

public class Tablero {
    private char[][] matriz;
    private int TAMANO;

    public Tablero(int TAMANO) {
        this.TAMANO = TAMANO;
        matriz = new char[TAMANO][TAMANO];
        inicializarMatriz();
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public int getTAMANO() {
        return TAMANO;
    }

    public void inicializarMatriz() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                matriz[i][j] = '*';
            }
        }
    }

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

    private boolean colocarBarco1(int fila, int columna) {
        if (matriz[fila][columna] == '*') {
            matriz[fila][columna] = 'D';
            return true;
        } else {
            System.out.println("Casilla ocupada para el barco tipo D.");
            return false;
        }
    }
    private boolean colocarBarco2(int fila, int columna) {
        if (fila < getTAMANO() - 1 && matriz[fila][columna] == '*' && matriz[fila + 1][columna] == '*') {
            matriz[fila][columna] = 'A';
            matriz[fila + 1][columna] = 'A';
            return true;
        } else {
            System.out.println("Espacio insuficiente o casilla ocupada para el barco tipo A.");
            return false;
        }
    }

    private boolean colocarBarco3(int fila, int columna) {
        if (columna < getTAMANO() - 2 && matriz[fila][columna] == '*' && matriz[fila][columna + 1] == '*' && matriz[fila][columna + 2] == '*') {
            matriz[fila][columna] = 'C';
            matriz[fila][columna + 1] = 'C';
            matriz[fila][columna + 2] = 'C';
            return true;
        } else {
            System.out.println("Espacio insuficiente o casilla ocupada para el barco tipo C.");
            return false;
        }
    }

    private boolean colocarBarco4(int fila, int columna) {
        if (columna < getTAMANO() - 3 && matriz[fila][columna] == '*' && matriz[fila][columna + 1] == '*' && matriz[fila][columna + 2] == '*' && matriz[fila][columna + 3] == '*') {
            matriz[fila][columna] = 'E';
            matriz[fila][columna + 1] = 'E';
            matriz[fila][columna + 2] = 'E';
            matriz[fila][columna + 3] = 'E';
            return true;
        } else {
            System.out.println("Espacio insuficiente o casilla ocupada para el barco tipo E.");
            return false;
        }
    }

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
