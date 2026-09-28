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
}
