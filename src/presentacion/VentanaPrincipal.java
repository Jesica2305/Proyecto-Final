package presentacion;

import logicaNegocio.Juego;
import logicaNegocio.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JPanel pnlPrincipal;
    private JPanel pnlJuego;
    private Juego juego;
    private Tablero tablero = new Tablero(7);
    private boolean colocandoBarcosUsuario1 = true; // Bandera para alternar entre los jugadores

    public VentanaPrincipal(Juego juego) {
        this.juego = new Juego(tablero);
        inicializarVentana();
        construirInterfaz();
    }

    private void construirInterfaz() {
        setTitle("Batalla Naval");

        pnlPrincipal = new JPanel(new BorderLayout());
        pnlJuego = new JPanel(new GridLayout(tablero.getTAMANO(), tablero.getTAMANO()));

        imprimirTablero(tablero.getMatriz());

        pnlPrincipal.add(pnlJuego, BorderLayout.CENTER);
        setContentPane(pnlPrincipal);
    }

    private void iniciarJuego() {
        Tablero tablero = new Tablero(7); // Ajusta el tamaño del tablero según sea necesario
        juego = new Juego(tablero); // Inicializa el juego con el tablero
        construirInterfaz();
    }

    public void inicializarVentana() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setVisible(true);
        iniciarJuego();
    }

    private void imprimirTablero(char[][] matriz) {
        pnlJuego.removeAll(); // Limpiamos los botones anteriores antes de imprimir el nuevo tablero

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int fila = i;
                int columna = j;
                JButton button = new JButton("*");

                button.addActionListener(e -> {
                    if (colocandoBarcosUsuario1) {
                        botonPresionadoUsuario1(fila, columna);
                    } else {
                        botonPresionadoUsuario2(fila, columna);
                    }
                });

                pnlJuego.add(button);
            }
        }

        revalidate(); // Actualizamos la interfaz después de hacer cambios
        repaint();
    }


    private void botonPresionadoUsuario1(int fila, int columna) {
        for (int i = 0; i < 6; i++) {
            boolean barcoColocado = juego.colocarBarco(fila, columna, i);
            System.out.print("Ingrese la coordenada del barco " + (i + 1) + " (fila columna): ");
            if (barcoColocado) {
                int numero = juego.getTamBarcos();
                boton(fila,columna, numero);
                return;
            } else {
                System.out.println("No se pudo colocar el barco en esta posición.");
            }
        }
    }

    private void botonPresionadoUsuario2(int fila, int columna) {
        char resultadoDisparo = juego.realizarDisparo(fila, columna);

        if (resultadoDisparo != '*') {
            System.out.println("¡Hay un barco en esa posición! (" + resultadoDisparo + ")");
        } else {
            System.out.println("No hay un barco en esa coordenada.");
        }
    }

    /**
     * private boolean realizarMovimientoUsuario1(int x, int y) {
     * if (colocandoBarcosUsuario1) {
     * boolean barcoColocado = juego.colocarBarco(x, y);
     * imprimirTablero(tablero.getMatriz());
     * <p>
     * return barcoColocado;
     * }
     * return false;
     * }
     **/
    private char realizarDisparoUsuario2(int x, int y) {
        char resultadoDisparo = tablero.getMatriz()[x][y];
        imprimirTablero(tablero.getMatriz());

        return resultadoDisparo;
    }

    private JButton boton(int fila, int columna, int numero) {

        JButton button = (JButton) pnlJuego.getComponent(fila * tablero.getTAMANO() + columna);
        switch (numero) {
            case 0:
                button = (JButton) pnlJuego.getComponent(fila * tablero.getTAMANO() + columna);
                button.setText("D"); // Cambiamos el texto del botón al tipo de barco colocado
                return button;
            case 1:
                button = (JButton) pnlJuego.getComponent(fila * tablero.getTAMANO() + columna);
                button.setText("A"); // Cambiamos el texto del botón al tipo de barco colocado
                return button;
            case 2:
                button = (JButton) pnlJuego.getComponent(fila * tablero.getTAMANO() + columna);
                button.setText("C"); // Cambiamos el texto del botón al tipo de barco colocado
                return button;
            case 3:
                button = (JButton) pnlJuego.getComponent(fila * tablero.getTAMANO() + columna);
                button.setText("B"); // Cambiamos el texto del botón al tipo de barco colocado
                return button;
        }
        return button;
    }
}
    /**public VentanaPrincipal(Juego juego) {
        this.juego = new Juego(tablero);
        inicializarVentana();
    }





    private void construirInterfaz() {
        setTitle("Batalla Naval");

        pnlPrincipal = new JPanel(new BorderLayout());
        pnlJuego = new JPanel(new GridLayout(tablero.getTAMANO(), tablero.getTAMANO()));

        imprimirTablero(tablero.getMatriz());

        pnlPrincipal.add(pnlJuego, BorderLayout.CENTER);
        setContentPane(pnlPrincipal);
    }

// En la clase VentanaPrincipal, dentro del método imprimirTablero

    private void imprimirTablero(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int fila = i;
                    public void actionPerformed(ActionEvent e) {
                        // Llamamos a un método en VentanaPrincipal para manejar la interacción
                        botonPresionado(fila, columna);
                    }
                });

                pnlJuego.add(button);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        botonPresionado(fila1, columna1);
                    }
                });
            }
        }
    }

// Agregamos un método en VentanaPrincipal para manejar la lógica de interacción

    private void botonPresionado(int fila, int columna) {
        // Aquí llamamos a los métodos del juego y tablero para realizar la acción
        boolean barcoColocado = realizarMovimiento(fila, columna);
        imprimirTablero(tablero.getMatriz());

        JButton button = (JButton) pnlJuego.getComponent(fila * tablero.getTAMANO() + columna);

        if (barcoColocado) {
            button.setText("B");
            button.setEnabled(false);
        } else {
            System.out.println("No se pudo colocar el barco en esta posición.");
        }
    }

    private boolean realizarMovimiento(int x, int y) {
        boolean barcoColocado = juego.colocarBarco(x, y);
        imprimirTablero(tablero.getMatriz());

        JButton button = (JButton) pnlJuego.getComponent(x * tablero.getTAMANO() + y);

        if (barcoColocado==true) {
            button.setText("B"); // Cambiar la representación visual para indicar un barco
            button.setEnabled(false); // Deshabilitar el botón para no permitir más colocación en esa casilla
        } else {
            System.out.println("No se pudo colocar el barco en esta posición.");
        }
        return false;
    }
}
**/






