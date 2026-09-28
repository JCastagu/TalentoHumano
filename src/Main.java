import controlador.EmpleadoControlador;
import vista.VentanaEmpleados;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmpleadoControlador controlador = new EmpleadoControlador();
            VentanaEmpleados vista = new VentanaEmpleados(controlador);
            vista.setVisible(true);
        });
    }
}