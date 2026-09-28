package controlador;

import modelo.EmpleadoAdministrativo;
import modelo.EmpleadoBase;
import modelo.RepositorioEmpleados;
import java.util.ArrayList;

public class EmpleadoControlador {

    public static final String[] TIPOS_EMPLEADO = {"Operativo", "Administrativo"};

    private final RepositorioEmpleados repositorio;
    private final ArrayList<String> historial;

    public EmpleadoControlador() {
        this.repositorio = new RepositorioEmpleados();
        this.historial = new ArrayList<>();
        cargarDatosPrueba();
    }

    private void cargarDatosPrueba() {
        repositorio.agregar(new EmpleadoBase("101", "Carlos Pérez", 1300000));
        repositorio.agregar(new EmpleadoAdministrativo("102", "Ana Gómez", 1800000, 300000));
        historial.add("Carga inicial de datos de prueba realizada.");
    }

    public String agregarEmpleado(String cedula, String nombre, String salarioStr, String tipo, String bonificacionStr) {
        if (cedula.isEmpty() || nombre.isEmpty() || salarioStr.isEmpty()) {
            return "Error: Todos los campos obligatorios deben estar llenos.";
        }
        try {
            double salario = Double.parseDouble(salarioStr);
            EmpleadoBase nuevo;
            if ("Administrativo".equals(tipo)) {
                double bonificacion = bonificacionStr.isEmpty() ? 0 : Double.parseDouble(bonificacionStr);
                nuevo = new EmpleadoAdministrativo(cedula, nombre, salario, bonificacion);
            } else {
                nuevo = new EmpleadoBase(cedula, nombre, salario);
            }

            if (repositorio.agregar(nuevo)) {
                historial.add("Agregado empleado cédula: " + cedula);
                return "Empleado agregado correctamente.";
            } else {
                return "Error: Ya existe un empleado con la cédula " + cedula + ".";
            }
        } catch (NumberFormatException e) {
            return "Error: El salario y la bonificación deben ser números válidos.";
        }
    }

    public String actualizarEmpleado(String cedula, String nombre, String salarioStr, String tipo, String bonificacionStr) {
        if (cedula.isEmpty() || nombre.isEmpty() || salarioStr.isEmpty()) {
            return "Error: Todos los campos obligatorios deben estar llenos.";
        }
        try {
            double salario = Double.parseDouble(salarioStr);
            EmpleadoBase editado;
            if ("Administrativo".equals(tipo)) {
                double bonificacion = bonificacionStr.isEmpty() ? 0 : Double.parseDouble(bonificacionStr);
                editado = new EmpleadoAdministrativo(cedula, nombre, salario, bonificacion);
            } else {
                editado = new EmpleadoBase(cedula, nombre, salario);
            }

            if (repositorio.actualizar(editado)) {
                historial.add("Actualizado empleado cédula: " + cedula);
                return "Empleado actualizado correctamente.";
            } else {
                return "Error: No se encontró el empleado con la cédula " + cedula + ".";
            }
        } catch (NumberFormatException e) {
            return "Error: Los montos deben ser valores numéricos válidos.";
        }
    }

    public EmpleadoBase buscarEmpleado(String cedula) {
        return repositorio.buscar(cedula);
    }

    public String eliminarEmpleado(String cedula) {
        if (repositorio.eliminar(cedula)) {
            historial.add("Eliminado empleado cédula: " + cedula);
            return "Empleado eliminado correctamente.";
        }
        return "Error: No se encontró la cédula en el sistema.";
    }

    public ArrayList<EmpleadoBase> obtenerEmpleados() {
        return repositorio.listarTodos();
    }

    public ArrayList<String> obtenerHistorial() {
        return historial;
    }

    public double calcularTotalNomina() {
        double total = 0;
        for (EmpleadoBase emp : repositorio.listarTodos()) {
            total += emp.calcularSalarioTotal();
        }
        return total;
    }
}