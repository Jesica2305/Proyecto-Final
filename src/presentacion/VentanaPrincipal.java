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

    public VentanaPrincipal(Juego juego) {
        this.juego = new Juego(tablero);
        inicializarVentana();
    }

    private void iniciarJuego() {
        Tablero tablero = new Tablero(7); // Ajusta el tamaño del tablero según sea necesario
        juego = new Juego(tablero); // Inicializa el juego con el tablero
    }

    public void inicializarVentana() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setVisible(true);
    }

    private void construirInterfaz() {
        setTitle("Batalla Naval");

        pnlPrincipal = new JPanel(new BorderLayout());
        pnlJuego = new JPanel(new GridLayout(tablero.getTAMANO(), tablero.getTAMANO()));

        imprimirTablero(tablero.getMatriz());

        pnlPrincipal.add(pnlJuego, BorderLayout.CENTER);
        setContentPane(pnlPrincipal);
    }

    private void imprimirTablero(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int fila = i;
                int columna = j;
                JButton button = new JButton("*");

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        realizarMovimiento(fila, columna);
                    }
                });

                pnlJuego.add(button);
            }
        }
    }

    private void realizarMovimiento(int x, int y) {
        boolean barcoColocado = juego.colocarBarco(x, y);
        imprimirTablero(tablero.getMatriz());

        JButton button = (JButton) pnlJuego.getComponent(x * tablero.getTAMANO() + y);

        if (barcoColocado) {
            button.setText("B"); // Cambiar la representación visual para indicar un barco
            button.setEnabled(false); // Deshabilitar el botón para no permitir más colocación en esa casilla
        } else {
            System.out.println("No se pudo colocar el barco en esta posición.");
        }
    }
}






