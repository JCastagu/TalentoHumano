package modelo;
import java.util.HashMap;
import java.util.Map;

public class RepositorioEmpleados {
    private final Map<String, EmpleadoBase> empleados = new HashMap<>();
    public void guardar(EmpleadoBase emp) {
        empleados.put(emp.getCedula(), emp);
    }
    public EmpleadoBase buscarPorCedula(String cedula) {
        return empleados.get(cedula);
    }
    public boolean eliminar(String cedula) {
        return empleados.remove(cedula) != null;
    }

    public java.util.Collection<EmpleadoBase> obtenerTodos() {
        return empleados.values();
    }

    public boolean existeCedula(String cedula) {
        return empleados.containsKey(cedula);
    }
}
