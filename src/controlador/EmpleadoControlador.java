package controlador;

import modelo.EmpleadoAdministrativo;
import modelo.EmpleadoBase;
import modelo.RepositorioEmpleados;
import java.util.ArrayList;

public class EmpleadoControlador {

    private final RepositorioEmpleados repositorio;

    public EmpleadoControlador() {
        this.repositorio = new RepositorioEmpleados();
        cargarDatosPrueba();
    }

    private void cargarDatosPrueba() {
        repositorio.agregar(new EmpleadoBase("101", "Carlos Pérez", 1300000));
        repositorio.agregar(new EmpleadoAdministrativo("102", "Ana Gómez", 1800000, 300000));
    }

    public boolean agregarEmpleado(EmpleadoBase empleado) {
        return repositorio.agregar(empleado);
    }

    public EmpleadoBase buscarEmpleado(String cedula) {
        return repositorio.buscar(cedula);
    }
    public boolean actualizarEmpleado(EmpleadoBase empleado) {
        return repositorio.actualizar(empleado);
    }

    public boolean eliminarEmpleado(String cedula) {
        return repositorio.eliminar(cedula);
    }

    public ArrayList<EmpleadoBase> listarEmpleados() {
        return repositorio.listarTodos();
    }

    public double calcularTotalNomina() {
        double total = 0;
        for (EmpleadoBase emp : repositorio.listarTodos()) {
            total += emp.calcularSalarioTotal();
        }
        return total;
    }
}
