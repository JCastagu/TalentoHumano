package vista;

import controlador.EmpleadoControlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaEmpleados extends JFrame {

    private final EmpleadoControlador controlador;

    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtSalarioBase;
    private JTextField txtBonificacion;
    private JComboBox<String> cbTipoEmpleado;
    private JTable tablaEmpleados;
    private DefaultTableModel modeloTabla;
    private JLabel lblTotalNomina;

    public VentanaEmpleados() {
        controlador = new EmpleadoControlador();
    }
}