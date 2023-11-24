package presentacion;

import logicaNegocio.Juego;
import logicaNegocio.Tablero;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    // Declaracion de variable//
    
    private JPanel pnlPrincipal;
    private JPanel pnlJuego;
    private Juego juego;
    private Tablero tablero = new Tablero(7);
    private boolean colocandoBarcosUsuario1 = true; 
    // Bandera para alternar entre los jugadores//

    public VentanaPrincipal(Juego juego) {

        // Constructor de la clase,inicializacion la ventana principal //
        
        this.juego = new Juego(tablero);
        tablero = this.juego.getTablero();
        tablero.cambiarEstadoVisualizacionBarcos(true);
        mostrarInfo();
        importante();
        inicializarVentana();
        construirInterfaz();
    }
    //Metodos privados para mostrar mnsajes informativos 
    private void importante() {

        //Mensaje informativo sobre las reglas del juego 
        
        JOptionPane.showMessageDialog(this, "¡Bienvenido a Batalla Naval!\n\nRECOMENDACIONES IMPORTANTES:\n- Cada letra significa el tamaño de un barco\n * Letra A: Es un barco que ocupa una casilla \n Cantidad de barcos tipo A:2 \n *Letra B: Este barco ocupa dos casillas \n Cantidad de barcos tipo B: 2 \n *Letra C: Este barco ocupa tres casillas \n Cantidad de barcos tipo C: 1  \n *Letra D: Este barco ocupa cuatro casillas \n Cantidad de barcos tipo D: 1   \n- RECOMENDACIÓN: si el barco ocupa 2 o mas casillas usted puede ubicarlo la direccion que desee.\n\n¡Diviértete!");
    }
    private void mostrarInfo() {
        // Mensaje de bienvenida e instrucciones del juego //
        JOptionPane.showMessageDialog(this, "¡Bienvenido a Batalla Naval!\n\nInstrucciones:\n- Coloca tus barcos haciendo clic en las casillas del tablero.\n- Para disparar, haz clic en las casillas del tablero del oponente.\n\n¡Diviértete!");
    }
    private void barcoNoubicado() {
        // Indica que un barco no ha sido ubicado //
        JOptionPane.showMessageDialog(this, "el barco no se ha ubicado");
    }
    private void barcosubicado() {
        // Todos los barcos han sido ubicados //
        JOptionPane.showMessageDialog(this, "Todos los barcos han sido colocados.");
    }
    private void construirInterfaz() {
        //Configuracion de la interfaz grafica del juego (tablero)
        setTitle("Batalla Naval");

        

        pnlPrincipal = new JPanel(new GridLayout(7, 7)); // Matriz de 7x7

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                JButton button = new JButton();
                button.setText("*"); // Configuramos el texto inicial como '*'

                // Agregamos un ActionListener para manejar los clics en los botones
                int finalI = i;
                int finalJ = j;
                button.addActionListener(e -> botonPresionadoUsuario1(finalI, finalJ));

                pnlPrincipal.add(button);
            }
        }

        setContentPane(pnlPrincipal);
        pack();
    }

