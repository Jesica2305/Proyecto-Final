public class Barco {
    /*
Creamos el atributo tablero
     */
    private Tablero tablero;

    /*
    Creamos el contructor que nos ayuda a inicializar tablero
     */

    public Barco(Tablero tablero) {
        this.tablero = tablero;
    }
    /*
    Creamos un metodo boolean que se llama adicionar barco, alli nos ayudara
    a psoscionar el barco dentro de la matriz y sino nos retorna un false, evaluando los diferentes casos
     */
    public boolean adicionarBarco(int f1, int c1, int tipoBarco) {
        char[][] matriz = tablero.getMatriz();

        if (!posicionValida(f1) || !posicionValida(c1)) {
            System.out.println("Posición por fuera de la matriz");
            return false;
        }
     /*
      Entra a cada uno de los casos
      */
        switch (tipoBarco) {
            case 0:
                return barco1(f1, c1, matriz);
            case 1:
                return barco2(f1, c1, matriz);
            case 2:
                return barco3(f1, c1, matriz);
            case 3:
                return barco4(f1, c1, matriz);
            default:
                System.out.println("Barco inválido");
                return false;
        }
    }
    /*
    Nos ayuda a validar si la posicion del barco este dentro de la matriz
     */
    private boolean posicionValida(int coordenada) {
        return (coordenada >= 0 && coordenada < tablero.getTAMANO());
    }
    /*
    Nos ayuda a posicionar el barco1 en la matriz con los parametros dados
     */
    private boolean barco1(int f1, int c1, char[][] matriz) {
        int fila = f1;
        int columna = c1;
        if (matriz[fila][columna] != '*') {
            System.out.println("Casilla ocupada");
            return false;
        }

        char barco = 'D';
        matriz[fila][columna] = barco;
        return true;
    }
    /*
    Nos ayuda a posicionar el barco2 en la matriz con los parametros dados
     */
    private boolean barco2(int f1, int c1, char[][] matriz) {
        int fila = f1;
        int columna = c1;
        if (fila > tablero.getTAMANO() - 2) {
            System.out.println("Espacio insuficiente");
            return false;
        }
        if (matriz[fila][columna] != '*' || matriz[fila + 1][columna] != '*') {
            System.out.println("Casilla ocupada");
            return false;
        }
        char barco = 'A';
        matriz[fila][columna] = barco;
        matriz[fila + 1][columna] = barco;
        return true;
    }
    /*
    Nos ayuda a posicionar el barco3 en la matriz con los parametros dados
     */
    private boolean barco3(int f1, int c1, char[][] matriz) {
        int fila = f1;
        int columna = c1;
        if (columna > tablero.getTAMANO() - 3) {
            System.out.println("Espacio insuficiente");
            return false;
        }
        if (matriz[fila][columna] != '*' || matriz[fila][columna + 1] != '*' || matriz[fila][columna + 2] != '*') {
            System.out.println("Casilla ocupada");
            return false;
        }
        char barco = 'C';
        matriz[f1][c1] = barco;
        matriz[f1][c1 + 1] = barco;
        matriz[f1][c1 + 2] = barco;
        return true;
    }
    /*
    Nos ayuda a posicionar el barco4 en la matriz con los parametros dados
     */
    private boolean barco4(int f1, int c1, char[][] matriz) {
        int fila = f1;
        int columna = c1;
        if (columna > tablero.getTAMANO() - 4) {
            System.out.println("Espacio insuficiente");
            return false;
        }
        if (matriz[fila][columna] != '*' || matriz[fila][columna + 1] != '*' || matriz[fila][columna + 2] != '*' || matriz[fila][columna + 3] != '*') {
            System.out.println("Casilla ocupada");
            return false;
        }

        char barco = 'F';
        matriz[fila][columna] = barco;
        matriz[fila][columna + 1] = barco;
        matriz[fila][columna + 2] = barco;
        matriz[fila][columna + 3] = barco;
        return true;
    }
}
