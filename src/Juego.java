public class Juego {

    private Tablero tablero;
    private Barco barco;
   public Juego (Tablero tablero, Barco barco){
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

    private int tamBarcos = tiposBarcos.length;

    public int[] getTiposBarcos() {
        return tiposBarcos;
    }

    public int getTamBarcos() {
        return tamBarcos;
    }

    public String[] getMensajes() {
        return mensajes;
    }
}


