public class Tablero {
    private char[][] matriz;
    private int TAMANO;

    /**
     * Constructor que recibe el tamaño del tablero como parametro
     * Inicializa la matriz con el tamaño especificado
     * Complejidad Temporal: O(1) Tiempo constante
     */
    public Tablero(int TAMANO) {
        this.TAMANO = TAMANO;
        matriz = new char[TAMANO][TAMANO];
        inicializarMatriz();
    }
    /**
     * Método para obtener la matriz
     * @return Retorna la matriz
     * Complejidad Temporal: O(1) Tiempo constante
     */
    public char[][] getMatriz() {
        return matriz;
    }

    /**
     * Método para obtener el tamaño
     * @return Retorna el tamaño
     * Complejidad Temporal: O(1) Tiempo constante
     */
    public int getTAMANO() {
        return TAMANO;
    }

    /**
     * Se inicia la matriz con asteriscos
     * Complejidad Temporal: O(N^2) Complejidad cuadrática
     */
    public void inicializarMatriz() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                matriz[i][j] = '*';
            }
        }
    }

    /**
     * Se imprime la matriz
     * Complejidad Temporal: O(N^2) Complejidad cuadrática
     */
    public void imprimirMatriz() {
        System.out.println("Matriz con barcos:");
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }


    public boolean disparos (int filaUsuario, int columnaUsuario) {
        if (filaUsuario >= 0 && filaUsuario < TAMANO && columnaUsuario >= 0 && columnaUsuario < TAMANO) {
            char objeto = matriz[filaUsuario][columnaUsuario];
            if (objeto == '/') {
                System.out.println("Usted ya disparo aqui!");
                return false;
            }
            if (objeto == '.') {
                System.out.println("Usted ya disparo aqui!");
                return false;//Devuelve false si dispara en una coordenada que ya disparo
            }
            if (objeto != '*') {
                System.out.println("¡Hay un barco en esa coordenada! (" + objeto + ")");
                matriz[filaUsuario][columnaUsuario] = '/';

                return true; // Devuelve true si se acertó un barco
            }
            else {
                System.out.println("No hay un barco en esa coordenada.");
                matriz[filaUsuario][columnaUsuario] = '.';
            }
        } else {
            System.out.println("Coordenada fuera de rango.");
        }
        return false; // Devuelve false si no se acertó un barco o la coordenada estaba fuera de rango
    }
}
