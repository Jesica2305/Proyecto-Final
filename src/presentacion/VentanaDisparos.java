package presentacion;

import logicaNegocio.Juego;
import logicaNegocio.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDisparos extends JFrame {
    private JPanel pnlJuego;
    private Tablero tablero;
    private Juego juego;
    private int disparosAcertados = 0;

    public VentanaDisparos(Juego juego) {
        // Constructor de la calse VentanaDisparos
        this.juego = juego;

        // Configuración de la ventana
        setTitle("Fase de Disparos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtener el tablero del juego para la fase de disparos
        tablero = this.juego.getTablero();

        // Inicializar el panel del juego
        pnlJuego = new JPanel(new GridLayout(tablero.getTAMANO(), tablero.getTAMANO()));
        // Después de agregar botones al panel para los disparos en el constructor
        mostrarBarcos(tablero.getUbicacionBarcos());

        // Agregar botones al panel para los disparos
        for (int i = 0; i < tablero.getTAMANO(); i++) {
            for (int j = 0; j < tablero.getTAMANO(); j++) {
                JButton button = new JButton();
                button.setText("*");

                // Agregar ActionListener para manejar los disparos en los botones
                int fila = i;
                int columna = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        botonDisparoPresionado(fila, columna);
                    }
                });

                pnlJuego.add(button);
            }
        }

        // Agregar el panel al contenido de la ventana
        getContentPane().add(pnlJuego);
        pack();
    }

    private void botonDisparoPresionado(int fila, int columna) {
        char resultadoDisparo = tablero.realizarDisparo(fila, columna);

        if (resultadoDisparo != '*' && resultadoDisparo != '.') {
            System.out.println("¡Hay un barco en esa posición! (" + resultadoDisparo + ")");
            JOptionPane.showMessageDialog(this, "¡Hay un barco en esa posición! (" + resultadoDisparo + ")");
            disparosAcertados++;
            if (resultadoDisparo == '%'){
                JOptionPane.showMessageDialog(this, "¡No hay un barco en esa posición! (" + resultadoDisparo + ")");
            }
        } else {
            JOptionPane.showMessageDialog(this,"No hay un barco en esa coordenada.");
        }

        // Actualizar visualmente el tablero después del disparo
        actualizarTableroDisparos(fila, columna, resultadoDisparo, tablero.getUbicacionBarcos()[fila][columna]);
        // Verifica si se han acertado todos los disparos
        if (disparosAcertados == 13) {
            int opcion = JOptionPane.showOptionDialog(this, "¡Felicidades! ¿Quieres jugar de nuevo?", "Fin del juego",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"}, "Sí");
            if (opcion == JOptionPane.YES_OPTION) {
                // Lógica para reiniciar el juego
                // Por ejemplo, podrías cerrar la ventana actual y abrir una nueva ventana para iniciar un nuevo juego
                VentanaPrincipal nuevaVentana = new VentanaPrincipal(new Juego(new Tablero(7)));
                nuevaVentana.inicializarVentana();
                this.dispose(); // Cierra la ventana actual
            } else if (opcion == JOptionPane.NO_OPTION || opcion == JOptionPane.CLOSED_OPTION) {
                // El usuario seleccionó "No" o cerró la ventana
                this.dispose(); // Cierra la ventana actual
            }
        }
    }



    // Método para actualizar la interfaz gráfica después del disparo
    private void actualizarTableroDisparos(int fila, int columna, char resultadoDisparo, char barcoUbicado) {
        int index = fila * tablero.getTAMANO() + columna;
        JButton button = (JButton) pnlJuego.getComponent(index);

        if (resultadoDisparo != '*') {
            switch (resultadoDisparo) {
                case 'X':
                    button.setText("X"); // Disparo acertado
                    break;
                case '.':
                    button.setText("."); // Disparo fallido
                    break;
                default:
                    break;
            }
        } else if (barcoUbicado != '*') {
            
            // Mostrar el barco en el panel después del disparo
            button.setText(Character.toString(barcoUbicado));
        }
    }
    private void mostrarBarcos(char[][] ubicacionBarcos) {
        int buttonWidth = pnlJuego.getWidth() / 7; // Ancho estimado del botón en el panel
        int buttonHeight = pnlJuego.getHeight() / 7; // Alto estimado del botón en el panel

        for (int i = 0; i < ubicacionBarcos.length; i++) {
            for (int j = 0; j < ubicacionBarcos[i].length; j++) {
                char barco = ubicacionBarcos[i][j];

                if (barco != '*') {
                    Component component = pnlJuego.getComponentAt(j * buttonWidth, i * buttonHeight);
                    if (component instanceof JButton) {
                        JButton button = (JButton) component;
                        button.setText(Character.toString(barco)); // Muestra el carácter del barco
                        // También puedes configurar colores u otros estilos aquí si es necesario
                    }
                }
            }
        }
    }
}


