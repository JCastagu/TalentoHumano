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
}