// Inicializacion del juego y configuracion incial del tablero //
    private void iniciarJuego() {
        Tablero tablero = new Tablero(7);
        juego = new Juego(tablero);
        
         // Muestra la ubicación de los barcos al inicio
        tablero.cambiarEstadoVisualizacionBarcos(true); 
        construirInterfaz();
        tablero.cambiarEstadoVisualizacionBarcos(false);
        
        // Oculta la ubicación de los barcos para comenzar los disparos
        imprimirTablero(tablero.getMatriz());
        // Imprime la matriz con los botones en '*'
    }

    // Configuracion inicial de la ventana principal del juego//
    public void inicializarVentana() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setVisible(true);
        iniciarJuego();
    }

    // metodo para imprimir y actualizar la presentacion visual del tablero ///
    private void imprimirTablero(char[][] matriz) {
         // Limpiamos los botones anteriores antes de imprimir el nuevo tablero
        pnlJuego.removeAll();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int fila = i;
                int columna = j;
                JButton button = new JButton();

                // Establece el estado del botón según la matriz
                switch (matriz[i][j]) {
                    case '*':
                        button.setText("*"); // Casilla vacía
                        break;
                    case '/':
                        button.setText("/"); // Disparo acertado
                        break;
                    case '.':
                        button.setText("."); // Disparo fallado
                        break;
                    default:
                        button.setText(Character.toString(matriz[i][j])); // Para otros caracteres específicos (barcos)
                        break;
                }

                button.addActionListener(e -> botonPresionado(fila, columna)); // Agrega ActionListener al botón

                pnlJuego.add(button);
            }
        }

        revalidate(); // Actualizamos la interfaz después de hacer cambios
        repaint();
    }

    private int tipoBarcoActualIndex = 0; 
    // Usaremos un índice para seguir el tipo de barco actual


    // Logica para que el jugador  ubique sus barcos en el tablero //
    private void botonPresionadoUsuario1(int fila, int columna) {
        char[][] matriz = tablero.getMatriz();
        if (tipoBarcoActualIndex < juego.getTiposBarcos().length && matriz[fila][columna] == '*') {
            int tipoBarco = juego.getTiposBarcos()[tipoBarcoActualIndex];

            switch (tipoBarco) {
                case 0: // Tipo de barco 'D'
                    juego.colocarBarco(fila,columna,0);
                    tablero.actualizarUbicacionBarcos(fila, columna, 'D');
                    break;
                case 1: // Tipo de barco 'A'
                    juego.colocarBarco(fila, columna, 1);
                    tablero.actualizarUbicacionBarcos(fila, columna, 'A');

                case 2: // Tipo de barco 'C'
                    if (columna > -1) {
                        juego.colocarBarco(fila, columna, 2);
                        tablero.actualizarUbicacionBarcos(fila, columna, 'C');
                    } else {
                        barcoNoubicado();
                        return;
                    }
                    break;
                case 3: // Tipo de barco 'E'
                    if (columna > -1) {
                        juego.colocarBarco(fila, columna, 3);
                        tablero.actualizarUbicacionBarcos(fila, columna, 'E');
                    } else {
                        barcoNoubicado();
                        return;
                    }
                    imprimirTablero(matriz);
                    break;
                default:
                    break;
            }

            JButton button = (JButton) pnlPrincipal.getComponent(fila * 7 + columna);
            button.setText(String.valueOf((char) (tipoBarco + 'A'))); // Actualiza el texto del botón

            tablero.actualizarUbicacionBarcos(fila, columna, (char) (tipoBarco + 'A'));

            tipoBarcoActualIndex++; // Avanza al siguiente tipo de barco

            if (tipoBarcoActualIndex >= juego.getTiposBarcos().length) {
                // Llama al método para restablecer la visualización del tablero
                barcosubicado();
                colocandoBarcosUsuario1 = false;

                VentanaDisparos ventanaDisparos = new VentanaDisparos(juego);
                ventanaDisparos.setVisible(true);
                this.dispose();
            }
        } else {
            barcoNoubicado();
        }
    }


    //Logica para que el jugador 2 realice disparos contra el tablero del jugador 1
    private void botonPresionadoUsuario2(int fila, int columna) {
        char resultadoDisparo = juego.realizarDisparo(fila, columna);

        if (resultadoDisparo != '*') {
            System.out.println("¡Hay un barco en esa posición! (" + resultadoDisparo + ")");
        } else {
            System.out.println("No hay un barco en esa coordenada.");
        }
    }

    //Metodo para manejar el clic en un boton (dependiendo del estado del juego 
    private void botonPresionado(int fila, int columna) {

        // Maneja los clics en los botones segun el jugador activo
        if (colocandoBarcosUsuario1==true) {
            botonPresionadoUsuario1(fila, columna);
        } else {
            botonPresionadoUsuario2(fila, columna);

        }
    }
}





